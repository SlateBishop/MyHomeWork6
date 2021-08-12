package com.example.myhomework7;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ListOfNotesFragment extends Fragment implements Constants {

    private Notes note;

    public ListOfNotesFragment() {
    }

    public static ListOfNotesFragment newInstance() {
        return new ListOfNotesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            note = savedInstanceState.getParcelable(NOTES_SAVE_INSTANCE_KEY);
        }
        if (isLandscape()) {
            if (note != null) {
                showNote(note.getNoteIndex());
            } else {
                showNote(0);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_of_notes, container, false);
        LinearLayout linearLayout = (LinearLayout) view;
        String[] notes = getResources().getStringArray(R.array.noteNamesArray);

        for (int i = 0; i < notes.length; i++) {
            String name = notes[i];
            int index = i;
            TextView textView = new TextView(requireContext());
            textView.setText(name);
            textView.setTextSize(TEXT_SIZE);
            linearLayout.addView(textView);
            textView.setOnClickListener(v -> showNote(index));
        }

        return view;
    }

    private void showNote(int i) {
        note = new Notes(getResources().getStringArray(R.array.noteNamesArray)[i],
                getResources().getStringArray(R.array.noteBodiesArray)[i],
                getResources().getStringArray(R.array.noteDataArray)[i],
                i);

        if (isLandscape()) {
            showNoteLand();
        } else {
            showNotePort();
        }

    }

    private boolean isLandscape() {
        return getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    private void showNotePort() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.notes_list_container, CurrentNoteFragment.newInstance(note))
                .addToBackStack(BACK_STACK_TAG)
                .commit();
    }

    private void showNoteLand() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.note_body_container, CurrentNoteFragment.newInstance(note))
                .commit();
    }
}