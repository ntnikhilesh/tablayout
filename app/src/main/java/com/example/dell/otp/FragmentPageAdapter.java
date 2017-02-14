package com.example.dell.otp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by DELL on 2/13/2017.
 */

public class FragmentPageAdapter extends FragmentPagerAdapter {
    public FragmentPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                return new ContactsFragment();
            case 1:
                return new MessagesFragment();
            default:
                break;

        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
