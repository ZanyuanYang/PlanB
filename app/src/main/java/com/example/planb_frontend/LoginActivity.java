package com.example.planb_frontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {

    //声明控件
    private Button mBtnLogin;
    private EditText mEtUser;
    private EditText mEtPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_login);

        //找到控件
        mBtnLogin = findViewById(R.id.btn_login);
        mEtUser = findViewById(R.id.username_textInput);
        mEtPassword = findViewById(R.id.password_textInput);


        //实现直接跳转
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //需要获取输入的用户名和密码
                String username = mEtUser.getText().toString();
                String password = mEtPassword.getText().toString();
                Intent intent = null;

                if(username.equals("lyh") && password.equals("123456")){
                    //如果正确，进行跳转
                    intent = new Intent(LoginActivity.this, StudentPageActivity.class);
                    startActivity(intent);
                }else{
                    //如果不正确，可能也要跳转，所以intent定义在外面，
                    //或弹出登录失败toast应用！！(需要学习)
                }
            }
        });
    }
}

