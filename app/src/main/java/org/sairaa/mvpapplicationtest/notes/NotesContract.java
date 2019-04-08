package org.sairaa.mvpapplicationtest.notes;

import java.util.List;

public interface NotesContract {

    interface View {

        void showAddNote(List<String> data);

    }

    interface UserActionsListener {

        void loadNotes(String text);


    }
}
