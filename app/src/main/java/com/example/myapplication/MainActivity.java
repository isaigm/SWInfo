package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.example.myapplication.ui.fauna.FaunaPopUp;
import com.example.myapplication.ui.flora.FloraPopUp;
import com.example.myapplication.ui.plantamedicinal.PlantaMedicinalPopUp;
import com.example.myapplication.ui.tradicion.TradicionPopUp;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private ViewPager2.OnPageChangeCallback callback;
    private ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Animation fabOpen = AnimationUtils.loadAnimation(this,R.anim.fab_rotate);
        FloatingActionButton fab = findViewById(R.id.button);
        ((AppCompatActivity)this).getSupportActionBar().setTitle("Misantla");
        viewPager2 = findViewById(R.id.pager);
        callback = new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                fab.setOnClickListener(view -> {
                    fab.startAnimation(fabOpen);
                    switch (position){
                        case 0:
                            PlantaMedicinalPopUp plantaMedicinalPopUp = new PlantaMedicinalPopUp();
                            plantaMedicinalPopUp.showPopupWindow(view, null);
                            break;
                        case 1:
                            FloraPopUp floraPopUp = new FloraPopUp();
                            floraPopUp.showPopupWindow(view, null);
                            break;
                        case 2:
                            FaunaPopUp faunaPopUp = new FaunaPopUp();
                            faunaPopUp.showPopupWindow(view, null);
                            break;
                        case 3:
                            TradicionPopUp tradicionPopUp = new TradicionPopUp();
                            tradicionPopUp.showPopupWindow(view, null);
                            break;
                    }
                });
            }
        };
        viewPager2.registerOnPageChangeCallback(callback);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(viewPagerAdapter);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            switch (position){
                case 0: tab.setText("Plantas medicinales");
                    break;
                case 1: tab.setText("Flora");
                    break;
                case 2: tab.setText("Fauna");
                    break;
                case 3: tab.setText("Tradiciones");
                    break;
            }
        }).attach();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        viewPager2.unregisterOnPageChangeCallback(callback);
    }
}