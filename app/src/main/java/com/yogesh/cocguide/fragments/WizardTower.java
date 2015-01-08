package com.yogesh.cocguide.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yogesh.cocguide.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WizardTower#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WizardTower extends Fragment {

    public static WizardTower newInstance() {
        WizardTower fragment = new WizardTower();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public WizardTower() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wizard_tower, container, false);
    }


}
