package com.example.myhomework7;

import android.os.Parcel;
import android.os.Parcelable;

public class Notes implements Parcelable {
    private String noteName;
    private String noteBody;
    private String noteCreateData;








    protected Notes(Parcel in) {
        noteName = in.readString();
        noteBody = in.readString();
        noteCreateData = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(noteName);
        dest.writeString(noteBody);
        dest.writeString(noteCreateData);
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
}
