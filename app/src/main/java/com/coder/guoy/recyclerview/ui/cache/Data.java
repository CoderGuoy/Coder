// (c)2016 Flipboard Inc, All Rights Reserved.

package com.coder.guoy.recyclerview.ui.cache;

import android.support.annotation.IntDef;
import android.support.annotation.NonNull;

import com.coder.guoy.recyclerview.Constants;
import com.coder.guoy.recyclerview.api.bean.ImageBean;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;

public class Data {
    private static Data instance;
    private static final int DATA_SOURCE_MEMORY = 1;
    private static final int DATA_SOURCE_DISK = 2;
    private static final int DATA_SOURCE_NETWORK = 3;

    @IntDef({DATA_SOURCE_MEMORY, DATA_SOURCE_DISK, DATA_SOURCE_NETWORK})
    @interface DataSource {
    }

    BehaviorSubject<List<ImageBean>> cache;

    private int dataSource;

    private Data() {
    }

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

    private void setDataSource(@DataSource int dataSource) {
        this.dataSource = dataSource;
    }

    public void loadFromNetwork(final String url) {
        Observable<List<ImageBean>> observable = Observable.create(new Observable.OnSubscribe<List<ImageBean>>() {
            @Override
            public void call(Subscriber<? super List<ImageBean>> subscriber) {
                List<ImageBean> list = new ArrayList<>();
                try {
                    Document document = Jsoup.connect(url).get();
                    Elements main_cont = document.getElementsByClass("main_cont");
                    Document parse = Jsoup.parse(main_cont.toString());
                    Element imageLists = parse.getElementsByClass("list_cont list_cont1 w1180").get(0);
                    Elements li = imageLists.select("li");
                    for (Element imageList : li) {
                        //详细页连接
                        String linkUrl = imageList.select("a").first().attr("href");
                        if (!linkUrl.startsWith(Constants.BZ_URl)) {
                            linkUrl = Constants.BZ_URl + linkUrl.substring(1);
                        }
                        //图片标题
                        String imgaeTitle = imageList.select("p").text();

                        Document document2 = Jsoup.connect(linkUrl).get();
                        Elements main_cont2 = document2.getElementsByClass("pic_main");
                        Document parse2 = Jsoup.parse(main_cont2.toString());
                        Elements imageLists2 = parse2.getElementsByClass("pic-meinv");
                        //图片地址
                        String imgUrl = imageLists2.select("img").first().attr("src");

                        list.add(new ImageBean(linkUrl, imgUrl, imgaeTitle));
                    }
                    subscriber.onNext(list);
                    subscriber.onCompleted();
                } catch (IOException e) {
                    subscriber.onError(e);
                }
            }
        });

        observable
                .subscribeOn(Schedulers.io())
                .doOnNext(new Action1<List<ImageBean>>() {
                    @Override
                    public void call(List<ImageBean> imageBeen) {
                        //写入磁盘缓存
                        Database.getInstance().writeItems(imageBeen);
                    }
                })
                .subscribe(new Action1<List<ImageBean>>() {
                    @Override
                    public void call(List<ImageBean> imageBeen) {
                        //写入内存缓存
                        cache.onNext(imageBeen);
                        cache.onCompleted();
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        cache.onError(throwable);
                    }
                });
    }

    public Subscription subscribeData(@NonNull Observer<List<ImageBean>> observer, final String url) {
        if (cache == null) {
            cache = BehaviorSubject.create();
            Observable.create(new Observable.OnSubscribe<List<ImageBean>>() {
                @Override
                public void call(Subscriber<? super List<ImageBean>> subscriber) {
                    List<ImageBean> items = Database.getInstance().readItems();
                    if (items == null) {
                        setDataSource(DATA_SOURCE_NETWORK);
                        loadFromNetwork(url);
                    } else {
                        setDataSource(DATA_SOURCE_DISK);
                        subscriber.onNext(items);
                    }
                }
            })
                    .subscribeOn(Schedulers.io())
                    .subscribe(cache);
        } else {
            setDataSource(DATA_SOURCE_MEMORY);
        }
        return cache
                .doOnError(new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        cache = null;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    public void clearMemoryCache() {
        cache = null;
    }

    public void clearMemoryAndDiskCache() {
        clearMemoryCache();
        Database.getInstance().delete();
    }
}
