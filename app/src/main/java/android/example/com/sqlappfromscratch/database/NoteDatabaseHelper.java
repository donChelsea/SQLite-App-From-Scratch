package android.example.com.sqlappfromscratch.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.example.com.sqlappfromscratch.model.Note;

import java.util.ArrayList;
import java.util.List;

public class NoteDatabaseHelper extends SQLiteOpenHelper {
    private static NoteDatabaseHelper databaseHelper;
    private static final String DATABASE_NAME = "notes_database.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Notes";

    public NoteDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static synchronized NoteDatabaseHelper getInstance(Context context) {
        if (databaseHelper == null) {
            databaseHelper = new NoteDatabaseHelper(context.getApplicationContext(), DATABASE_NAME, null, DATABASE_VERSION);
        }
        return databaseHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, message, TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addNote(Note note) {
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + " WHERE name = '" + note.getName() +
                        "' AND message = '" + note.getMessage() + "';", null);
        if (cursor.getCount() == 0) {
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME + "(name, message) VALUES('" +
                    note.getName() + "', '" + note.getMessage() + "');");
            cursor.close();
        }
    }

    public List<Note> getNoteList() {
        List<Note> noteList = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT * FROM " + TABLE_NAME + ";", null);
        if (cursor.moveToFirst()) {
            do {
                // Create a new fellow instance with the values of each entry
                Note note = new Note(
                        cursor.getString(cursor.getColumnIndex("name")),
                        cursor.getString(cursor.getColumnIndex("message")));
                // add this new fellow instance to our List
                noteList.add(note);
                // while there are more fellow entries to get, keep looping.
            } while (cursor.moveToNext());
        }
        return noteList;
    }
}
