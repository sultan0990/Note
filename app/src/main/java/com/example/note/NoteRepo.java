package com.example.note;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepo {
    private NoteDao noteDao;
    private LiveData<List<Note>> noteList;

   public NoteRepo(Application application){
       NoteDatabase noteDatabase=NoteDatabase.getInstance(application);
       noteDao=noteDatabase.noteDao();
       noteList=noteDao.getAllData();
   }
   public void insertData(Note note){new InsertTask(noteDao).execute(note);}
    public void updateData(Note note){new UpdateTask(noteDao).execute(note);}
    public void deleteData(Note note){new DeleteTask(noteDao).execute(note);}
   public LiveData<List<Note>>getAllData(){
       return noteList;
   }
   private static class InsertTask extends AsyncTask<Note,Void,Void>{
       private NoteDao noteDao;

       public InsertTask(NoteDao noteDao) {
           this.noteDao = noteDao;
       }
       @Override
       protected Void doInBackground(Note... notes){
           noteDao.insert(notes[0]);
           return  null;
       }
   }
    private static class UpdateTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;

        public UpdateTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes){
            noteDao.update(notes[0]);
            return  null;
        }
    }

    private static class DeleteTask extends AsyncTask<Note,Void,Void>{
        private NoteDao noteDao;

        public DeleteTask(NoteDao noteDao) {
            this.noteDao = noteDao;
        }
        @Override
        protected Void doInBackground(Note... notes){
            noteDao.delete(notes[0]);
            return  null;
        }
    }


}
