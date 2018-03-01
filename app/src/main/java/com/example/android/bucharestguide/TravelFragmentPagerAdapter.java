package com.example.android.bucharestguide;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class TravelFragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {

    final int PAGE_COUNT = 4;
    private Context mContext;
    private String tabTitles[];


    public TravelFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        Resources res = context.getResources();
        tabTitles = new String[]{res.getString(R.string.restaurants),
                res.getString(R.string.entertainment),
                res.getString(R.string.culture),
                res.getString(R.string.parks)};
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            //Restaurant category fragment
            return new CategoryFragment().newInstance(0);
        } else if (position == 1) {
            //Amusement category fragment
            return new CategoryFragment().newInstance(1);
        } else if (position == 2) {
            //Culture category fragment
            return new CategoryFragment().newInstance(2);
        } else
            //Parks category fragment
            return new CategoryFragment().newInstance(3);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
