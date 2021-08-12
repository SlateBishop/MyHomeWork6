package com.example.myhomework7;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class CurrentNoteFragment extends Fragment implements Constants {
    private Notes note;
    private EditText nameEditText;
    private EditText bodyEditText;
    private TextView dataTextView;

    public CurrentNoteFragment() {
    }

    public static CurrentNoteFragment newInstance(Notes note) {
        CurrentNoteFragment fragment = new CurrentNoteFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(NOTES_SAVE_INSTANCE_KEY, note);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.note = getArguments().getParcelable(NOTES_SAVE_INSTANCE_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_note, container, false);
        initView(view);
        setText();
        return view;
    }

    private void setText() {
        nameEditText.setText(this.note.getNoteName());
        bodyEditText.setText(this.note.getNoteBody());
        dataTextView.setText(this.note.getNoteCreatedData());
    }

    private void initView(View view) {
        nameEditText = view.findViewById(R.id.note_subject_edit_text);
        bodyEditText = view.findViewById(R.id.note_body_edit_text);
        dataTextView = view.findViewById(R.id.note_date_text);
    }
}