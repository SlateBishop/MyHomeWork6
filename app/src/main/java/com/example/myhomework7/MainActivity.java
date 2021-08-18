package com.example.myhomework7;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements Constants {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            replaceContainerToFragment(R.id.notes_container, ListOfNotesFragment.newInstance());
        }
        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
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