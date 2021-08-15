package com.example.myhomework7;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements Constants {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            replaceContainerToFragment(R.id.notes_list_container, ListOfNotesFragment.newInstance());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Fragment backStackFragment = (Fragment) getSupportFragmentManager()
                .findFragmentById(R.id.notes_list_container);
        if (backStackFragment instanceof CurrentNoteFragment) {
            onBackPressed();
        }
    }

    private void replaceContainerToFragment(int containerID, Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerID, fragment)
                .commit();
    }
}