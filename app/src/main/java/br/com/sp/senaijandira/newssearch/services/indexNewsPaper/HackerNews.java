package br.com.sp.senaijandira.newssearch.services.indexNewsPaper;

import br.com.sp.senaijandira.newssearch.services.model.ApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 16254850 on 12/11/2018.
 */

public interface HackerNews {

    @GET("/top-headlines?sources=hacker-news&apiKey=7f60f5dad321471caecb51c22c355513")
    Call<ApiResponse> getTopArtigos();

    @GET("/everything?sources=hacker-news&apiKey=7f60f5dad321471caecb51c22c355513")
    Call<ApiResponse> getArtigos();
}
