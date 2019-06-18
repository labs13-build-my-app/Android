package com.buildmyapp.android.BottomNavFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.buildmyapp.android.R;


public class BottomNavigation extends AppCompatActivity  {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);


        BottomNavigationView bottomNav = findViewById(R.id.navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
       // ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
               // this, drawer,, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
      //  drawer.addDrawerListener(toggle);
       // toggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem Item) {
                    Fragment selectedFragment = null;

                    switch (Item.getItemId()) {
                        case R.id.navigationHome:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.navigationMyProfile:
                            selectedFragment = new UserFragment();
                            break;
                        case R.id.navigationSearch:
                            selectedFragment = new SearchFragment();
                            break;
                        case R.id.navigationMyDev:
                            selectedFragment = new DevelopersFragment();
                            break;
                        case  R.id.navigationMenu:
                            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                            drawer.openDrawer(GravityCompat.START);
                            return true;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
}