package com.spikes.resume.features.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.roughike.bottombar.BottomBar;
import com.spikes.resume.R;
import com.spikes.resume.features.contacts.ContactsFragment;
import com.spikes.resume.features.credits.CreditsFragment;
import com.spikes.resume.features.portfolio.PortfolioFragment;
import com.spikes.resume.features.profile.ProfileFragment;
import com.spikes.resume.shared.AppCompatActivityExt;
import com.spikes.resume.shared.NonSwipeableViewPager;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends AppCompatActivityExt {

    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    private MainPagerAdapter mPagerAdapter;

    @BindView(R.id.pager_main)
    NonSwipeableViewPager mPager;
    @BindView(R.id.bottom_bar_main)
    BottomBar mBottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Fragment> fragments = new ArrayList<>(4);
        fragments.add(ProfileFragment.newInstance());
        fragments.add(PortfolioFragment.newInstance());
        fragments.add(ContactsFragment.newInstance());
        fragments.add(CreditsFragment.newInstance());

        mPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), fragments);
        mPager.setAdapter(mPagerAdapter);
    }
}
