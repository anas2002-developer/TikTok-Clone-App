package com.anas.firebasetiktok;

public class Model_Video {

    String Desc,Title,Url;

    Model_Video(){


    }

    public Model_Video(String desc, String title, String url) {
        Desc = desc;
        Title = title;
        Url = url;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
