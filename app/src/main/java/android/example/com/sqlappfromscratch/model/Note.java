package android.example.com.sqlappfromscratch.model;

import android.support.annotation.NonNull;

public class Note {
    private String name;
    private String message;

    public Note(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public Note() {}


    public void setMessage(String message) {
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    public String getMessage() {
        return message;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " | " + message;
    }

}
