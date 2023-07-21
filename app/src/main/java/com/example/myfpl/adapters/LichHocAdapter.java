package com.example.myfpl.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myfpl.R;
import com.example.myfpl.models.LichHocModel;

import java.util.ArrayList;

public class LichHocAdapter extends BaseAdapter {

    public ArrayList<LichHocModel> list;
    public LichHocAdapter(ArrayList<LichHocModel> list){
        this.list=list;
    }
    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View _view, ViewGroup _viewGroup) {
        View view = _view;
        if (view == null) {
            view = View.inflate(_viewGroup.getContext(), R.layout.class_items, null);
            TextView tvClassDate = view.findViewById(R.id.tvClassDate);
            TextView tvClassPeriod = view.findViewById(R.id.tvClassPeriod);
            TextView tvTeacher = view.findViewById(R.id.tvTeacher);
            TextView tvSubject = view.findViewById(R.id.tvSubject);
            ViewHolder holder = new ViewHolder(tvClassDate, tvTeacher,tvSubject,tvClassPeriod);
            view.setTag(holder);
        }

        LichHocModel _class = (LichHocModel) getItem(i);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.tvSubject.setText(_class.getMonHoc());
        holder.tvTeacher.setText("Phòng: "+_class.getPhong());
        holder.tvClassDate.setText(_class.getNgay());
        holder.tvClassPeriod.setText("Ca: "+_class.getCa());

        return view;
    }

    static class ViewHolder{
        final TextView tvClassDate, tvTeacher,tvSubject,tvClassPeriod;

        public ViewHolder(TextView tvClassDate, TextView tvTeacher, TextView tvSubject, TextView tvClassPeriod) {
            this.tvSubject = tvSubject;
            this.tvTeacher = tvTeacher;
            this.tvClassDate = tvClassDate;
            this.tvClassPeriod = tvClassPeriod;
        }
    }
}
