package com.example.myhomework7;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements Constants {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            replaceContainerToFragment(R.id.notes_container, ListOfNotesFragment.newInstance());
        }
        initDrawer(initToolbar());
    }

    private void initDrawer(Toolbar toolbar) {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,
                drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.action_settings:
                    replaceContainerToFragment(R.id.notes_container, SettingsFragment.newInstance());
                    break;
                case R.id.action_profile_settings:
                    replaceContainerToFragment(R.id.notes_container, ProfileSettingsFragment.newInstance());
                    break;
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return false;
        });
    }

    private Toolbar initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        return toolbar;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                replaceContainerToFragment(R.id.notes_container, AddNoteFragment.newInstance());
                break;
            case R.id.action_edit:
                replaceContainerToFragment(R.id.notes_container, EditNoteFragment.newInstance());
                break;
            case R.id.action_settings:
                replaceContainerToFragment(R.id.notes_container, SettingsFragment.newInstance());
                break;
            case R.id.action_home:
                replaceContainerToFragment(R.id.notes_container, ListOfNotesFragment.newInstance());
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void replaceContainerToFragment(int containerID, Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerID, fragment)
                .commit();
    }
}