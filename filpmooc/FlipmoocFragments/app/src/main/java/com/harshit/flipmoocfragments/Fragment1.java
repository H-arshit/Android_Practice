package com.harshit.flipmoocfragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {


    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment1, container, false);
    }


    @Override
    public void onPause() {
        super.onPause();
        System.out.println("onpause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("ondestroy");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("onresume");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("onstop");
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("onstart");
    }
}
