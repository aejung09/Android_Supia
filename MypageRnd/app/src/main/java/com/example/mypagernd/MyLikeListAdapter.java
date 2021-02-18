package com.example.mypagernd;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyLikeListAdapter  extends RecyclerView.Adapter<MyLikeListAdapter.MyViewHolder> {



    private Context mContext = null;
    private int layout = 0;
    private ArrayList<LikeListBean> data = null;
    private LayoutInflater inflater = null;



    public MyLikeListAdapter(Context mContext, int layout, ArrayList<LikeListBean> data) {
        Log.v("여기", "첫뻔째 어댑터 ");


        this.mContext = mContext;
        this.layout = layout;
        this.data = data;
        this.inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.v("여기", "두번째 어댑터 ");
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.mypage_likelist_layout, parent, false);
        return new MyViewHolder(view);

    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Log.v("이프의 이프안임유",""+data.get(position).getLikeCheck());


        if(data.get(position).getLikeCheck()=="1") {
            holder.likeCheck.setImageDrawable(mContext.getResources().getDrawable(R.drawable.like_click));
            holder.productName.setText("" + data.get(position).getProductName());
            holder.productPrice.setText(data.get(position).getProductPrice());
            Log.v("이프안임유", "" + data.get(position).getLikeCheck());
//            count ++;
        }
//        if(data.get(position).getLikeCheck()=="1") {
//            holder.likeCheck.setImageDrawable(mContext.getResources().getDrawable(R.drawable.like_click));
//        }else{
//            holder.likeCheck.setImageDrawable(mContext.getResources().getDrawable(R.drawable.like));
//        }



    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnItemClickListener {

        void onItemClick(View v, int position);


    }
    private OnItemClickListener mListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView productImagePath;
        TextView productName;
        TextView productPrice;
        ImageButton cart;
        ImageButton likeCheck;



        public MyViewHolder(@NonNull View v)


        {

            super(v);


Log.v("여기 부홀더","제발되라고 샹");
            productName = v.findViewById(R.id.mypage_likelist_productname);
            productPrice = v.findViewById(R.id.mypage_likelist_productprice);
            likeCheck = v.findViewById(R.id.mypage_liklist_like);
            productImagePath = v.findViewById(R.id.mypage_likelist_productimg);
            cart = v.findViewById(R.id.mypage_likelist_cart);


            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();//어뎁터 포지션값
                    // 뷰홀더에서 사라지면 NO_POSITION 을 리턴
                    if (position != RecyclerView.NO_POSITION) {
                        if (mListener != null) {
                            mListener.onItemClick(v, position);
                        }
                    }
                }
            });




        }
    }
}
