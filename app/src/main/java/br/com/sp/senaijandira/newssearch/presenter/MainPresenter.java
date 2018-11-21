package br.com.sp.senaijandira.newssearch.presenter;

import android.support.annotation.NonNull;

import br.com.sp.senaijandira.newssearch.services.ArtigoService;
import br.com.sp.senaijandira.newssearch.services.model.ApiResponse;
import br.com.sp.senaijandira.newssearch.services.model.Artigo;
import br.com.sp.senaijandira.newssearch.view.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    private ArtigoService service;
    private MainView mainView;

    public MainPresenter(@NonNull MainView mainView, @NonNull ArtigoService service){
        this.service = service;
        this.mainView = mainView;
    }
    public void getArtigos(){

        service.getTopArtigos("the-new-york-times").enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                ApiResponse resposta = response.body();

                mainView.carregarArtigos(resposta.getArticles());
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                System.out.println("ERRO_CONEXÃO: "+t.getMessage());
                getArtigos();//Tentando pegar pela segunda vez
            }
        });
    }

}
