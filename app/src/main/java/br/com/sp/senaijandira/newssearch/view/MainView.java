package br.com.sp.senaijandira.newssearch.view;

import java.util.List;

import br.com.sp.senaijandira.newssearch.services.model.Artigo;

public interface MainView {

    void carregarArtigos(List<Artigo> artigos);

    void clear();

}
