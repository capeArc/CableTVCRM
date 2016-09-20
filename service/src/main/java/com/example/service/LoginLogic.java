package com.example.service;

import android.app.Activity;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pavan on 9/16/2016.
 */
public class LoginLogic {

    AQuery aq;
    Activity refactivity;

    Map<String, Void> params = new HashMap<K, V>();

    public LoginLogic(Activity activity) {

        aq = new AQuery(activity);
        refactivity = activity;
        post();
    }

    public void post() {
        aq.ajax("http://cphapi.capearc.local/CablePayHomeService.svc/Authenticate", JSONObject.class, refactivity, "jsoncallback");

        String stringentity = "{\n" +
                "  \"Token\": \"aKFhVsGgGftCeCc8TTr\\/26P\\/xmW1COrGiEIuxsPIL7FQgn6GWQWPw3+ZYZtHU1j9\",\n" +
                "  \"EntitySet\": [\n" +
                "    {\n" +
                "      \"Password\": \"1234\"\n" +
                "    }\n" +
                "  ]\n" +
                "}\n";

        params.put(AQuery.POST_ENTITY, createStringEntity(stringentity));


    }

    public void jsonCallback(String url, JSONObject json, AjaxStatus status) {

        if (json != null) {
            Toast.makeText(refactivity, ""+json, Toast.LENGTH_SHORT).show();
        } else {
            //ajax error
        }
    }

    public Void createStringEntity(String str) {

        JSONObject data = null;
        try {
            data = new JSONObject(str).getJSONObject("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }
// get a JSONArray from inside an object
        try {
            JSONArray translations = data.getJSONArray("translations");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }






}
