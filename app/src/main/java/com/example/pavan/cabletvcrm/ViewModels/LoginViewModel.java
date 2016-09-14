package com.example.pavan.cabletvcrm.ViewModels;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.pavan.cabletvcrm.Activity.ErrorMesssageActivity;
import com.example.pavan.cabletvcrm.Activity.LandingPage1;
import com.example.pavan.cabletvcrm.Adapters.TextWatcherAdapter;

import java.util.jar.Attributes;

/**
 * Created by Pavan on 9/14/2016.
 */
public class LoginViewModel {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String  password;
    public TextWatcher obj =new TextWatcherAdapter() {
        @Override
        public void afterTextChanged(Editable s) {
 setName(s.toString());
        }
    };

    public void onClick(View V)

    {
       if(name.equals("Admin"))
       {

           Intent i =new Intent(V.getContext(),LandingPage1.class);
           V.getContext().startActivity(i);
       }
        else
       {
           Intent i =new Intent(V.getContext(),ErrorMesssageActivity.class);
           V.getContext().startActivity(i);
       }
    }



    }




