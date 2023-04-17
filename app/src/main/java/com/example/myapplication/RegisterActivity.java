package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private TextView regis_page_text;
    private Button confirm_regis;
    private EditText user_box, passwd_box, confirm_passwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        viewBinding();
        confirm_regis.setOnClickListener(view -> {
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

            if (confirm_passwd.getText().toString().equals(passwd_box.getText().toString()))
                different_flag = true;
            if (!user_flag)
                Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            if (!passwd_flag)
                Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            if (!different_flag)
                Toast.makeText(this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
            if (user_flag && passwd_flag && different_flag) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtra("user_name", user);
                intent.putExtra("password", passwd);
                startActivity(intent);
                finish();
            }
        });
    }

    private void viewBinding() {
        regis_page_text = findViewById(R.id.regis_text_view);
        confirm_regis = findViewById(R.id.confirm_register);
        user_box = findViewById(R.id.input_user_register);
        passwd_box = findViewById(R.id.input_passwd_redister);
        confirm_passwd = findViewById(R.id.confirm_passwd);
    }

}