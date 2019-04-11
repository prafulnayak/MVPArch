package org.sairaa.mvpapplicationtest.notes;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.sairaa.mvpapplicationtest.R;
import org.sairaa.mvpapplicationtest.activity.DetailsActivity;
import org.sairaa.mvpapplicationtest.adapter.NoteListAdapter;
import org.sairaa.mvpapplicationtest.data.NoteRepository;

import java.util.ArrayList;
import java.util.List;

public class NotesActivity extends AppCompatActivity implements NotesContract.View{

    private TextView textView;
    private Button add;
    private NotesContract.UserActionsListener mActionsListener;
    private NoteRepository repository;

    private RecyclerView recyclerView;
    private NoteListAdapter adapter;
    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        add = findViewById(R.id.button);
        repository = new NoteRepository();




        mActionsListener = new NotePresenter(repository,this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mActionsListener.loadNotes("hello");
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new NoteListAdapter(list, mActionsListener);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showAddNote(List<String> data) {
        String line = "";
        for(String s:data){
            line = line.concat(s);

        }
        textView.setText(line);
    }

    @Override
    public void showRecViewNote(List<String> data) {
        adapter.update(data);
        adapter.notifyDataSetChanged();


    }

    @Override
    public void showDetailInAnotherActivity(String data) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("data",data);
        startActivity(intent);
    }
}
