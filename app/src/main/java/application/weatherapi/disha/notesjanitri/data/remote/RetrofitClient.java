package application.weatherapi.disha.notesjanitri.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String ROOT_URL = "https://jsonplaceholder.typicode.com/";

    /**
     * Get Retrofit Instance
     */
    private static Retrofit getRetrofitInstance() {
        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static APIService getApiService() {
        return getRetrofitInstance().create(APIService.class);
    }

}
