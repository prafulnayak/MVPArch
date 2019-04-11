package org.sairaa.mvpapplicationtest.notes;

import java.util.List;

public interface NotesContract {

    interface View {

        void showAddNote(List<String> data);

        void showRecViewNote(List<String> data);

        void showDetailInAnotherActivity(String data);

    }

    interface UserActionsListener {

        void loadNotes(String text);

        void onRvClick(int position);


    }
}
