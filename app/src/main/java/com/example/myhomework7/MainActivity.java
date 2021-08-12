package com.example.myhomework7;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity implements Constants {

    private Notes note;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            note = savedInstanceState.getParcelable(NOTES_SAVE_INSTANCE_KEY);
        }
        note = new Notes("1", "2", "3", 2); // TODO ПОНЯТЬ ЧТО ЗА МАГИЯ И ДЬЯВОЛЬЩИНА ТУТ ТВОРИТСЯ!!!
            setContentView(R.layout.activity_main);
            setFragments(note);

    }

    private void setFragments(Notes note) {
        replaceContainerToFragment(R.id.notes_list_container, ListOfNotesFragment.newInstance());
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            replaceContainerToFragment(R.id.note_body_container, CurrentNoteFragment.newInstance(note));
        }
    }

    private void replaceContainerToFragment(int containerID, Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(containerID, fragment)
                .commit();
    }
}