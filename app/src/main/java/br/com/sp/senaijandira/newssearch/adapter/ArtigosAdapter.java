package br.com.sp.senaijandira.newssearch.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import br.com.sp.senaijandira.newssearch.R;
import br.com.sp.senaijandira.newssearch.services.model.Artigo;
import br.com.sp.senaijandira.newssearch.viewholder.LivroViewItem;

public class ArtigosAdapter extends ArrayAdapter<Artigo> {

    public ArtigosAdapter(Context ctx){
        super(ctx,0, new ArrayList<Artigo>());
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        LivroViewItem holder;

        if(v==null){
            v = LayoutInflater.from(getContext()).inflate(R.layout.artigo_layout_item,parent,false);
        }

        holder = new LivroViewItem(v);

        holder.titulo.setText(getItem(position).getTitle());
        holder.autor.setText(getItem(position).getAuthor());

        System.out.println("Pequei um artigo de titulo "+getItem(position).getTitle());
        return v;
    }
}
