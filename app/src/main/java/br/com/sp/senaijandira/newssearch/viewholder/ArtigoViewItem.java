package br.com.sp.senaijandira.newssearch.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import br.com.sp.senaijandira.newssearch.R;

public class ArtigoViewItem {

    public final TextView titulo;
    public final TextView autor;
    public final TextView descricao;
    public final ImageView imagem;

    public ArtigoViewItem(View v){
        titulo = v.findViewById(R.id.txtTitulo);
        autor = v.findViewById(R.id.txtAutor);
        descricao = v.findViewById(R.id.txtDescricao);
        imagem = v.findViewById(R.id.imgArtigo);
    }


}
