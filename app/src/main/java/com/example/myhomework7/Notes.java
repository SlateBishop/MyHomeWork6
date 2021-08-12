package com.example.myhomework7;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Notes implements Parcelable, Constants {
    private String noteName;
    private String noteBody;
    private String noteCreatedData;
    private int noteIndex;

    public Notes(String noteName, String noteBody, String noteCreatedData, int noteIndex) {
        this.noteName = noteName;
        this.noteBody = noteBody;
        this.noteCreatedData = noteCreatedData;
        this.noteIndex = noteIndex;
    }

    protected Notes(Parcel in) {
        noteName = in.readString();
        noteBody = in.readString();
        noteCreatedData = in.readString();
        noteIndex = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(noteName);
        dest.writeString(noteBody);
        dest.writeString(noteCreatedData);
        dest.writeInt(noteIndex);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Notes> CREATOR = new Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };

    public String getNoteName() {
        return noteName;
    }

    public void setNoteName(String noteName) {
        this.noteName = noteName;
    }

    public String getNoteBody() {
        return noteBody;
    }

    public void setNoteBody(String noteBody) {
        this.noteBody = noteBody;
    }

    public String getNoteCreatedData() {
        return noteCreatedData;
    }

    public void setNoteCreatedData(String noteCreatedData) {
        this.noteCreatedData = noteCreatedData;
    }

    public int getNoteIndex() {
        return noteIndex;
    }

    public void setNoteIndex(int noteIndex) {
        this.noteIndex = noteIndex;
    }
}

