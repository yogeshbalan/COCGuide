package com.yogesh.cocguide.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yogesh.cocguide.fragments.AirBomb;
import com.yogesh.cocguide.fragments.Bombs;
import com.yogesh.cocguide.fragments.SpringTrap;
import com.yogesh.cocguide.fragments.TrapUpgrade;

/**
 * Created by yogesh on 9/1/15.
 */
public class TrapsPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 4;



    public TrapsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0
                return AirBomb.newInstance();
            case 1: // Fragment # 1
                return Bombs.newInstance();
            case 2:
                return SpringTrap.newInstance();
            case 3:
                return TrapUpgrade.newInstance();
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
                return  "Air Bombs";
            case 1:
                return   "Bombs";
            case 2:
                return "Spring Traps";
            case 3:
                return "Trap Upgrades";
        }
        return mTitle;
    }

}



