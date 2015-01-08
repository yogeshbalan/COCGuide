package com.yogesh.cocguide.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yogesh.cocguide.fragments.CCbuilder;
import com.yogesh.cocguide.fragments.TownHall;

/**
 * Created by yogesh on 9/1/15.
 */
public class OthersPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 2;



    public OthersPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0
                return CCbuilder.newInstance();
            case 1: // Fragment # 1
                return TownHall.newInstance();
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
                return  "CC Builder";
            case 1:
                return   "TownHall Level";
        }
        return mTitle;
    }

}


