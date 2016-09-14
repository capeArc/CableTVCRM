package com.example.pavan.cabletvcrm.ViewModels;

import android.text.TextWatcher;

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




}
