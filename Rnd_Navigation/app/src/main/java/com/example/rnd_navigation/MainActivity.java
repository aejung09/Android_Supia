package com.example.rnd_navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    ImageButton mallBtn, homeBtn, mypageBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        mallBtn = findViewById(R.id.mall);
//        homeBtn = findViewById(R.id.home);
//        mypageBtn = findViewById(R.id.mypage);


        mallBtn = findViewById(R.id.mall);
        homeBtn = findViewById(R.id.home);
        mypageBtn = findViewById(R.id.mypage);



    }

    @Override
    protected void onResume() {
        super.onResume();
        mallBtn.setOnClickListener(onClickListener);
        homeBtn.setOnClickListener(onClickListener);
        mypageBtn.setOnClickListener(onClickListener);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            switch (v.getId()) {
                case R.id.mall:

                    Intent intent = new Intent(MainActivity.this, MallActivity.class);
                    startActivity(intent);
                    break;
                case R.id.home:
                    Intent intent1 = new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent1);
                    break;
                case R.id.mypage:
                    Intent intent2 = new Intent(getApplicationContext(), MyPageActivity.class);
                    startActivity(intent2);

                    break;
            }


        }
    };

}//---------------------