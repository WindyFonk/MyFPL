package com.example.myfpl;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.myfpl.activity_fragments.Home;
import com.example.myfpl.activity_fragments.Others;
import com.example.myfpl.activity_fragments.schedule_fragments.NewsListFragment;
import com.example.myfpl.activity_fragments.schedule_fragments.LichThiFragment;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends FragmentActivity {

    MeowBottomNavigation bottomNavigation;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    View actionBar;
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = findViewById(R.id.action_bar);

        logo=actionBar.findViewById(R.id.fptLogo);
        bottomNavigation = findViewById(R.id.bottomNavigation);
        BottomTab();

    }

    private void BottomTab(){
        bottomNavigation.show(1,false);

        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.ic_baseline_home_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ic_baseline_newspaper_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.ic_baseline_event_note_24));
        bottomNavigation.add(new MeowBottomNavigation.Model(4, R.drawable.ic_baseline_person_24));

        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                switch (model.getId()){
                    case 1:
                        ReplaceFragment(new Home());
                        logo.setImageResource(R.drawable.fptlogo);
                        break;

                    case 2:
                        ReplaceFragment(new NewsListFragment());
                        logo.setImageResource(R.drawable.fptnews);
                        break;

                    case 3:
                        ReplaceFragment(new LichThiFragment());
                        logo.setImageResource(R.drawable.fptshedule);
                        break;

                    case 4:
                        ReplaceFragment(new Others());
                        logo.setImageResource(R.drawable.fptlogo);
                        break;
                }
                return null;
            }
        });
    }

    private void ReplaceFragment(Fragment fragment) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment, null);
        fragmentTransaction.commit();
    }



}