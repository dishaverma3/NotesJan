package application.weatherapi.disha.notesjanitri.data.local;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(Notes note);

    @Query("SELECT * FROM notes_table")
    List<Notes> getAllNotes();

    @Query("SELECT * FROM notes_table WHERE notes_id =:id")
    Notes getNoteById(int id);

    @Update
    void updateNotes(Notes notesEntity);

}
