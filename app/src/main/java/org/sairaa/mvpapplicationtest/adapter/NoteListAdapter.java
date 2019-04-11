package org.sairaa.mvpapplicationtest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.sairaa.mvpapplicationtest.R;
import org.sairaa.mvpapplicationtest.notes.NotesContract;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteViewHolder> {

    private List<String> list;
    NotesContract.UserActionsListener mActionsListener;

    public NoteListAdapter(List<String> list, NotesContract.UserActionsListener mActionsListener) {
        this.list = list;
        this.mActionsListener = mActionsListener;
    }

    public void update(List<String> list){
        this.list = list;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View noteView = inflater.inflate(R.layout.item_note, parent, false);

        return new NoteViewHolder(noteView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int i) {
        String itemString = list.get(i);
        holder.textView.setText(itemString);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView textView;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_rv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            mActionsListener.onRvClick(position);
        }
    }
}
