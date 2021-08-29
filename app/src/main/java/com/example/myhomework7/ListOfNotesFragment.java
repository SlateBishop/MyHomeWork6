package com.example.myhomework7;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        CardSource data = new NotesCardSource(getResources()).init();
        ListOfNotesAdapter listOfNotesAdapter = new ListOfNotesAdapter(data);
        setListeners(listOfNotesAdapter);
        recyclerView.setAdapter(listOfNotesAdapter);
    }

    private void setListeners(ListOfNotesAdapter listOfNotesAdapter) {
        listOfNotesAdapter.setMyOnClickListener(new MyOnClickListener() {
            @Override
            public void onClick(View view, int position) {
                showNote(position);
            }
        });
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

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable(NOTES_SAVE_INSTANCE_KEY, note);
        super.onSaveInstanceState(outState);
    }
}