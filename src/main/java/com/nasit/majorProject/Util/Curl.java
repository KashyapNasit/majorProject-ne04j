package com.nasit.majorProject.Util;

import com.squareup.okhttp.*;
import io.swagger.v3.oas.annotations.servers.Server;
import net.minidev.json.JSONObject;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


@Server
public class Curl {
    private String url;
    private String response;
    private JSONObject jsonObject = new JSONObject();
    private static Curl curl;
    private String method = "POST";
    private HashMap<String,String> getParam;

    public Curl setGetParam(HashMap<String, String> getParam) {
        this.getParam = getParam;
        return this;
    }

    public static Curl getCurl(){
        if(curl == null)
            return new Curl();
        return curl;

    }

    public void setMethod(String method){
        this.method = method;
    }

    private Curl(){

    }
    public String getResponse() {
        return response;
    }

    public Curl setUrl(String url) {
        this.url = url;
        return this;
    }

    public Curl setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
        return this;
    }

    public void execute() throws IOException {
        OkHttpClient client = new OkHttpClient();
        String bodyString = null;
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonObject.toJSONString());
        if(this.method=="GET"){
            body=null;
        }
        Request request = new Request.Builder()
                .url(this.url)
                .method(this.method, body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        this.response = response.body().string();
    }

    public String execute(JSONObject jsonObject, String method, String URL ) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonObject.toJSONString());
        Request request = new Request.Builder()
                .url(URL)
                .method(method, body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

//    public static void main(String[] args) {
//        Curl curl = new Curl();
//        curl.setUrl("https://mdm.sahajbamba.me/getcpi");
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("regno","20174038");
//        curl.setJsonObject(jsonObject);
//        try {
//            curl.execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Gson gson = new Gson();
//        CPI[] s = gson.fromJson(curl.getResponse(), CPI[].class);
//        System.out.println(s[0].getCpi());
//    }
}
