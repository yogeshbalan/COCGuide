package com.yogesh.cocguide.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yogesh.cocguide.fragments.DarkElixir;
import com.yogesh.cocguide.fragments.ElixirStorage;
import com.yogesh.cocguide.fragments.GoldStorage;

/**
 * Created by yogesh on 9/1/15.
 */
public class ResPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 3;



    public ResPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0
                return DarkElixir.newInstance();
            case 1: // Fragment # 1
                return ElixirStorage.newInstance();
            case 2:
                return GoldStorage.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence mTitle = null;
        switch (position){
            case 0:
                return  "Dark Elixir Storage";
            case 1:
                return   "Elixir Storage";
            case 2:
                return "Gold Storage";
        }
        return mTitle;
    }

}

