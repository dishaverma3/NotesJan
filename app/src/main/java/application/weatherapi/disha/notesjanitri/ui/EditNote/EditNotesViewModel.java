package application.weatherapi.disha.notesjanitri.ui.EditNote;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import application.weatherapi.disha.notesjanitri.data.local.Database;
import application.weatherapi.disha.notesjanitri.data.local.Notes;
import application.weatherapi.disha.notesjanitri.util.AppExecutors;

public class EditNotesViewModel extends AndroidViewModel{
    Database database;
    Notes notes;
    MutableLiveData<Boolean> isDataSet = new MutableLiveData<>();

    public EditNotesViewModel(@NonNull Application application) {
        super(application);

        database = Database.getInstance(application.getApplicationContext());
    }

    public void getData(int id) {

        new AppExecutors().diskIO().execute(() -> {
            notes = database.notesDao().getNoteById(id);

            new AppExecutors().mainThread().execute(() -> isDataSet.setValue(true));
        });


    }
}
