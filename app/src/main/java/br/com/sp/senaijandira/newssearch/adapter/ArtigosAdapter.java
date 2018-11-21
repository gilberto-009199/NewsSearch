package br.com.sp.senaijandira.newssearch.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import br.com.sp.senaijandira.newssearch.R;
import br.com.sp.senaijandira.newssearch.services.model.Artigo;
import br.com.sp.senaijandira.newssearch.viewholder.ArtigoViewItem;

public class ArtigosAdapter extends ArrayAdapter<Artigo> {

    private ProgressBar progresso;
    private Integer espaço;

    public ArtigosAdapter(Context ctx,final ProgressBar progresso){
        super(ctx,0, new ArrayList<Artigo>());
        this.progresso = progresso;
        this.espaço = progresso.getMax();
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;
        ArtigoViewItem holder;
        Artigo artigoTmp = getItem(position);

        if(convertView==null){
            v = LayoutInflater.from(getContext()).inflate(R.layout.artigo_layout_item,parent,false);
            holder = new ArtigoViewItem(v);
            v.setTag(holder);
        }else{
            v = convertView;
            holder =  (ArtigoViewItem) v.getTag();
        }

        holder.titulo.setText(artigoTmp.getTitle());
        holder.autor.setText(artigoTmp.getAuthor());
        holder.descricao.setText(artigoTmp.getDescription());

        if(artigoTmp.getUrlToImage().length()<1){
            System.out.println("Noticia sem image!!");
        }
        System.out.println("Url: "+artigoTmp.getUrlToImage());

        Picasso.get().load(artigoTmp.getUrlToImage().toString().replace("https://","http://")).resize(240,260).into(holder.imagem);


        int progressoPart = (espaço/this.getCount())*1;
        progresso.setProgress(progresso.getProgress()+progressoPart);
        return v;
    }
}
