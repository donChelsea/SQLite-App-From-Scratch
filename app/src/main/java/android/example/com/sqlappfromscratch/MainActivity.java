package android.example.com.sqlappfromscratch;

import android.content.Intent;
import android.example.com.sqlappfromscratch.database.NoteDatabaseHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView databaseTextview;
    private Button addNoteButton;
    private Button viewNotesButton;
    NoteDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = NoteDatabaseHelper.getInstance(getApplicationContext());

        databaseTextview = findViewById(R.id.name_textview);
        addNoteButton = findViewById(R.id.add_note_button);
        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), NoteSubmissionActivity.class);
                startActivity(intent);
            }
        });
        viewNotesButton = findViewById(R.id.view_notes_button);
        viewNotesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras = new Bundle();
                extras.putString();
                Intent intent = new Intent(v.getContext(), DisplayActivity.class);
                startActivity(intent);
            }
        });
    }
}
