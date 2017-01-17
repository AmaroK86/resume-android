package com.spikes.resume.features.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Luca Rossi
 * (luca.rossi@alea.pro) on 17/01/2017.
 */
class MainPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mListFragments;

    MainPagerAdapter(FragmentManager fm, ArrayList<Fragment> listFragments) {
        super(fm);
        mListFragments = listFragments;
    }

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (mListFragments != null)
            return mListFragments.get(position);
        return null;
    }

    @Override
    public int getCount() {
        return mListFragments == null ? 0 : mListFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }
}
