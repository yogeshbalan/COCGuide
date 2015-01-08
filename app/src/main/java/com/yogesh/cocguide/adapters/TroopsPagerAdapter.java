package com.yogesh.cocguide.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yogesh.cocguide.fragments.HogRider;
import com.yogesh.cocguide.fragments.Minions;

/**
 * Created by yogesh on 9/1/15.
 */
public class TroopsPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 2;



    public TroopsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0
                return Minions.newInstance();
            case 1: // Fragment # 1
                return HogRider.newInstance();
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
                return  "Minions";
            case 1:
                return   "Hog Rider";
        }
        return mTitle;
    }

}

