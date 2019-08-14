package br.com.digitalhouse.viewpage1;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ViewPageAdapter adapter;
    private ArrayList<Fragment> arrayFragments;
    private ArrayList<String> arrayTitles;

    private TabLayout tabLayoutFragments;
    private ViewPager viewPagerFragments;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPagerComTabLayout(view);

        return view;

    }

    private void viewPagerComTabLayout(View view) {

        //Lista dos Fragments disponíveis para View Page
        arrayFragments = new ArrayList<>();
        arrayFragments.add(new LeftFragment());
        arrayFragments.add(new CenterFragment());
        arrayFragments.add(new RightFragment());

        //Lista dos Títulos dos Fragments
        arrayTitles = new ArrayList<>();
        arrayTitles.add("Esquerda");
        arrayTitles.add("Centro");
        arrayTitles.add("Direita");

        tabLayoutFragments = view.findViewById(R.id.tabLayoutFragments);
        viewPagerFragments = view.findViewById(R.id.viewPagerFragments);

        adapter = new ViewPageAdapter(getChildFragmentManager(), arrayFragments, arrayTitles);
        viewPagerFragments.setAdapter(adapter);
        tabLayoutFragments.setupWithViewPager(viewPagerFragments);
    }

}
