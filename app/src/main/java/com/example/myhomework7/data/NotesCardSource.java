package com.example.myhomework7.data;

import android.content.res.Resources;

import com.example.myhomework7.R;

import java.util.ArrayList;
import java.util.List;

public class NotesCardSource implements CardSource {

    private List<Notes> dataSource;
    private Resources resources;

    public NotesCardSource(Resources resources) {
        this.resources = resources;
        dataSource = new ArrayList<>();
    }

    @Override
    public int size() {
        return dataSource.size();
    }

    @Override
    public Notes getNote(int position) {
        return dataSource.get(position);
    }

    public NotesCardSource init() {
        String[] noteName = resources.getStringArray(R.array.noteNamesArray);
        String[] noteBody = resources.getStringArray(R.array.noteBodiesArray);
        String[] noteCreatedData = resources.getStringArray(R.array.noteDataArray);
        for (int i = 0; i < noteName.length; i++) {
            dataSource.add(new Notes(noteName[i], noteBody[i], noteCreatedData[i], i)); //TODO попробовать обойтись без индекса в конструкторе
        }
        return this;
    }
}
