package com.example.toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.*;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);//实现ToolBar
        //--------------------------------------------------------------------//
        //通过按钮打开drawer
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);//显示HomeAsUp按钮
            actionBar.setHomeAsUpIndicator(R.drawable.icon1); //修改HomeAsUp按钮图标，默认“←”
        }
        //--------------------------------------------------------------------//
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);//新建menu
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
//            case R.id.download:
//                break;
//            case R.id.search:
//                break;
//            case R.id.notification:
//                break;
            case android.R.id.home://HomeAsUp按钮的id永远是android.R.id.home
                mDrawerLayout.openDrawer(GravityCompat.START);//openDrawer()传入Gravity参数
                break;
            default:
                break;
        }
        return true;
    }
}
