package br.com.sp.senaijandira.newssearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.sp.senaijandira.newssearch.services.ArtigoService;
import br.com.sp.senaijandira.newssearch.services.model.ApiResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Retrofit retrofit  = new Retrofit.Builder().baseUrl(ArtigoService.URL_BASE).addConverterFactory(GsonConverterFactory.create()).build();
        ArtigoService service;
        service = retrofit.create(ArtigoService.class);

        service.getTopArtigos("hacker-news",ArtigoService.KEY_ACCESS).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                ApiResponse resposta = response.body();

                System.out.println(response.headers());

                System.out.print("###################################################################");
                System.out.println(response.message());

            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }
}
