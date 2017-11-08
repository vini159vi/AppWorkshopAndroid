package android.workshop.com.app_workshop_android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by IFSP- on 07/11/2017.
 */

public class NoteActivity extends AppCompatActivity
{
    static ArrayList<Note> noteList = new ArrayList<Note>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);


        final EditText editTextTitle = findViewById(R.id.edit_title);
        final EditText editTextDescription = findViewById(R.id.edit_description);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Note note = new Note();

                String title = editTextTitle.getText().toString();
                String description = editTextDescription.getText().toString();

                note.setTitle(title);
                note.setDescription(description);

                Toast.makeText(NoteActivity.this, "Nota:" +note.getTitle()+ " Salva" , Toast.LENGTH_SHORT).show();

                noteList.add(note);

                finish();
            }
        });

    }
}
