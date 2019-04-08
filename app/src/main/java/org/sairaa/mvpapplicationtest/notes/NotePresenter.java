package org.sairaa.mvpapplicationtest.notes;

import org.sairaa.mvpapplicationtest.data.NoteRepository;

public class NotePresenter implements NotesContract.UserActionsListener {

    private final NoteRepository mNotesRepository;
    private final NotesContract.View mNotesView;

    public NotePresenter(NoteRepository mNotesRepository, NotesContract.View mNotesView) {
        this.mNotesRepository = mNotesRepository;
        this.mNotesView = mNotesView;
    }

    @Override
    public void loadNotes(String text) {
        mNotesRepository.insert(text);
        mNotesView.showAddNote(mNotesRepository.getData());

    }
}
