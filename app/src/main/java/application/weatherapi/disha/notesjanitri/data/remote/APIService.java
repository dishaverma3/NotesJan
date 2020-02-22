package application.weatherapi.disha.notesjanitri.data.remote;

import java.util.List;

import application.weatherapi.disha.notesjanitri.data.local.Notes;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("todos/")
    Call<List<Notes>> getNotes();
}
