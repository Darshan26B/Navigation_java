package com.example.navigation_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity {


   public NavigationView nav_drawer;
   public DrawerLayout  drawer;
    androidx.appcompat.widget.Toolbar toolbar1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawer = findViewById(R.id.nav_drawer);
        nav_drawer = findViewById(R.id.nav_view);
        toolbar1 = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar1);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar1,R.string.open_nav,R.string.close_nav);
        drawer.closeDrawer(GravityCompat.START);

        drawer.addDrawerListener(toggle);

        toggle.syncState();

        nav_drawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.home2) {
                    Toast.makeText(getApplicationContext(),"Home",Toast.LENGTH_SHORT).show();
                } else if (id == R.id.message2 ) {
                    Toast.makeText(getApplicationContext(),"message",Toast.LENGTH_SHORT).show();

                } else if (id == R.id.log_out2) {
                    Toast.makeText(getApplicationContext(),"log-out",Toast.LENGTH_SHORT).show();

                }


                return true;
            }
        });


    }

    @Override
    public void onBackPressed() {

        if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
        } else {

            super.onBackPressed();
        }
    }
}