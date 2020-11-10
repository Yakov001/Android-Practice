package API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

// Я без понятия зачем нужен этот интерфейс и что такое @GET. Просто копирую.

public interface PlaceholderAPI {
    @GET ("rates")
    Call<List> getRates();
}
