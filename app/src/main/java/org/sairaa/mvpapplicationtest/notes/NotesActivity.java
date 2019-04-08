package org.sairaa.mvpapplicationtest.notes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.sairaa.mvpapplicationtest.R;
import org.sairaa.mvpapplicationtest.data.NoteRepository;

import java.util.List;

public class NotesActivity extends AppCompatActivity implements NotesContract.View{

    private TextView textView;
    private Button add;
    private NotesContract.UserActionsListener mActionsListener;
    private NoteRepository repository;

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

                mActionsListener.loadNotes("hello ");
            }
        });
    }

    @Override
    public void showAddNote(List<String> data) {
        String line = "";
        for(String s:data){
            line = line.concat(s);

        }
        textView.setText(line);
    }
}
