package application.weatherapi.disha.notesjanitri.ui.ViewNotes;

import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import application.weatherapi.disha.notesjanitri.data.local.Database;
import application.weatherapi.disha.notesjanitri.data.local.Notes;
import application.weatherapi.disha.notesjanitri.data.remote.APIService;
import application.weatherapi.disha.notesjanitri.data.remote.RetrofitClient;
import application.weatherapi.disha.notesjanitri.util.AppExecutors;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewNotesViewModel extends AndroidViewModel {

    private Database database;
    List<Notes> list = new ArrayList<>();
    MutableLiveData<Boolean> isListSet = new MutableLiveData<>();

    public ViewNotesViewModel(@NonNull Application application) {
        super(application);
        database = Database.getInstance(application.getApplicationContext());
    }


    public void getAllNotes() {

        APIService api = RetrofitClient.getApiService();
        Call<List<Notes>> call = api.getNotes();

        call.enqueue(new Callback<List<Notes>>() {
            @Override
            public void onResponse(Call<List<Notes>> call, Response<List<Notes>> response) {
                if (response.isSuccessful())
                {
                    for (int i = 0; i < response.body().size(); i++)
                    {
                        Notes notes = new Notes(response.body().get(i).getUserId(),response.body().get(i).getId(),response.body().get(i).getTitle(),response.body().get(i).isCompleted(),response.body().get(i).getTitle()+" Body");
                        new AppExecutors().diskIO().execute(() -> database.notesDao().insertNote(notes));

                        list.add(notes);
                    }

                    isListSet.setValue(true);
                }
            }

            @Override
            public void onFailure(Call<List<Notes>> call, Throwable t) {
                Log.d("Notes", "onFailure: FAILED---- ");

            }
        });
    }

    public void getAllNotesStorage() {
        new AppExecutors().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                list = database.notesDao().getAllNotes();

                new AppExecutors().mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        isListSet.setValue(true);
                    }
                });
            }
        });
    }
}
