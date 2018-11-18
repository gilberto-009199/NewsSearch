package br.com.sp.senaijandira.newssearch.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import br.com.sp.senaijandira.newssearch.R;
import br.com.sp.senaijandira.newssearch.services.model.Artigo;
import br.com.sp.senaijandira.newssearch.viewholder.ArtigoViewItem;

public class ArtigosAdapter extends ArrayAdapter<Artigo> {

    public ArtigosAdapter(Context ctx){
        super(ctx,0, new ArrayList<Artigo>());
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        ArtigoViewItem holder;


        if(convertView==null){
            v = LayoutInflater.from(getContext()).inflate(R.layout.artigo_layout_item,parent,false);
            holder = new ArtigoViewItem(v);
            v.setTag(holder);
        }else{
            v = convertView;
            holder =  (ArtigoViewItem) v.getTag();
        }

        holder.titulo.setText(getItem(position).getTitle());
        holder.autor.setText(getItem(position).getAuthor());
        holder.descricao.setText(getItem(position).getDescription());

        /*if(getItem(position).getUrlToImage()==null){
            LinearLayout imagem = v.findViewById(R.id.lnaImag);
            imagem.setVisibility(View.INVISIBLE);
            LinearLayout linear = v.findViewById(R.id.lnaDescribe);
            linear.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }*/
        Picasso.get().load(getItem(position).getUrlToImage()).resize(240,260).into(holder.imagem);


        return v;
    }
}
