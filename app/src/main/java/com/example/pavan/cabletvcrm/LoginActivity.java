package com.example.pavan.cabletvcrm;

import android.app.Activity;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.pavan.cabletvcrm.ViewModels.LoginViewModel;
import com.example.pavan.cabletvcrm.databinding.ActivityLoginBinding;

public class LoginActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      ActivityLoginBinding binding  = DataBindingUtil.setContentView(this,R.layout.activity_login);

        binding.setLoginmodel(new LoginViewModel());
    }
}
