package com.example.myactionbartest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AfterLoginActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MAIN = 201;
    public static final int REQUEST_CODE_AFTERLOGIN = 101;

    ShowFragment showFragment;
    ShowTestFragment showTestFragment;
    TextView textView;
    LoginFragment loginFragment;
    String idshow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        showFragment = new ShowFragment();
        showTestFragment = new ShowTestFragment();

        textView = findViewById(R.id.idshow);
        Intent intent = getIntent();
        idshow = intent.getStringExtra("id");
        textView.append("[ "+ idshow + " ] 님 안녕하세요.");

        Button button1 = findViewById(R.id.c1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container2, showTestFragment).commit();
            }
        });

        Button button2 = findViewById(R.id.c2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container2, showFragment).commit();
            }
        });

        Button button3 = findViewById(R.id.logout);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "메인으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(intent, REQUEST_CODE_MAIN);
            }
        });

    }

    public void Fragmentchange(int index){
        if(index == 0){
            Toast.makeText(this, "로그인 화면으로 이동합니다.", Toast.LENGTH_SHORT).show();
            getSupportFragmentManager().beginTransaction().replace(R.id.container, loginFragment).commit();
        } else if (index == 1) {
            Intent intent = new Intent(getApplicationContext(), AfterLoginActivity.class);
            intent.putExtra("id", idshow);
            startActivityForResult(intent, REQUEST_CODE_AFTERLOGIN);
        }
    }

    public void answerView(boolean b){
        if (b == true){
            Toast.makeText(this, "정답입니다.", Toast.LENGTH_SHORT).show();
        } else if (b == false){
            Toast.makeText(this, "오답입니다.", Toast.LENGTH_SHORT).show();
        }
    }

}