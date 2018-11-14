package br.com.sp.senaijandira.newssearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import br.com.sp.senaijandira.newssearch.adapter.ArtigosAdapter;
import br.com.sp.senaijandira.newssearch.presenter.MainPresenter;
import br.com.sp.senaijandira.newssearch.services.ArtigoService;
import br.com.sp.senaijandira.newssearch.services.ServiceFactory;
import br.com.sp.senaijandira.newssearch.services.model.ApiResponse;
import br.com.sp.senaijandira.newssearch.services.model.Artigo;
import br.com.sp.senaijandira.newssearch.view.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MainView{

    private MainPresenter presenter;
    private ListView lstArtigos;
    private ArtigosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lstArtigos = findViewById(R.id.ltsArtigos);

        adapter = new ArtigosAdapter(this);

        lstArtigos.setAdapter(adapter);


        presenter = new MainPresenter(this,ServiceFactory.createArtigoService());
        presenter.getArtigos();

    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    public void carregarArtigos(List<Artigo> artigos) {
        adapter.addAll(artigos);
    }

    @Override
    public void clear() {

    }
}
