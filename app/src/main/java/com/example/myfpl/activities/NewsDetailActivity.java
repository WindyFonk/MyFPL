package com.example.myfpl.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myfpl.R;

public class NewsDetailActivity extends AppCompatActivity {
    ImageView img;
    TextView tvTitle,tvDate,tvDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        img = findViewById(R.id.article_image);
        tvTitle = findViewById(R.id.article_title);
        tvDate = findViewById(R.id.article_pub_date);
        tvDetails = findViewById(R.id.article_detail);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String time = intent.getStringExtra("time");
        String image = intent.getStringExtra("image");
        String detail = "Thông báo\n" +
                "\n" +
                "V/v: Đăng ký chuyển ngành, chuyển cơ sở học kỳ Fall 2023\n" +
                "\n" +
                "\n" +
                "Tất cả sinh viên có nguyện vọng CHUYỂN ĐỔI chuyên ngành, chuyên ngành hẹp hoặc chuyển cơ sở học kỳ Summer 2023 vui lòng lên AP để đăng ký.\n" +
                "\n" +
                "Thông báo này KHÔNG dành cho Sinh viên KHÓA 18.2 (ngành TKĐH, TKWE) muốn chuyển chuyên ngành hẹp LẦN ĐẦU.\n" +
                "\n" +
                "Thời gian mở đăng ký: Từ 9h00 ngày 01/8/2023 đến hết 20/8/2023\n" +
                "\n" +
                "Lưu ý: Sau thời gian này nếu Sinh viên không đăng ký trên AP, Phòng Đào tạo sẽ không hỗ trợ xử lý với bất kỳ lý do nào.\n" +
                "\n" +
                "\n" +
                "Trân trọng!\" ";
        tvDate.setText(time);
        tvTitle.setText(title);
        tvDetails.setText(detail);
        Glide.with(this).load(image).into(img);
    }
}