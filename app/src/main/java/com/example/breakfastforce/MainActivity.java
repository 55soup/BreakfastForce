package com.example.breakfastforce;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    InfopageActivity infopageActivity;
    LoginActivity loginActivity;
    ImageView mainImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        infopageActivity = new InfopageActivity();
        loginActivity = new LoginActivity();

        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();

        BottomNavigationView bottomNavigation = findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.tab1:
                        Toast.makeText(getApplicationContext(),"첫번째",Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit();
                        return true;

                    case R.id.tab2:
                        Toast.makeText(getApplicationContext(),"두번째",Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();
                        return true;

                    case R.id.tab3:
                        Toast.makeText(getApplicationContext(),"세번째",Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment3).commit();
                        return true;

                    case R.id.tab4:
                        Toast.makeText(getApplicationContext(),"네번째",Toast.LENGTH_SHORT).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,infopageActivity).commit();
                        return true;
                }
                return false;
            }
        });
    }
}
