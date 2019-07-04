package com.bytedance.android.lesson.restapi.solution.bean;

import android.location.Address;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xavier.S
 * @date 2019.01.17 18:08
 */
public class Cat {

    // TODO-C1 (1) Implement your Cat Bean here according to the response json

    @SerializedName("breeds")
    List<String> breeds;
    @SerializedName("id")
    String id;
    @SerializedName("url")
    String url;
    @SerializedName("width")
    int  width;
    @SerializedName("height")
    int  height;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
