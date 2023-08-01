package com.example.myfpl.adapters;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfpl.R;
import com.example.myfpl.models.NewsModel;
import com.example.myfpl.models.NotificationModel;

import java.util.ArrayList;

public class NewsAdapterAll extends RecyclerView.Adapter<NewsAdapterAll.ViewHoler> {

    private Context context;
    private ArrayList<NotificationModel> data;

    public NewsAdapterAll(Context context, ArrayList<NotificationModel> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        View view = inflater.inflate(R.layout.all_news_items, parent, false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoler holder, int position) {
        holder.tvNewsTitle.setText(data.get(position).DESCRIPTION);
        holder.tvNewsTime.setText(data.get(position).TIME);
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
        ImageView imgNews;
        TextView tvNewsTime;
        TextView tvNewsAuthor;
        TextView tvNewsTitle;
        View layout;

        public ViewHoler(@NonNull View view) {
            super(view);
            tvNewsTime = view.findViewById(R.id.tvNewsTime);
            tvNewsAuthor = view.findViewById(R.id.tvNewsAuthor);
            tvNewsTitle = view.findViewById(R.id.tvNewsTitle);
            imgNews = view.findViewById(R.id.imgNews);
            layout = view.findViewById(R.id.news_item_layout);
        }
    }
}
