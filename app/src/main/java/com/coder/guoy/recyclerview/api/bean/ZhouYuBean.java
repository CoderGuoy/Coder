package com.coder.guoy.recyclerview.api.bean;

import java.util.List;

/**
 * @Version:
 * @Author:Guoy
 * @CreateTime:2017/8/10
 * @Descrpiton:
 */
public class ZhouYuBean {

    /**
     * code : 0
     * msg : 5
     * obj : [{"cSRQ":"1968-11-07","cZZZ":"广东省东莞市东城区东城中路南123号3栋401号","fWCS":"主山社区","gJ":"中国","gMSFZBH":"442527196811070888","hH":"087017034","hKDZ":"广东省东莞市东城区东城中路南123号3栋401号","iD":"1","lXFS":"22471396","mZ":"汉族","nL":"47","qHBM":"441901003016","qHMC":"主山社区","sFLDRK":"0","sSJD":"东城街道","sSSQ":"主山社区","sSXQ":"主山社区","xB":"女","xM":"邓桂芳","yHZGX":"02","zJLX":"身份证"},{"bSXQTZZ":"广东省东莞市东城区","cSRQ":"1980-08-17","cZZZ":"广东省东莞市东城区主山新三杞1巷19号","gJ":"中国","gMSFZBH":"422130198008174321","hKDZ":"湖北省黄冈市黄梅县","hYZK":"90","iD":"141488","mZ":"汉族","nL":"35","qHBM":"441901003016","qHMC":"主山社区","sFLDRK":"1","sG":"0","sSJD":"东城街道","sSSQ":"公安分局","wHCD":"其他","xB":"女","xM":"邓桂芳","zJLX":"身份证"},{"bSXQTZZ":"广东省东莞市东城区","cSRQ":"1981-11-06","cZZZ":"广东省东莞市东城区星城居委会花园城听竹轩6幢1座502号","gJ":"中国","gMSFZBH":"440981198111061443","hKDZ":"广东省茂名市高州市","hYZK":"20","iD":"327383","lXFS":"13827231969","mZ":"汉族","nL":"34","qHBM":"441901003023","qHMC":"星城社区","sFLDRK":"1","sG":"156","sJHM":"13827231969","sSJD":"东城街道","sSSQ":"公安分局","wHCD":"大学专科教育","xB":"女","xM":"邓桂芳","zJLX":"身份证","zZMM":"13"},{"bSXQTZZ":"广东省东莞市东城区","cSRQ":"1977-05-21","cZZZ":"广东省东莞市东城区牛山上山门中心路4号湖豪灯饰厂宿舍","gJ":"中国","gMSFZBH":"511022197705213446","hKDZ":"广东省东莞市虎门港","hYZK":"90","iD":"512207","mZ":"汉族","nL":"38","qHBM":"441901003020","qHMC":"牛山社区","sFLDRK":"1","sG":"0","sSJD":"东城街道","sSSQ":"公安分局","wHCD":"其他","xB":"女","xM":"邓桂芳","zJLX":"身份证"},{"cSRQ":"1980-08-17","cZZZ":"新三杞1巷19号","fWCS":"主山","gJ":"中国","gMSFZBH":"422130800817432","hKDZ":"湖北省黄梅县张河乡卢列村十一组","hYZK":"20","iD":"828821","mZ":"汉族","nL":"35","qHBM":"441901003016","qHMC":"主山社区","sFLDRK":"1","sSJD":"东城街道","sSSQ":"新莞人","sSXQ":"主山","wHCD":"初级中学教育","xB":"女","xM":"邓桂芳","zJLX":"身份证","zWZC":"工人","zZMM":"13"}]
     */

    private String code;
    private String msg;
    private List<ObjBean> obj;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * cSRQ : 1968-11-07
         * cZZZ : 广东省东莞市东城区东城中路南123号3栋401号
         * fWCS : 主山社区
         * gJ : 中国
         * gMSFZBH : 442527196811070888
         * hH : 087017034
         * hKDZ : 广东省东莞市东城区东城中路南123号3栋401号
         * iD : 1
         * lXFS : 22471396
         * mZ : 汉族
         * nL : 47
         * qHBM : 441901003016
         * qHMC : 主山社区
         * sFLDRK : 0
         * sSJD : 东城街道
         * sSSQ : 主山社区
         * sSXQ : 主山社区
         * xB : 女
         * xM : 邓桂芳
         * yHZGX : 02
         * zJLX : 身份证
         * bSXQTZZ : 广东省东莞市东城区
         * hYZK : 90
         * sG : 0
         * wHCD : 其他
         * sJHM : 13827231969
         * zZMM : 13
         * zWZC : 工人
         */

