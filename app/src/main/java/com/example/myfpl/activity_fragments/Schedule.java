package com.example.myfpl.activity_fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myfpl.R;
import com.example.myfpl.activity_fragments.schedule_fragments.LichThiFragment;
import com.example.myfpl.activity_fragments.schedule_fragments.LichHocFragment;
import com.google.android.material.tabs.TabLayout;

public class Schedule extends Fragment {
    View view;
    TabLayout tabLayout;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_schedule, container, false);
        TabNavigation();
        ReplaceFragment(new LichHocFragment());

        return view;
    }

    private void TabNavigation(){
        tabLayout = view.findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("Lịch học"));
        tabLayout.addTab(tabLayout.newTab().setText("Lịch thi"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition()==0){
                    ReplaceFragment(new LichHocFragment());
                }
                else{
                    ReplaceFragment(new LichThiFragment());
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void ReplaceFragment(Fragment fragment) {
        fragmentManager = getParentFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.scheduleFragment, fragment, null);
        fragmentTransaction.commit();
    }
}