package com.ydp.yunmigroup.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ydp.yunmigroup.R;
import com.ydp.yunmigroup.ui.fragment.BaseFragment;
import com.ydp.yunmigroup.ui.fragment.ContentFragment;
import com.ydp.yunmigroup.ui.fragment.DrawerFragment;


public class MainActivity extends BaseActivity {
    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawLayout;
    private DrawerFragment mBlankFragment;
    private BaseFragment mBaseFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawLayout = (DrawerLayout) findViewById(R.id.drawer_layout);


        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawLayout, R.drawable.ic_drawer, R.drawable.ic_drawer, R.drawable.ic_drawer) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawLayout.setDrawerListener(mDrawerToggle);
        setCategory("测试");
        mBlankFragment = DrawerFragment.newInstance("blank");
        replaceFragment(R.id.left_drawer, mBlankFragment);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
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

    /**
     * 设置主页面显示的内容
     * @param tip
     */
    public void setCategory(String tip) {
        mDrawLayout.closeDrawer(GravityCompat.START);
        mBaseFragment = ContentFragment.newInstance(tip);
        replaceFragment(R.id.content_frame, mBaseFragment);
    }

    private void replaceFragment(int viewId, BaseFragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(viewId, fragment).commit();
    }
}
