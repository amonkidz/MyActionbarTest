package com.example.myactionbartest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_AFTERLOGIN = 101;

    JoinFragment joinFragment;
    LoginFragment loginFragment;
    LoginFailFragment loginFailFragment;

    String joinid;
    String joinpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        joinFragment = new JoinFragment();
        loginFragment = new LoginFragment();
        loginFailFragment = new LoginFailFragment();

        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF815854));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int curId = item.getItemId();
        switch (curId) {
            case R.id.menu_join:
                Toast.makeText(this, "회원가입 화면으로 넘어갑니다.", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().add(R.id.container, joinFragment).commit();
                break;
            case R.id.menu_login:
                Toast.makeText(this, "로그인 화면으로 넘어갑니다.", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().add(R.id.container, loginFragment).commit();
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void loginFragmentAction(int index, String id, String pw) {
        if (index == 0) {
            if (id.equals(joinid) && pw.equals(joinpw)) {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), AfterLoginActivity.class);
                intent.putExtra("id", id);
                startActivityForResult(intent, REQUEST_CODE_AFTERLOGIN);
            } else if (id.equals("hanna") && pw.equals("hanna")) {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), AfterLoginActivity.class);
                intent.putExtra("id", id);
                startActivityForResult(intent, REQUEST_CODE_AFTERLOGIN);
            } else if (!(id.equals(joinid)) || !(pw.equals(joinpw)) || !(id.equals("hanna")) || !(pw.equals("hanna"))) {
                Toast.makeText(this, "등록되지 않은 회원입니다.", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.container, loginFailFragment).commit();
            }
        }
    }

        public void failFragmentAction(int index){
            if (index == 1) {
                Toast.makeText(this, "로그인에 실패하였습니다. 메인으로 돌아갑니다.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivityForResult(intent, REQUEST_CODE_AFTERLOGIN);
            } else if (index == 0) {
                Toast.makeText(this, "회원가입으로 넘어갑니다.", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.container, joinFragment).commit();
            }

        }

       public void joinFragmentAction(int index, String id, String pw){
            if (index == 0){
                joinid = id;
                joinpw = pw;
                Toast.makeText(this,"회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                loginFragmentAction(0, joinid, joinpw);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, loginFragment).commit();
            }
        }

    }
