package com.bytedance.android.lesson.restapi.solution.bean;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;

/**
 * @author Xavier.S
 * @date 2019.01.20 14:18
 */
public class Feed {

    // TODO-C2 (1) Implement your Feed Bean here according to the response json


    /**
     * @author Xavier.S
     * @date 2019.01.20 14:18
     */
    @SerializedName("student_id")
    public String student_id;
    @SerializedName("user_name")
    public String user_name;
    @SerializedName("image_url")
    public String image_url;
    @SerializedName("video_url")
    public String video_url;

    public String getImage_url(){
        return image_url;
    }
    public void setImage_url(String s){
        image_url=s;

    }
    @Override public String toString() {
        return "Value{" +
                "student_id" + student_id +
                "user_name=" + user_name +
                ", image_url='" + image_url +
                ", video_url='" + video_url +
                '}';
    }
}