        private String cSRQ;
        private String cZZZ;
        private String fWCS;
        private String gJ;
        private String gMSFZBH;
        private String hH;
        private String hKDZ;
        private String iD;
        private String lXFS;
        private String mZ;
        private String nL;
        private String qHBM;
        private String qHMC;
        private String sFLDRK;
        private String sSJD;
        private String sSSQ;
        private String sSXQ;
        private String xB;
        private String xM;
        private String yHZGX;
        private String zJLX;
        private String bSXQTZZ;
        private String hYZK;
        private String sG;
        private String wHCD;
        private String sJHM;
        private String zZMM;
        private String zWZC;

        public String getCSRQ() {
            return cSRQ;
        }

        public void setCSRQ(String cSRQ) {
            this.cSRQ = cSRQ;
        }

        public String getCZZZ() {
            return cZZZ;
        }

        public void setCZZZ(String cZZZ) {
            this.cZZZ = cZZZ;
        }

        public String getFWCS() {
            return fWCS;
        }

        public void setFWCS(String fWCS) {
            this.fWCS = fWCS;
        }

        public String getGJ() {
            return gJ;
        }

        public void setGJ(String gJ) {
            this.gJ = gJ;
        }

        public String getGMSFZBH() {
            return gMSFZBH;
        }

        public void setGMSFZBH(String gMSFZBH) {
            this.gMSFZBH = gMSFZBH;
        }

        public String getHH() {
            return hH;
        }

        public void setHH(String hH) {
            this.hH = hH;
        }

        public String getHKDZ() {
            return hKDZ;
        }

        public void setHKDZ(String hKDZ) {
            this.hKDZ = hKDZ;
        }

        public String getID() {
            return iD;
        }

        public void setID(String iD) {
            this.iD = iD;
        }

        public String getLXFS() {
            return lXFS;
        }

        public void setLXFS(String lXFS) {
            this.lXFS = lXFS;
        }

        public String getMZ() {
            return mZ;
        }

        public void setMZ(String mZ) {
            this.mZ = mZ;
        }

        public String getNL() {
            return nL;
        }

        public void setNL(String nL) {
            this.nL = nL;
        }

        public String getQHBM() {
            return qHBM;
        }

        public void setQHBM(String qHBM) {
            this.qHBM = qHBM;
        }

        public String getQHMC() {
            return qHMC;
        }

        public void setQHMC(String qHMC) {
            this.qHMC = qHMC;
        }

        public String getSFLDRK() {
            return sFLDRK;
        }

        public void setSFLDRK(String sFLDRK) {
            this.sFLDRK = sFLDRK;
        }

        public String getSSJD() {
            return sSJD;
        }

        public void setSSJD(String sSJD) {
            this.sSJD = sSJD;
        }

        public String getSSSQ() {
            return sSSQ;
        }

        public void setSSSQ(String sSSQ) {
            this.sSSQ = sSSQ;
        }

        public String getSSXQ() {
            return sSXQ;
        }

        public void setSSXQ(String sSXQ) {
            this.sSXQ = sSXQ;
        }

        public String getXB() {
            return xB;
        }

        public void setXB(String xB) {
            this.xB = xB;
        }

        public String getXM() {
            return xM;
        }

        public void setXM(String xM) {
            this.xM = xM;
        }

        public String getYHZGX() {
            return yHZGX;
        }

        public void setYHZGX(String yHZGX) {
            this.yHZGX = yHZGX;
        }

        public String getZJLX() {
            return zJLX;
        }

        public void setZJLX(String zJLX) {
            this.zJLX = zJLX;
        }

        public String getBSXQTZZ() {
            return bSXQTZZ;
        }

        public void setBSXQTZZ(String bSXQTZZ) {
            this.bSXQTZZ = bSXQTZZ;
        }

        public String getHYZK() {
            return hYZK;
        }

        public void setHYZK(String hYZK) {
            this.hYZK = hYZK;
        }

        public String getSG() {
            return sG;
        }

        public void setSG(String sG) {
            this.sG = sG;
        }

        public String getWHCD() {
            return wHCD;
        }

        public void setWHCD(String wHCD) {
            this.wHCD = wHCD;
        }

        public String getSJHM() {
            return sJHM;
        }

        public void setSJHM(String sJHM) {
            this.sJHM = sJHM;
        }

        public String getZZMM() {
            return zZMM;
        }

        public void setZZMM(String zZMM) {
            this.zZMM = zZMM;
        }

        public String getZWZC() {
            return zWZC;
        }

        public void setZWZC(String zWZC) {
            this.zWZC = zWZC;
        }
    }
}
