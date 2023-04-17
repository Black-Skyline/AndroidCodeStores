package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView login_page_text;
    private Button confirm_login, goto_regis;
    private EditText user_box, passwd_box;
    private String transmit_user = null, transmit_passwd = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewBinding();
        initView();

        Intent intent = getIntent();
        if (intent != null) {
            Log.d("tag", "get there1");
            transmit_user = intent.getStringExtra("user_name");
            transmit_passwd = intent.getStringExtra("password");
        }

    }

    private void initView() {
        confirm_login.setOnClickListener(this);
        goto_regis.setOnClickListener(this);
    }

    private void viewBinding() {
        login_page_text = findViewById(R.id.login_text_view);
        confirm_login = findViewById(R.id.confirm_login);
        goto_regis = findViewById(R.id.goto_register);
        user_box = findViewById(R.id.input_user_login);
        passwd_box = findViewById(R.id.input_passwd_login);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.confirm_login:
                boolean user_flag = false;
                boolean passwd_flag = false;
                boolean different_flag = false;
                String user = "", passwd = "";
                if (!user_box.getText().toString().equals("")) {
                    user_flag = true;
                    user = user_box.getText().toString();
                }

                if (!passwd_box.getText().toString().equals("")) {
                    passwd_flag = true;
                    passwd = passwd_box.getText().toString();
                }
                if (user_flag && passwd_flag) {
                    if (user.equals(transmit_user) && passwd.equals(transmit_passwd))
                        startActivity(new Intent(this, NewActivity.class));
                } else {
                    Toast.makeText(this, "请输入用户名或密码", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.goto_register:
                Log.d("tag", "get goto_register");
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}