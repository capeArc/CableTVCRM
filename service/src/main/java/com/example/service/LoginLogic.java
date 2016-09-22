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

import JsonParser.JsonParser;

/**
 * Created by Pavan on 9/16/2016.
 */
public class LoginLogic implements JsonParser {

    AQuery aq;
    Activity refactivity;


    public LoginLogic(Activity activity) {

        aq = new AQuery(activity);
        refactivity = activity;
        post();
    }

    public void post() {


    }


    @Override
    public JSONObject jsonParser() {
        JSONObject jsonTokenobj=new JSONObject();

        try {
            jsonTokenobj.put("Token","aKFhVsGgGftCeCc8TTr26PxmW1COrGiEIuxsPIL7FQgn6GWQWPw3+ZYZtHU1j9");

            JSONObject jsonEntityobj=new JSONObject();
            jsonEntityobj.put("password","1234");
            jsonTokenobj.put("EntitySet",jsonEntityobj);
             JSONObject  result=new JSONObject();



        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  jsonTokenobj;
    }
}
