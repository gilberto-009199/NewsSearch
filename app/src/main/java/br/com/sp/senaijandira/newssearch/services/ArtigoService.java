package br.com.sp.senaijandira.newssearch.services;

import br.com.sp.senaijandira.newssearch.services.model.ApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 16254850 on 12/11/2018.
 */

public interface ArtigoService{

    String URL_BASE = "http://newsapi.org/v2/";

    String KEY_ACCESS = "7f60f5dad321471caecb51c22c355513";

    @GET("/top-headlines")
    Call<ApiResponse> getTopArtigos(@Query("sources") String indexNews,@Query("apiKey") String key);

    @GET("/everything")
    Call<ApiResponse> getArtigos(@Query("sources") String indexNews,@Query("apiKey") String key);

}
