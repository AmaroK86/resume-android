package com.spikes.resume.features.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.spikes.resume.R;
import com.spikes.resume.shared.AppCompatActivityExt;
import com.spikes.resume.shared.NonSwipeableViewPager;

import butterknife.BindView;

public class MainActivity extends AppCompatActivityExt {

    @BindView(R.id.pager_main)
    NonSwipeableViewPager mPager;
    @BindView(R.id.bottom_bar_main)
    BottomBar mBottomBar;
    private MainPagerAdapter mPagerAdapter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPagerAdapter = new MainPagerAdapter(this, getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        mBottomBar.setOnTabSelectListener(tabId -> {
            int position = 0;
            switch (tabId) {
                case R.id.tab_profile:
                    position = 0;
                    break;
                case R.id.tab_portfolio:
                    position = 1;
                    break;
                case R.id.tab_contacts:
                    position = 2;
                    break;
                case R.id.tab_credits:
                    position = 3;
                    break;
            }
            mPager.setCurrentItem(position);
            setTitle(mPagerAdapter.getPageTitle(position));
        });
    }
}
