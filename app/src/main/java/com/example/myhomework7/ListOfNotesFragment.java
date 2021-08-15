package com.example.myhomework7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class ListOfNotesFragment extends Fragment implements Constants {

    private Notes note;

    public static ListOfNotesFragment newInstance() {
        return new ListOfNotesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            note = savedInstanceState.getParcelable(NOTES_SAVE_INSTANCE_KEY);
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
        showNotePort();
    }

    private void showNotePort() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.notes_container, CurrentNoteFragment.newInstance(note))
                .addToBackStack(BACK_STACK_TAG)
                .commit();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(NOTES_SAVE_INSTANCE_KEY, note);
        super.onSaveInstanceState(outState);
    }
}