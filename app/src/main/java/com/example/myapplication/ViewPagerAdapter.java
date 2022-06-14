package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.ui.fauna.FaunaFragment;
import com.example.myapplication.ui.flora.FloraFragment;
import com.example.myapplication.ui.plantamedicinal.PlantaMedicinalFragment;
import com.example.myapplication.ui.tradicion.TradicionFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position == 3) return new TradicionFragment();
        if(position == 2) return new FaunaFragment();
        if(position == 1) return new FloraFragment();
        return new PlantaMedicinalFragment();
    }
    @Override
    public int getItemCount() {
        return 4;
    }

}
