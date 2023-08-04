package com.example.myfpl.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpl.R;
import com.example.myfpl.api.ServiceHelper;
import com.example.myfpl.models.BaseResponse;
import com.example.myfpl.models.CourseModel;
import com.example.myfpl.models.MonHoc;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MonHocAdapterRecyle extends RecyclerView.Adapter<MonHocAdapterRecyle.ViewHoler> {

    private Context context;
    private ArrayList<MonHoc> data;

    public MonHocAdapterRecyle(Context context, ArrayList<MonHoc> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.mon_hoc_items, parent, false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        if (Integer.valueOf(data.get(position).IS_REGISTER) ==0){
            holder.tvDangKi.setText("Đăng kí");
        }
        else{
            holder.tvDangKi.setText("Đã đăng kí");
        }
        holder.tvMon.setText(data.get(position).NAME);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.valueOf(data.get(position).IS_REGISTER) ==0){
                    ServiceHelper.getInstance().registerCourse(Integer.valueOf(data.get(position).ID)).enqueue(new Callback<BaseResponse<String>>() {
                        @Override
                        public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                            Log.d(">>>Click",""+call);

                        }

                        @Override
                        public void onFailure(Call<BaseResponse<String>> call, Throwable t) {

                        }
                    });
                }
                else{
                    ServiceHelper.getInstance().cancelCourse(Integer.valueOf(data.get(position).ID)).enqueue(new Callback<BaseResponse<String>>() {
                        @Override
                        public void onResponse(Call<BaseResponse<String>> call, Response<BaseResponse<String>> response) {
                            Log.d(">>>Click",""+call);

                        }

                        @Override
                        public void onFailure(Call<BaseResponse<String>> call, Throwable t) {

                        }
                    });

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        TextView tvMon;
        TextView tvDangKi;
        View layout;

        public ViewHoler(@NonNull View view) {
            super(view);
            tvDangKi = view.findViewById(R.id.tvDangKi);
            tvMon = view.findViewById(R.id.tvMonHoc);
            layout = view.findViewById(R.id.item_layout);
        }
    }
}
