package com.asad.tablayoutwithviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private AppBarLayout appBarLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;
    private CoordinatorLayout coordinatorLayout;

    private Fragment_Bus_Station fragment_bus_station;
    private Fragment_Rail_Station fragment_rail_station;
    private Fragment_Cricket fragment_cricket;
    private Fragment_Football fragment_football;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        appBarLayout = findViewById(R.id.appbar_layout);
        toolbar = findViewById(R.id.toolbar_id);
        viewPager = findViewById(R.id.view_pager);
        coordinatorLayout = findViewById(R.id.asad);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("TabLayout with ViewPager");

        fragment_bus_station = new Fragment_Bus_Station();
        fragment_rail_station = new Fragment_Rail_Station();
        fragment_cricket = new Fragment_Cricket();
        fragment_football = new Fragment_Football();


        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),0);

        viewPagerAdapter.addFragment(fragment_bus_station,"Movie");
        viewPagerAdapter.addFragment(fragment_rail_station,"Rail");
        viewPagerAdapter.addFragment(fragment_cricket,"Cricket");
        viewPagerAdapter.addFragment(fragment_football,"Football");

        viewPager.setAdapter(viewPagerAdapter);

        tabLayout.getTabAt(0).select();       //selecting initial tab, here 0
        tabLayout.getTabAt(0).setIcon(R.drawable.movie_vector_icon);
        tabLayout.getTabAt(1).setIcon(R.drawable.rail_station_vector_icon);
        tabLayout.getTabAt(2).setIcon(R.drawable.cricket_ground_vector_icon);
        tabLayout.getTabAt(3).setIcon(R.drawable.football_field_vector_icon);

        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#ffffff"));
        tabLayout.setTabTextColors(getResources().getColor(R.color.purple_grey), Color.parseColor("#FFffffff"));

       /* BadgeDrawable badgeDrawable = tabLayout.getTabAt(0).getOrCreateBadge();
        badgeDrawable.setVisible(true);*/


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);

                if (tabLayout.getSelectedTabPosition()==0)
                    coordinatorLayout.setBackgroundColor(Color.parseColor("#ffff8800"));
                if (tabLayout.getSelectedTabPosition()==1)
                    coordinatorLayout.setBackgroundColor(Color.BLUE);
                if (tabLayout.getSelectedTabPosition()==2)
                    coordinatorLayout.setBackgroundColor(Color.GREEN);
                if (tabLayout.getSelectedTabPosition()==3)
                    coordinatorLayout.setBackgroundColor(Color.RED);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(getResources().getColor(R.color.purple_grey), PorterDuff.Mode.SRC_IN);

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //tab.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
            }
        });



    }
}