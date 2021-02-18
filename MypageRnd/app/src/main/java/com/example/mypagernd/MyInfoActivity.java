package com.example.mypagernd;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static androidx.fragment.app.DialogFragment.STYLE_NO_TITLE;

public class MyInfoActivity extends Activity {

    TextView infoName, infoId, infoTel, infoPw;

    EditText pw, pwCh;

    String userId, userName, userPw, userTel, userAddr;


    ImageButton button;
    Button changeBtn;
    final String pwChange = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);


        Intent intent = getIntent();

        userId = intent.getStringExtra("userId");
        userName = intent.getStringExtra("userName");
        userTel = intent.getStringExtra("userTel");
        userPw = intent.getStringExtra("userPw");
        userAddr = intent.getStringExtra("userAddr");


        button = findViewById(R.id.back_btn);

        infoId = findViewById(R.id.info_id);
        infoName = findViewById(R.id.info_name);
        infoTel = findViewById(R.id.info_tel);
        infoPw = findViewById(R.id.info_pw);
        changeBtn = findViewById(R.id.info_pw_btn);


        pw = findViewById(R.id.change_pw);

        pwCh = findViewById(R.id.change_pwch);


        infoId.setText(userId);
        infoName.setText(userName);
        infoTel.setText(userTel);
        infoPw.setText(userPw);


        changeBtn.setOnClickListener(change);
        button.setOnClickListener(back);


    }

    View.OnClickListener change = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Mypage_PwDialog pwDialog = new Mypage_PwDialog(MyInfoActivity.this,userId,userName,userTel);
            pwDialog.callFunction(pwChange);


        }
    };


    View.OnClickListener back = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            onBackPressed();
            overridePendingTransition(R.anim.fadein, R.anim.hold);

        }
    };


//    private void connectUpdateData() {
//        try {
//            NetworkTask updateworkTask = new NetworkTask(MyInfoActivity.this, url, "update");
//            updateworkTask.execute().get();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }


//    public void showDialog() {
//
//
//        Dialog dialog;
//        dialog = new Dialog(MyInfoActivity.this);
//        dialog.setContentView(R.layout.dialog);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        dialog.show();
//
//       final TextView yes = dialog.findViewById(R.id.change_pw_ok);
//        yes.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Toast.makeText(MyInfoActivity.this,""+pw.getText().toString(),Toast.LENGTH_SHORT).show();
////                Toast.makeText(MyInfoActivity.this,""+pwCh.getText().toString(),Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//       final TextView no = dialog.findViewById(R.id.change_pw_cxl);
//        no.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


//혹시모를 상황에 대비한 다이얼로그..
/*        LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        LinearLayout loginLayout = (LinearLayout) vi.inflate(R.layout.dialog, null);
        final EditText id = (EditText) loginLayout.findViewById(R.id.change_pw);
        final EditText pw = (EditText) loginLayout.findViewById(R.id.change_pwch);
        new AlertDialog.Builder(this,R.drawable.linearlayout_rount)
                .setView(loginLayout)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MyInfoActivity.this, "비번 : " + id.getText().toString() + "비번확인 : " + pw.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        }).show();*/




}//-------------------------