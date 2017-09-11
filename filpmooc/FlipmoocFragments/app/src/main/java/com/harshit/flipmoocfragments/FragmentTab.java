package com.harshit.flipmoocfragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTab extends Fragment {

    TabLayout mytablayout;
    ViewPager myviewpager;
    public static final int nosoftab=3;
    public static final String[] tabnames={"First","Second","Third"};
    public FragmentTab() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myview=LayoutInflater.from(getContext()).inflate(R.layout.fragment_fragment_tab,container,false);
        mytablayout=(TabLayout)myview.findViewById(R.id.mytablayout);
        myviewpager=(ViewPager)myview.findViewById(R.id.myviewpager);

        myviewpager.setAdapter(new MyAdapter(getChildFragmentManager()));
        myviewpager.post(new Runnable() {
            @Override
            public void run() {
                mytablayout.setupWithViewPager(myviewpager);
            }
        });

        return myview;
    }

    private class MyAdapter extends FragmentPagerAdapter
    {


        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabnames[position];
        }

        @Override
        public Fragment getItem(int position) {
           switch (position)
           {
               case 0:
                   return new Fragment1();
               case 1:
                   return new Fragment2();
               case 2:
                   return new Fragment3();
           }
            return null;
        }

        @Override
        public int getCount() {
            return nosoftab;
        }
    }
}
