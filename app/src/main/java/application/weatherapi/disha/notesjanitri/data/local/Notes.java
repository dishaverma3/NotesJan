package application.weatherapi.disha.notesjanitri.data.local;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Notes_table")
public class Notes{

    private int userId;

    @ColumnInfo(name = "notes_id")
    @PrimaryKey
    private int id;

    private String title;

    private boolean completed;

    private String notesBody;

    public Notes(int userId, int id, String title, boolean completed, String notesBody) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.notesBody = notesBody;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getNotesBody() {
        return notesBody;
    }

    public void setNotesBody(String notesBody) {
        this.notesBody = notesBody;
    }
}
