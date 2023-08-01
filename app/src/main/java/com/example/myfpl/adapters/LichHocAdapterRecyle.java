package com.example.myfpl.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpl.R;
import com.example.myfpl.models.LichHocModel;

import java.util.ArrayList;

public class LichHocAdapterRecyle extends RecyclerView.Adapter<LichHocAdapterRecyle.ViewHoler> {

    private Context context;
    private ArrayList<LichHocModel> data;

    public LichHocAdapterRecyle(Context context, ArrayList<LichHocModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.lich_hoc_items, parent, false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        holder.tvCa.setText("Ca: "+data.get(position).getCa());
        holder.tvNgay.setText(data.get(position).getNgay());
        holder.tvPhong.setText("Phòng: "+data.get(position).getPhong());
        holder.tvMon.setText(data.get(position).getMonHoc());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(">>>>CLick: ",String.valueOf(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {
        TextView tvCa;
        TextView tvNgay;
        TextView tvPhong;
        TextView tvMon;
        View layout;

        public ViewHoler(@NonNull View view) {
            super(view);
            tvCa = view.findViewById(R.id.tvCaHoc);
            tvNgay = view.findViewById(R.id.tvNgay);
            tvPhong = view.findViewById(R.id.tvPhong);
            tvMon = view.findViewById(R.id.tvMonHoc);
            layout = view.findViewById(R.id.schedule_item_layout);
        }
    }
}
