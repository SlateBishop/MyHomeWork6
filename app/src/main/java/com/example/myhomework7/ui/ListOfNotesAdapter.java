package com.example.myhomework7.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myhomework7.R;
import com.example.myhomework7.data.CardSource;

public class ListOfNotesAdapter extends RecyclerView.Adapter<ListOfNotesAdapter.ViewHolder> {

    private CardSource dataSource;
    private MyOnClickListener listener;

    public ListOfNotesAdapter(CardSource dataSource) {
        this.dataSource = dataSource;
    }

    public void setMyOnClickListener(MyOnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ListOfNotesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notes, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListOfNotesAdapter.ViewHolder holder, int position) {
        holder.subject.setText(dataSource.getNote(position).getNoteName());
        holder.date.setText(dataSource.getNote(position).getNoteCreatedData());
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView subject;
        private TextView date;

        public ViewHolder(View itemView) {
            super(itemView);
            this.subject = itemView.findViewById(R.id.note_subject);
            this.date = itemView.findViewById(R.id.note_date);
            subject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(view, getAdapterPosition());
                }
            });
        }

//        public TextView getSubject() {
//            return subject;
//        }
//
//        public void setSubject(TextView subject) {
//            this.subject = subject;
//        }
//
//        public TextView getDate() {
//            return date;
//        }
//
//        public void setDate(TextView date) {
//            this.date = date;
//        }
    }
}
