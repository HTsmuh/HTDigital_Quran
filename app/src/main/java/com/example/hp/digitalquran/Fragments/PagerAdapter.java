package com.example.hp.digitalquran.Fragments;

/**
 * Created by HP on 5/4/2017.
 */
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                ParaFragment para = new ParaFragment();
                return para;
            case 1:
                SurahFragment surah = new SurahFragment();
                return surah;
            case 2:
                BookmarkFragment bookmark = new BookmarkFragment();
                return bookmark;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}