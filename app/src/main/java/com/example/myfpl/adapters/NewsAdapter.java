package com.example.myfpl.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myfpl.R;
import com.example.myfpl.models.News;

import java.util.ArrayList;

public class NewsAdapter extends BaseAdapter {

    public ArrayList<News> list;
    public NewsAdapter(ArrayList<News> list){
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
            view = View.inflate(_viewGroup.getContext(), R.layout.news_item, null);
            TextView tvNewsTime = view.findViewById(R.id.tvNewsTime);
            TextView tvNewsAuthor = view.findViewById(R.id.tvNewsAuthor);
            TextView tvNewsTitle = view.findViewById(R.id.tvNewsTitle);
            ViewHolder holder = new ViewHolder(tvNewsTime, tvNewsAuthor,tvNewsTitle);
            view.setTag(holder);
        }

        return view;
    }

    static class ViewHolder{
        final TextView tvNewsTime, tvNewsAuthor,tvNewsTitle;

        public ViewHolder(TextView tvNewsTime, TextView tvNewsAuthor, TextView tvNewsTitle) {
            this.tvNewsTitle = tvNewsTitle;
            this.tvNewsAuthor = tvNewsAuthor;
            this.tvNewsTime = tvNewsTime;
        }
    }
}
