package android.workshop.com.app_workshop_android;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thebluealliance.spectrum.SpectrumDialog;

import java.util.ArrayList;

/**
 * Created by IFSP- on 07/11/2017.
 */

public class NoteActivity extends AppCompatActivity
{
    static ArrayList<Note> noteList = new ArrayList<Note>();
    Note note;
    int color = Color.parseColor("#F06292");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);


        final EditText editTextTitle = findViewById(R.id.edit_title);
        final EditText editTextDescription = findViewById(R.id.edit_description);

        final View viewSelectColor = findViewById(R.id.viewColor);
        viewSelectColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SpectrumDialog.Builder(NoteActivity.this)
                        .setColors(R.array.card_colorsBackground2)
                        .setSelectedColorRes(R.color.colorPink)
                        .setDismissOnColorSelected(true)
                        .setOnColorSelectedListener(new SpectrumDialog.OnColorSelectedListener() {
                            @Override public void onColorSelected(boolean positiveResult, @ColorInt int color) {
                                if (positiveResult) {
                                    viewSelectColor.setBackgroundColor(color);
                                    NoteActivity.this.color = color;
                                    Toast.makeText(NoteActivity.this, "Color selected: #" + Integer.toHexString(color).toUpperCase(), Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(NoteActivity.this, "Dialog cancelled", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }).build().show(getSupportFragmentManager(), "dialog_demo_1");
            }
        });
        Button button = findViewById(R.id.button);

        Bundle extras = getIntent().getExtras();
        if(extras != null){

            note = (Note) extras.get("noteExtra");

            editTextTitle.setText(note.getTitle());
            editTextDescription.setText(note.getDescription());
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextTitle.getText().toString();
                String description = editTextDescription.getText().toString();

                if(note == null) {
                    note = new Note();
                }

                Note note = new Note();
                note.setTitle(title);
                note.setDescription(description);
                note.setColor(color);
                noteList.add(note);
                Toast.makeText(NoteActivity.this, "Nota:" +note.getTitle()+ " Salva" , Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
