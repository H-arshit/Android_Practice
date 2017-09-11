package com.harshit.tabsandswipeview;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
            TabLayout mytab;
            ViewPager mypager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mytab=(TabLayout)findViewById(R.id.mytab);
        mypager=(ViewPager)findViewById(R.id.mypager);
        mypager.setAdapter(new myfragmentadapter(getSupportFragmentManager()));

        mytab.setupWithViewPager(mypager);

    }


    class myfragmentadapter extends FragmentStatePagerAdapter
    {
            String data[]={"Time","Price"};
        public myfragmentadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            if(position==0)
            {
                return new BlankFragment();
            }
            else
            {
                return new Time();
            }
        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return data[position];
        }
    }
}
