package com.example.mypagernd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends Activity {

    TextView mypage, subscribe, order;
    TextView name, id, info;

    TextView like, cart, notice, sns, logout;
    LinearLayout ll,llCart;

    ArrayList<UserBean> members;
    ImageButton button;

        // IP주소 바꾸는곳은 Main이랑 Mypage_PwDialog//


    String url = "http://172.30.1.19:8080/supia/supiaMypage.jsp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //----------위에 탭 텍스트뷰 아이디----------//
        mypage = findViewById(R.id.tv_mypage_btn);
        subscribe = findViewById(R.id.tv_subscribe_btn);
        order = findViewById(R.id.tv_order_btn);
        //-------------------------------------//



        //-----------가운데 레이아웃 아이디----------//
        name = findViewById(R.id.tv_name);
        id = findViewById(R.id.tv_id);
        info = findViewById(R.id.click_info_btn);
        //-------------------------------------//


        //----------밑에 목록 리스트 아이디------------//
        llCart = findViewById(R.id.ll_cart);
        ll = findViewById(R.id.mypage_like);
        cart = findViewById(R.id.mypage_cart);
        notice = findViewById(R.id.mypage_notice);
        sns = findViewById(R.id.mypage_sns);
        logout = findViewById(R.id.mypage_logout);
        //---------------------------------------//


        //---------뒤로가기 버튼 아이디---------//
        button = findViewById(R.id.back_btn);
        //---------------------------------//



        //---------------클릭이벤트--------------------//
        button.setOnClickListener(back); //뒤로가기
        mypage.setOnClickListener(onClickListener); //마이페이지
        subscribe.setOnClickListener(onClickListener1); //정기구독
        order.setOnClickListener(onClickListener2); //주문내역
        info.setOnClickListener(goToInfo); //내정보
        ll.setOnClickListener(likeListener); //찜목록
        llCart.setOnClickListener(cartListener); //장바구니
            sns.setOnClickListener(whereSns);;
        //------------------------------------------//




        connectGetData();

        //--------------텍스트뷰 값띄워주기------------//
        name.setText(members.get(0).getUserName());
        id.setText(members.get(0).getUserId());
        //----------------------------------------//

    } //---onCreate





    View.OnClickListener whereSns = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent snsPlatform =new Intent(MainActivity.this,MySnsPlatformActivity.class);
            startActivity(snsPlatform);
            overridePendingTransition(R.anim.fadein, R.anim.hold);

        }
    };




    //---------------------------------장바구니 클릭 이벤---------------------------------//
    View.OnClickListener cartListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent cart = new Intent(MainActivity.this,MyCartListActivity.class);
            startActivity(cart);
            overridePendingTransition(R.anim.fadein, R.anim.hold);
        }
    };
    //--------------------------------------------------------------------------------//


    //----------------------------------뒤로가기 버튼 이벤트----------------------------------//
    View.OnClickListener back = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
            overridePendingTransition(R.anim.fadein, R.anim.hold);

        }
    };
    //-----------------------------------------------------------------------------------//




    //----------------------------------찜목록 클릭이벤트----------------------------------//
    View.OnClickListener likeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent like = new Intent(MainActivity.this,MyLikeListActivity.class);




            startActivity(like);
            overridePendingTransition(R.anim.fadein, R.anim.hold);


        }
    };
    //--------------------------------------------------------------------------------//







    //----------------------------------내 정보 클릭이벤트----------------------------------//
    View.OnClickListener goToInfo = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent infointent = new Intent(MainActivity.this,MyInfoActivity.class);
            infointent.putExtra("userId",members.get(0).getUserId());
            infointent.putExtra("userName",members.get(0).getUserName());
            infointent.putExtra("userTel",members.get(0).getUserTel());

            Log.v("여기입니다",members.get(0).getUserPw());
            infointent.putExtra("userPw",members.get(0).getUserPw());
            infointent.putExtra("url",url);

            startActivity(infointent);
            overridePendingTransition(R.anim.fadein, R.anim.hold);


        }
    };

    //------------------------------------------------------------------------------------//




    //----------------------------------마이페이지 클릭 이벤트----------------------------------//
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            overridePendingTransition(R.anim.fadein, R.anim.hold);

        }
    };
    //------------------------------------------------------------------------------------//



    //----------------------------------정기구독 클릭 이벤트----------------------------------//
    View.OnClickListener onClickListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent1 = new Intent(MainActivity.this, SubscribeActivity.class);
            startActivity(intent1);
            overridePendingTransition(R.anim.fadein, R.anim.hold);
        }
    };
    //------------------------------------------------------------------------------------//



    //----------------------------------주문내역 클릭 이벤트----------------------------------//
    View.OnClickListener onClickListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent3 = new Intent(MainActivity.this, OrderActivity.class);
            startActivity(intent3);
            overridePendingTransition(R.anim.fadein, R.anim.hold);
        }
    };
    //-----------------------------------------------------------------------------------//







    //----------------------------------connectGetData----------------------------------//
    private void connectGetData() {
        try {

            NetworkTask networkTask = new NetworkTask(MainActivity.this, url, "select");
            Object obj = networkTask.execute().get();
            members = (ArrayList<UserBean>) obj;




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //----------------------------------------------------------------------------------//

}//----------------------