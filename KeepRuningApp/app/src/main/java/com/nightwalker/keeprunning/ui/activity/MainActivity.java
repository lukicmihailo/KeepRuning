package com.nightwalker.keeprunning.ui.activity;

import android.app.Activity;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;

import com.nightwalker.keeprunning.ui.fragments.BaseFragment;
import com.nightwalker.keeprunning.ui.fragments.KeepRhytmFragment;
import com.nightwalker.keeprunning.ui.fragments.LongDistanceFragment;
import com.nightwalker.keeprunning.ui.fragments.NavigationDrawerFragment;
import com.nightwalker.keeprunning.R;
import com.nightwalker.keeprunning.ui.fragments.ShortTracksFragment;
import com.nightwalker.keeprunning.ui.fragments.SimpleRunningFragment;

public class MainActivity extends AppCompatActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {


    private NavigationDrawerFragment mNavigationDrawerFragment;

    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        mNavigationDrawerFragment.setUp(R.id.navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = null;
        switch(position){
            case 0: fragment = SimpleRunningFragment.newInstance();break;
            case 1: fragment = KeepRhytmFragment.newInstance();break;
            case 2: fragment = LongDistanceFragment.newInstance();break;
            case 3: fragment = ShortTracksFragment.newInstance();break;
        }
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.simple_running_fragment_title);
                break;
            case 2:
                mTitle = getString(R.string.keep_rhytm_fragment_title);
                break;
            case 3:
                mTitle = getString(R.string.long_distance_fragment_title);
                break;

            case 4:
                mTitle = getString(R.string.short_tracks_fragment_title);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
