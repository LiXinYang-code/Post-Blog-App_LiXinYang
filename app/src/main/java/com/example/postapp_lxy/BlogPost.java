package com.example.postapp_lxy;

public class BlogPost {

    public String user_id,image_url,desc,image_thunmb,user_name;
    public String timestamp;

    public BlogPost(){}

    //constructors:
    public BlogPost(String user_id,String image_thunmb,String desc,String image_url,String timestamp,String user_name){

        this.user_id = user_id;
        this.image_url = image_url;
        this.desc = desc;
        this.image_thunmb = image_thunmb;
        this.timestamp = timestamp;

        //new changed
        this.user_name = user_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getDesc() {
        return desc;
    }

    public String getImage_thunmb() {
        return image_thunmb;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getUser_id() {
        return user_id;
    }


    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImage_thunmb(String image_thunmb) {
        this.image_thunmb = image_thunmb;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {this.user_name = user_name;}

    public String getTimestamp() {
        return timestamp;
    }

}
