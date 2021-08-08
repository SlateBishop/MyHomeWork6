package com.example.myhomework7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CurrentNoteFragment extends Fragment implements Constants {


    public CurrentNoteFragment() {

    }

    public static CurrentNoteFragment newInstance() {
        CurrentNoteFragment fragment = new CurrentNoteFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_current_note, container, false);
        return view;
    }
}