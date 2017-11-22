// (c)2016 Flipboard Inc, All Rights Reserved.

package com.coder.guoy.recyclerview.ui.cache;

import com.coder.guoy.recyclerview.App;
import com.coder.guoy.recyclerview.api.bean.ImageBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.List;

public class Database {
    private static String DATA_FILE_NAME = "tuku_data.db";

    private static Database INSTANCE;

    File dataFile = new File(App.getInstance().getFilesDir(), DATA_FILE_NAME);
    Gson gson = new Gson();

    private Database() {
    }

    public static Database getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Database();
        }
        return INSTANCE;
    }

    public List<ImageBean> readItems() {
        // Hard code adding some delay, to distinguish reading from memory and reading disk clearly
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Reader reader = new FileReader(dataFile);
            return gson.fromJson(reader, new TypeToken<List<ImageBean>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void writeItems(List<ImageBean> items) {
        String json = gson.toJson(items);
        try {
            if (!dataFile.exists()) {
                try {
                    dataFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Writer writer = new FileWriter(dataFile);
            writer.write(json);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        dataFile.delete();
    }
}
