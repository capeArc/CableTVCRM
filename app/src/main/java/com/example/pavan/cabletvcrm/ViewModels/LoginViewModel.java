package com.example.pavan.cabletvcrm.ViewModels;

import android.app.Activity;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.pavan.cabletvcrm.Activity.ErrorMesssageActivity;
import com.example.pavan.cabletvcrm.Activity.LandingPage1;
import com.example.pavan.cabletvcrm.Adapters.TextWatcherAdapter;
import com.example.pavan.cabletvcrm.R;
import com.example.service.LoginLogic;

/**
 * Created by Pavan on 9/14/2016.
 */
public class LoginViewModel extends BaseObservable {

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
            if(s.toString().isEmpty()) {
                setNameerror("Plz Enter username");
                notifyChange();
            }
            else
            {
                notifyChange();
            }
        }
    };


    public String getNameerror() {
        return nameerror;
    }

    public void setNameerror(String nameerror) {
        this.nameerror = nameerror;
    }

    String  nameerror;


    public void onClick(View V)

    {

        Activity activity = (Activity)V.getContext();
         new LoginLogic(activity);

    }



}




