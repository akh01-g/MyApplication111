package com.example.myapplication4.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication4.R;
import com.example.myapplication4.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {

    private List<Note> notesList = new ArrayList<>();

    public void updateNotes(List<Note> newNotesList) {
        notesList = newNotesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View noteView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note, parent, false);

        return new NoteViewHolder(noteView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = notesList.get(position);

        holder.titleText.setText(note.title);
        holder.descriptionText.setText(note.description);
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView titleText;
        TextView descriptionText;

        public NoteViewHolder(View noteView) {
            super(noteView);

            titleText = noteView.findViewById(R.id.tvTitle);
            descriptionText = noteView.findViewById(R.id.tvDescription);
        }
    }
}
