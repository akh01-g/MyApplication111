package com.example.myapplication4.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;

import com.example.myapplication4.R;
import com.example.myapplication4.Note;
import com.google.android.material.button.MaterialButton;

public class NoteDialog extends Dialog {

    private SaveClickListener saveClickListener;

    private EditText titleEditText;
    private EditText descriptionEditText;

    private MaterialButton cancelButton;
    private MaterialButton saveButton;

    public NoteDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_note);

        init();

        setListeners();
    }

    private void init() {
        titleEditText = findViewById(R.id.etTitle);
        descriptionEditText = findViewById(R.id.etDescription);

        cancelButton = findViewById(R.id.btnCancel);
        saveButton = findViewById(R.id.btnSave);
    }

    private void setListeners() {
        cancelButton.setOnClickListener(view -> {
            dismiss();
        });

        saveButton.setOnClickListener(view -> {
            String text = titleEditText.getText().toString();
            String description = descriptionEditText.getText().toString();

            if (saveClickListener != null)
                saveClickListener.onClick(new Note(text, description));

            dismiss();
        });
    }

    public interface SaveClickListener {
        void onClick(Note note);
    }

    public void setClickListener(SaveClickListener saveClickListener) {
        this.saveClickListener = saveClickListener;
    }
}
