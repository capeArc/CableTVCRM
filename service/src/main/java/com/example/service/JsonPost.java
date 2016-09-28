package com.example.service;

import android.widget.Toast;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;


/**
 * Created by Pavan on 9/28/2016.
 */

public class JsonPost {

    HttpResponse httpresponse ;

    public void post(JSONObject jsonObject)
    {

        DefaultHttpClient httpclient = new DefaultHttpClient();
        HttpPost httppostreq;
        httppostreq = new HttpPost("http://api.cabletvcrm.com/CablePayHomeService.svc/Authenticate");
        StringEntity se = null;
        try {
            se = new StringEntity(jsonObject.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        se.setContentType("application/json;charset=UTF-8");
        se.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8"));
        httppostreq.setEntity(se);
        try {
            httpresponse = httpclient.execute(httppostreq);
            reSponse(httpresponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String  reSponse(HttpResponse httpresponse) throws IOException {
        HttpEntity resultentity = httpresponse.getEntity();
        InputStream inputstream = resultentity.getContent();
        Header contentencoding = httpresponse.getFirstHeader("Content-Encoding");
        if(contentencoding != null && contentencoding.getValue().equalsIgnoreCase("gzip")) {
            try {
                inputstream = new GZIPInputStream(inputstream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String resultstring = convertStreamToString(inputstream);
        inputstream.close();
        resultstring = resultstring.substring(1,resultstring.length()-1);
      /*  recvdref.setText(resultstring + "\n\n" + httppostreq.toString().getBytes());
        JSONObject recvdjson = new JSONObject(resultstring);
        recvdref.setText(recvdjson.toString(2));*/
        return resultstring;
    }

    private String convertStreamToString(InputStream inputstream) {


            String line = "";
            StringBuilder total = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            try {
                while ((line = rd.readLine()) != null) {
                    total.append(line);
                }
            } catch (Exception e) {
               /// Toast.makeText(this, "Stream Exception", Toast.LENGTH_SHORT).show();
            }
            return total.toString();
        }

    }
//dljfd

}
