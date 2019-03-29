package com.weatherassignmentapplication.data;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Webservice {
    @GET("/v1/current.json?key=23f8d0450ac946e58ae155120192803&q=Pune")
    Call<ResponseBody> jquery();
}
