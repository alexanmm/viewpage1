package br.com.digitalhouse.viewpage1;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPageAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> arrayFragments;
    private ArrayList<String> arrayTitles;

    public ViewPageAdapter(FragmentManager fragmentManager, ArrayList<Fragment> arrayFragments, ArrayList<String> arrayTitles) {
        super(fragmentManager);
        this.arrayFragments = arrayFragments;
        this.arrayTitles = arrayTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return arrayFragments.get(position);
    }

    @Override
    public int getCount() {
        return arrayFragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return arrayTitles.get(position);
    }
}
