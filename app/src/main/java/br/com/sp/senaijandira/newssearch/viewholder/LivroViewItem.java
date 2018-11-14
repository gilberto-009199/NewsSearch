package br.com.sp.senaijandira.newssearch.viewholder;

import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import br.com.sp.senaijandira.newssearch.R;

public class LivroViewItem {

    public  final TextView titulo;
    public final TextView autor;

    public LivroViewItem(View v){
        titulo = v.findViewById(R.id.txtTitulo);
        autor = v.findViewById(R.id.txtAutor);
    }


}
