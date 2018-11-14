package br.com.sp.senaijandira.newssearch.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {

    public static ArtigoService createArtigoService(){
        Retrofit retrofit  = new Retrofit.Builder().baseUrl(ArtigoService.URL_BASE).addConverterFactory(GsonConverterFactory.create()).build();
        ArtigoService service = retrofit.create(ArtigoService.class);
        return service;
    }

}
