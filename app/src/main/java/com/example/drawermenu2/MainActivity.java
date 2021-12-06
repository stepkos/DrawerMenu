package com.example.drawermenu2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.navigation_draw_open,
                R.string.navigation_draw_close
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.Fragment_container, new HomeFragment);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                Log.i("test", "imasadsa");
                Toast.makeText(this, "sieam", Toast.LENGTH_SHORT).show();
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new HomeFragment()).commit();
                break;
            case R.id.integral_rec:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new RectangleFragment()).commit();
                break;
            case R.id.integral_trapeze:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new TrapezeFragment()).commit();
                break;
            case R.id.integral_simpson:
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, new SimsonFragment()).commit();
                break;
            case R.id.sinus:
                Toast.makeText(this, "clicked sinus", Toast.LENGTH_SHORT).show();
                Log.i("test", "sinus clicked");
                DrawSinus drawSinus = new DrawSinus(this);
//                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container, drawSinus);
                setContentView(drawSinus);
                break;
            case R.id.tangens:
                Toast.makeText(this, "clicked tangens", Toast.LENGTH_SHORT).show();
                Log.i("test", "tangens clicked");
                DrawTangens drawTangens = new DrawTangens(this);
                setContentView(drawTangens);
                break;
        }

        return false;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }

}