package com.example.service;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.androidquery.AQuery;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringBufferInputStream;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

import JsonParser.JsonParser;

/**
 * Created by Pavan on 9/16/2016.
 */
public class LoginLogic extends AsyncTask implements JsonParser {

    AQuery aq;
    Activity refactivity;


    String  Name;
    String password;
    String _encryptString;


    JSONObject jsonTokenobj=new JSONObject();
    JSONObject  result=new JSONObject();
    public LoginLogic(Activity activity, String name, String password) {

        aq = new AQuery(activity);
        refactivity = activity;
        name=name;
        password=password;



    }

    public void post(JSONObject jsonObject) {


        String _postvalue= "CableTVCRM-varun1234@gmail.com-1475049490";
        Cryptography    token  =new Cryptography();

        _encryptString=token.encrypt(_postvalue.getBytes());

        Log.d("Token",_encryptString);


    }




     public String Tokens()
     {

         StringBuilder builder =new StringBuilder();
         String  username="";

         return builder.toString();
     }

    @Override
    public JSONObject jsonParser() {

     String  rawjson="{\n" +
             "  \"Token\": \"aKFhVsGgGftCeCc8TTr/26P/xmW1COrGiEIuxsPIL7HhTbyVxVwcHgF3Mw1tLCfm\",\n" +
             "  \"EntitySet\": [\n" +
             "    {\n" +
             "      \"Password\": \"1234\"\n" +
             "    }\n" +
             "  ]\n" +
             "}\n";

        JSONObject tokenobject= null;
        try {
            tokenobject = new JSONObject(rawjson);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return  tokenobject;





    }

    @Override
    protected Object doInBackground(Object[] params) {

        new JsonPost().post(jsonParser());
        return null;
    }
}
