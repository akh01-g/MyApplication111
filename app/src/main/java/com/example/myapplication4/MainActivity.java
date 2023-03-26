package com.example.myapplication4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.myapplication4.adapter.NoteAdapter;
import com.example.myapplication4.dialog.NoteDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerNotesList;
    private FloatingActionButton addListButton;

    private Button deleteButton;
    private NoteAdapter noteAdapter = new NoteAdapter();

    private List<Note> noteList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setListeners();
    }

    private void init() {
        recyclerNotesList = findViewById(R.id.rvNotes);
        addListButton = findViewById(R.id.btnAdd);
        recyclerNotesList.setAdapter(noteAdapter);
        deleteButton = findViewById(R.id.btnDelete);
    }

    private void setListeners() {
        addListButton.setOnClickListener(view -> {
            NoteDialog noteDialog = new NoteDialog(this);
            noteDialog.show();
            noteDialog.setClickListener(note -> {
                addNote(note);
            });
        });
    }


    public void addNote(Note note) {
        noteList.add(note);
        noteAdapter.updateNotes(noteList);
    }

//    public void removeNote(Note note) {
//        noteList.remove(note);
//        noteAdapter.updateNotes(noteList);
//    }
}
