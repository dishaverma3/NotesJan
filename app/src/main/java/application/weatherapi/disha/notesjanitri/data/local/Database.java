package application.weatherapi.disha.notesjanitri.data.local;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {Notes.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    public abstract dao notesDao();

    private static Database INSTANCE = null;
    private static Object lock = new Object();

    public static Database getInstance(Context context)
    {
        if(INSTANCE == null)
        {
            synchronized (lock)
            {
                if(INSTANCE == null)
                {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),Database.class,"NotesDatabase")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }

        return INSTANCE;
    }

}
