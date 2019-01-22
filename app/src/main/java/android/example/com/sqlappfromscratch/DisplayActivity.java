package android.example.com.sqlappfromscratch;

import android.content.Intent;
import android.example.com.sqlappfromscratch.controller.NoteAdapter;
import android.example.com.sqlappfromscratch.database.NoteDatabaseHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView nameTv;
    private TextView messageTv;
    private NoteDatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();

        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setAdapter(new NoteAdapter(databaseHelper.getNoteList()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        nameTv = findViewById(R.id.display_name_textview);
        messageTv = findViewById(R.id.display_message_textview);

    }
}
