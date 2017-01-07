package com.example.andreyshem.test1;

import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.andreyshem.test1.adapters.MyFragmentAdapter;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager mVPager;
    private DrawerLayout drawer;
    private ListView mlist;
    private ListView mSecondlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mVPager = (ViewPager) findViewById(R.id.mVPager);
        FragmentPagerAdapter mAdaptViewPager = new MyFragmentAdapter(getSupportFragmentManager());
        mVPager.setAdapter(mAdaptViewPager);
        mVPager.setClipToPadding(false);
        mVPager.setPageMargin(12);
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        initializeListView();

        if (id == R.id.settingLine1) {
            mVPager.setCurrentItem(0);
            mlist.getChildAt(0).setBackgroundColor(getResources().getColor(R.color.clBYellow));
            return true;
        } if (id == R.id.settingLine2){
            mVPager.setCurrentItem(0);
            mlist.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.clBYellow));
        }if (id == R.id.settingLine3){
            mVPager.setCurrentItem(1);
            mSecondlist.getChildAt(0).setBackgroundColor(getResources().getColor(R.color.clBYellow));
        }if (id == R.id.settingLine4){
            mVPager.setCurrentItem(1);
            mSecondlist.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.clBYellow));
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();
        initializeListView();

        mSecondlist.getChildAt(0).getSolidColor();

        if (id == R.id.nav_camera) {
            mVPager.setCurrentItem(0);
            drawer.closeDrawer(GravityCompat.START);
        } if (id == R.id.nav_gallery) {
            mVPager.setCurrentItem(1);
            drawer.closeDrawer(GravityCompat.START);
        } if(id == R.id.line1){
            mVPager.setCurrentItem(0);
            mlist.getChildAt(0).setBackgroundColor(getResources().getColor(R.color.clBYellow));
            drawer.closeDrawer(GravityCompat.START);

        }if(id == R.id.line2){
            mVPager.setCurrentItem(0);
            mlist.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.clBYellow));
            drawer.closeDrawer(GravityCompat.START);
        }if(id == R.id.line3){
            mVPager.setCurrentItem(1);
            mSecondlist.getChildAt(0).setBackgroundColor(getResources().getColor(R.color.clBYellow));
            drawer.closeDrawer(GravityCompat.START);
        }if(id == R.id.line4){
            mVPager.setCurrentItem(1);
            mSecondlist.getChildAt(1).setBackgroundColor(getResources().getColor(R.color.clBYellow));
            drawer.closeDrawer(GravityCompat.START);
        }
        return true;
    }

    private void initializeListView(){
         mlist = (ListView)findViewById(R.id.my_listview);
         mSecondlist = (ListView)findViewById(R.id.my_second_listview);
    }
}
