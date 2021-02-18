package com.example.mypagernd;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class Mypage_PwDialog extends Dialog {



    private Context context;
    private String userId;
    private String please;
    private String userName;
    private String userTel;


    String urlAddr = null;


    public Mypage_PwDialog(@NonNull Context context, String userId,String userName,String userTel) {
        super(context);
        this.context = context;
        this.userId = userId;
        this.userName = userName;
        this.userTel = userTel;

    }

    public void callFunction(final String pwChange) {

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        dialog.show();


        final EditText pw = dialog.findViewById(R.id.change_pw);
        final EditText pwCh = dialog.findViewById(R.id.change_pwch);
        final TextView tv_ok = dialog.findViewById(R.id.change_pw_ok);
        final TextView tv_cxl = dialog.findViewById(R.id.change_pw_cxl);
        final TextView tv_check = dialog.findViewById(R.id.chage_pw_alert);

        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String m = pw.getText().toString();
                String n = pwCh.getText().toString();
                please =m;


                if (m.length() == 0 && n.length() == 0) {
                    tv_check.setText("정보를 입력해주세요.");
                    tv_check.setTextColor(0xAAef484a);


                }
                 if(m.length() <=8 && n.length()<=8){
                    tv_check.setText("8글자 이상 입력해주세요.");
                    tv_check.setTextColor(0xAAef484a);
                }





            if(m.equals(n)){

                    new AlertDialog.Builder(context)
                            .setTitle("알림")
                            .setMessage("비밀번호 변경이 완료되었습니다.")
                            .show();


                    connectUpdateData();
                    Intent intent = new Intent(context, MyInfoActivity.class);
                    intent.putExtra("userId",userId);
                    intent.putExtra("userPw",please);
                    intent.putExtra("userTel",userTel);
                    intent.putExtra("userName",userName);
                    context.startActivity(intent);


                } else {
                tv_check.setText("비밀번호가 일치하지 않습니다.");
                tv_check.setTextColor(0xE53935);
                }



            }
        });


        tv_cxl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }


    private String connectUpdateData() {
        String result = null;
        try {
            String url = "http://172.30.1.2:8080/supia/supiaPwChange.jsp?userId=" + userId + "&userPw=" + please;
            Log.v("제발", "" + url);
            NetworkTask updateworkTask = new NetworkTask(context, url, "update");
            Object obj = updateworkTask.execute().get();
            result = (String) obj;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}//---------------
