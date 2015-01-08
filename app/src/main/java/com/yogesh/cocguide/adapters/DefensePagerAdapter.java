package com.yogesh.cocguide.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.yogesh.cocguide.fragments.AirDefense;
import com.yogesh.cocguide.fragments.ArcherTower;
import com.yogesh.cocguide.fragments.HiddenTesla;
import com.yogesh.cocguide.fragments.Inferno;
import com.yogesh.cocguide.fragments.WizardTower;
import com.yogesh.cocguide.fragments.Xbow;

/**
 * Created by yogesh on 9/1/15.
 */
public class DefensePagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 6;



    public DefensePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0
                return AirDefense.newInstance();
            case 1: // Fragment # 1
                return ArcherTower.newInstance();
            case 2: // Fragment # 1
                return HiddenTesla.newInstance();
            case 3: // Fragment # 1
                return Inferno.newInstance();
            case 4: // Fragment # 1
                return WizardTower.newInstance();
            case 5: // Fragment # 1
                return Xbow.newInstance();
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
                return  "Air Defense";
            case 1:
                return   "Archer Tower";
            case 2:
                return   "Hidden Tesla";
            case 3:
                return   "Inferno";
            case 4:
                return   "Wizard Tower";
            case 5:
                return   "Xbow";
        }
        return mTitle;
    }

}

