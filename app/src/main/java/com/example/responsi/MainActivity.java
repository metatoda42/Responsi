package com.example.responsi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    private BottomNavigationView navbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navbar = findViewById(R.id.main_navbar);
        navbar.setOnNavigationItemSelectedListener(this);
        loadFragment(new Fragment());
        loadFragment(new FragmentHome());

    }

    private boolean loadFragment(Fragment fragment) {
        if(fragment != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_frame, fragment)
                    .commit();
            return true;

        }
        return false;
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = new FragmentHome();

        switch (item.getItemId()){
            case R.id.kasus:
                fragment=new FragmentHome();
                break;
            case R.id.rujuk:
                fragment=new FragmentRujuk();
                break;


        }

        return loadFragment(fragment);
    }
}