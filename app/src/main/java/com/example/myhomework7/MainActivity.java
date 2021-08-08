package com.example.myhomework7;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFragments();

    }

    private void setFragments() {
        replaceContainerToFragment(R.id.notes_list_container, ListOfNotesFragment.newInstance());
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            replaceContainerToFragment(R.id.note_body_container, CurrentNoteFragment.newInstance());
        }
    }

    private void replaceContainerToFragment(int containerID, Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerID, fragment)
                .commit();
    }
}