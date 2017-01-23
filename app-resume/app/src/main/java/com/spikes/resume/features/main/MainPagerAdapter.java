package com.spikes.resume.features.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.util.Pair;

import com.spikes.resume.R;
import com.spikes.resume.features.contacts.ContactsFragment;
import com.spikes.resume.features.credits.CreditsFragment;
import com.spikes.resume.features.portfolio.PortfolioFragment;
import com.spikes.resume.features.profile.ProfileFragment;

import java.util.ArrayList;

/**
 * Created by Luca Rossi
 * (luca.rossi@alea.pro) on 17/01/2017.
 */
class MainPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Pair<Fragment, String>> mListPairs;

    MainPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mListPairs = new ArrayList<>(4);
        mListPairs.add(new Pair<>(ProfileFragment.newInstance(), context.getString(R.string.title_profile)));
        mListPairs.add(new Pair<>(PortfolioFragment.newInstance(), context.getString(R.string.title_portfolio)));
        mListPairs.add(new Pair<>(ContactsFragment.newInstance(), context.getString(R.string.title_contacts)));
        mListPairs.add(new Pair<>(CreditsFragment.newInstance(), context.getString(R.string.title_credits)));
    }

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (mListPairs != null)
            return mListPairs.get(position).first;
        return null;
    }

    @Override
    public int getCount() {
        return mListPairs == null ? 0 : mListPairs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mListPairs != null ? mListPairs.get(position).second : "";
    }
}
