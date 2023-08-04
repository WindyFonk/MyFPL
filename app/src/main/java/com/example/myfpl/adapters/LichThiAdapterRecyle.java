package com.example.myfpl.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpl.R;
import com.example.myfpl.models.CourseModel;

import java.util.ArrayList;

public class LichThiAdapterRecyle extends RecyclerView.Adapter<LichThiAdapterRecyle.ViewHoler> {

    private Context context;
    private ArrayList<CourseModel> data;

    public LichThiAdapterRecyle(Context context, ArrayList<CourseModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.lich_thi_items, parent, false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        holder.tvCa.setText("Ca: "+data.get(position).ca_hoc);
        holder.tvNgay.setText(data.get(position).TIME);
        holder.tvPhong.setText("Phòng: "+data.get(position).phong_hoc);
        holder.tvMon.setText(data.get(position).NAME);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog;
                LayoutInflater mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View _view = mLayoutInflater.inflate(R.layout.dialog_class_detail, null);
                TextView tvGiangDuong = _view.findViewById(R.id.tvGiangDuong);
                TextView tvNoiDung = _view.findViewById(R.id.tvNoiDung);
                tvGiangDuong.setText(data.get(position).giang_duong);
                tvNoiDung.setText(data.get(position).noi_dung);
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext())
                        .setView(_view);
                alertDialog = builder.create();
                alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                alertDialog.show();
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
