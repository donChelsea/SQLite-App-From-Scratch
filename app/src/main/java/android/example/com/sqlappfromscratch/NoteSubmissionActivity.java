package android.example.com.sqlappfromscratch;

import android.example.com.sqlappfromscratch.database.NoteDatabaseHelper;
import android.example.com.sqlappfromscratch.model.Note;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.zip.DataFormatException;

public class NoteSubmissionActivity extends AppCompatActivity {
    private EditText nameEdittext;
    private EditText messageEdittext;
    private Button submitButton;
    private NoteDatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        databaseHelper = NoteDatabaseHelper.getInstance(getApplicationContext());

        nameEdittext = findViewById(R.id.name_edittext);
        messageEdittext = findViewById(R.id.message_edittext);
        submitButton = findViewById(R.id.submit_note_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String name = nameEdittext.getText().toString();
                    String message = messageEdittext.getText().toString();
                    databaseHelper.addNote(new Note(name, message));
                    Toast.makeText(v.getContext(), "Note saved", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < databaseHelper.getNoteList().size(); i++) {
                    Log.d("Database Row", databaseHelper.getNoteList().get(i).getName() + " " + databaseHelper.getNoteList().get(i).getMessage());
                }
            }
        });
    }
}
