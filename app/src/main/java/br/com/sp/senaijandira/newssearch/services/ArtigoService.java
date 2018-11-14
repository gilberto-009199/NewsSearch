package br.com.sp.senaijandira.newssearch.services;

import br.com.sp.senaijandira.newssearch.services.model.ApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 16254850 on 12/11/2018.
 */

public interface ArtigoService{

    String URL_BASE = "http://news-search-reverso.herokuapp.com/";

    @GET("/index.php?rota=top-headlines")
    Call<ApiResponse> getTopArtigos(@Query("sources") String indexNews);

    @GET("/index.php?rota=everything")
    Call<ApiResponse> getArtigos(@Query("sources") String indexNews);

}
