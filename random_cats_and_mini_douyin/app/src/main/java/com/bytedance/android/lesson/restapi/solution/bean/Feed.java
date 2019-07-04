package com.bytedance.android.lesson.restapi.solution.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author Xavier.S
 * @date 2019.01.20 14:18
 */
public class Feed {

    // TODO-C2 (1) Implement your Feed Bean here according to the response json

    public String student_id;
    public String user_name;
    public String image_url;
    public String video_url;

    public String getImage_url(){
        return image_url;
    }
    public void setImage_url(String s){
        image_url=s;

    }
}
