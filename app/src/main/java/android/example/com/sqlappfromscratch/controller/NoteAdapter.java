package android.example.com.sqlappfromscratch.controller;

import android.example.com.sqlappfromscratch.R;
import android.example.com.sqlappfromscratch.database.NoteDatabaseHelper;
import android.example.com.sqlappfromscratch.model.Note;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder> {
    private List<Note> noteList = new ArrayList<>();

    public NoteAdapter(List<Note> noteList) {
        this.noteList = noteList;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.note_list_view, viewGroup, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder noteViewHolder, int i) {
        noteViewHolder.nameTv.setText(noteList.get(i).getName());
        noteViewHolder.messageTv.setText(noteList.get(i).getMessage());
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        TextView nameTv;
        TextView messageTv;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            this.nameTv = itemView.findViewById(R.id.display_name_textview);
            this.messageTv = itemView.findViewById(R.id.display_message_textview);
        }
    }


}
