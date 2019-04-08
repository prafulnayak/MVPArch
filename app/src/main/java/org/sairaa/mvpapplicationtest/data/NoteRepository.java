package org.sairaa.mvpapplicationtest.data;

import java.util.ArrayList;
import java.util.List;

public class NoteRepository {
    private static List<String> model = new ArrayList<>();
    private static NoteRepository repository = null;

    public NoteRepository() {
    }

    public void insert(String text){
        model.add(text);
    }

    public List<String> getData(){
        return model;
    }



}
