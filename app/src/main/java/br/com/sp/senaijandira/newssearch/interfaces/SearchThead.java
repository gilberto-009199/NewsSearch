package br.com.sp.senaijandira.newssearch.interfaces;

import br.com.sp.senaijandira.newssearch.services.model.Artigo;

public interface SearchThead extends Runnable{

    void resetSearch();

    void newSearch(String pesquisa);

    void getSearch(callbackFunction promise);
}
