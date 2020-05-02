package com.myprojects.coupon1;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


public class TopActivity extends AppCompatActivity {

    private final int BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        //attachin pager adapter below to view pager
        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), getLifecycle());
        ViewPager2 vp = (ViewPager2) findViewById(R.id.view_pager);

        vp.setAdapter(pagerAdapter);

        //attach the view pager to the tab layout
        TabLayout tl = (TabLayout) findViewById(R.id.tabs);

        new TabLayoutMediator(tl, vp,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position){
                            case 0:
                                tab.setText("My Coupons");
                                    break;
                            case 1:
                                tab.setText("My Offers");
                                break;
                                
                        }

                        //tab.setText("OBJECT " + (position + 1));
                    }
                }).attach();
    }



    private static class SectionsPagerAdapter extends FragmentStateAdapter {



        public SectionsPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            switch (position){
                case 0:
                    return new MyCoupons();

                case 1:
                    return new MyOffers();
            }



            return null;
        }

        @Override
        public int getItemCount() {
            return 2;
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }

//        public CharSequence getPageTitle(){
//
//        }


    }


}

