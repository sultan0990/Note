package com.example.note;
import androidx.room.Entity;
import  androidx.room.PrimaryKey;

@Entity(tableName = "my_room")
public class Note {
    private  String titel;
    private String disv;

    @PrimaryKey(autoGenerate = true)
    private  int id;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }

    public Note(String titel, String disv) {
        this.titel = titel;
        this.disv = disv;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getDisv() {
        return disv;
    }

    public void setDisv(String disv) {
        this.disv = disv;
    }
}
