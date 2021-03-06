package com.github.takumalee.simplematerialpager.example.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.github.takumalee.simplematerialpager.example.MainActivity;
import com.github.takumalee.simplematerialpager.example.R;
import com.github.takumalee.simplematerialpager.example.fragment.SuperAwesomeCardFragment;
import com.github.takumalee.simplematerialtabpager.view.MTP;
import com.github.takumalee.simplematerialtabpager.view.SimpleMaterialTabPagerView;

public class CustomTabActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private SimpleMaterialTabPagerView mPagerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_tab);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative_CustomTab);
        mPagerView = new SimpleMaterialTabPagerView.Builder(MTP.CUSTOM)
                .enableActionBar()
                .addSection(MainActivity.getCustomTab(this, 0), SuperAwesomeCardFragment.newInstance(1))
                .addSection(MainActivity.getCustomTab(this, 1), SuperAwesomeCardFragment.newInstance(2))
                .addSection(MainActivity.getCustomTab(this, 2), SuperAwesomeCardFragment.newInstance(3))
                .build(this);
        mPagerView.setFitsSystemWindows(false);
        mPagerView.changeTabTextWithIndicatorColor(Color.WHITE);
        mPagerView.changePrimaryColor(getResources().getColor(android.R.color.holo_blue_bright));
        mPagerView.getToolbar().setTitleTextColor(getResources().getColor(android.R.color.white));
        relativeLayout.addView(mPagerView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_custom_tab, menu);
        return true;
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
