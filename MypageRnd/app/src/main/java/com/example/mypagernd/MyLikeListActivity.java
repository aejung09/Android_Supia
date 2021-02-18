package com.example.mypagernd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import java.util.ArrayList;

public class MyLikeListActivity extends Activity {

    RecyclerView rv1;
    ArrayList<LikeListBean> like;
    RecyclerView.LayoutManager layoutManager = null;


    String url = "http://172.30.1.2:8080/supia/supiaLikeList.jsp";
    String url1 = "http://172.30.1.2:8080/supia/supiaLikeCheckUpdate.jsp?likeCheck=";

    String seq;
    MyLikeListAdapter adapter1 = null;


    String likeclick = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_like_list);

    like =  new ArrayList<LikeListBean>();
        rv1 = findViewById(R.id.mypage_likelist);
        rv1.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(this);

        rv1.setLayoutManager(layoutManager);


        getdata();




    }


    private void getdata() {
        try {
            NetworkTask_mypage networkTask = new NetworkTask_mypage(MyLikeListActivity.this, url, "select");
            Object obj = networkTask.execute().get();
            like = (ArrayList<LikeListBean>) obj;

            adapter1 = new MyLikeListAdapter(MyLikeListActivity.this, R.layout.activity_my_like_list, like);
            rv1.setAdapter(adapter1);
            adapter1.setOnItemClickListener(new MyLikeListAdapter.OnItemClickListener() {

                @Override

                public void onItemClick(View v, int position) {

                    Log.v("여기", "MainActivity_LikeCheck : " + like.get(position).getLikeCheck());
                    Log.v("여기", "MainActivity_id : " + like.get(position).getLikeUserId());

                    switch (like.get(position).getLikeCheck()){
                        case "1":
                            likeclick = "0";
                            seq = like.get(position).getLikeUserId();
                            update();

                            Log.v("여기", "MainActivity_LikeCheck ds: " + like.get(position).getLikeCheck());
                                Log.v("여기", "MainActivity_seq ds: " + like.get(position).getLikeUserId());
                            break;
                        case "0":


                            likeclick = "1";
                            seq = like.get(position).getLikeUserId();
                            update();
                            Log.v("여기", "MainActivity_LikeCheck dsss: " + like.get(position).getLikeCheck());
                            Log.v("여기", "MainActivity_seq dsss: " + like.get(position).getLikeUserId());
                            break;
                    }

                    getdata();


                }
            });




        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    private void getdata2(){
//        try {
//            NetworkTask_mypage networkTask = new NetworkTask_mypage(MyLikeListActivity.this, url1, "select");
//            Object obj = networkTask.execute().get();
//            like = (ArrayList<LikeListBean>) obj;
//            adapter1 = new MyLikeListAdapter(MyLikeListActivity.this, R.layout.activity_my_like_list, like);
//            rv1.setAdapter(adapter1);
//        }catch (Exception e){
//
//        }
//    }

    private void update() {
        try {
            NetworkTask_mypage updateworkTask = new NetworkTask_mypage(MyLikeListActivity.this, url1 + likeclick + "&likeProductId=" + seq, "update");
            updateworkTask.execute().get();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}//-----------------