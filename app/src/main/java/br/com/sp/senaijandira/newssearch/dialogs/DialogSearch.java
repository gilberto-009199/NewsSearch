package br.com.sp.senaijandira.newssearch.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import br.com.sp.senaijandira.newssearch.R;
import br.com.sp.senaijandira.newssearch.model.PortaisChecked;

public class DialogSearch extends Dialog {

    private EditText editTextNome;
    private LinearLayout listPortais;
    private Button btnSearch;
    public List<String> portaisSearch;

    public DialogSearch(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_search_layout);
        listPortais = findViewById(R.id.listPortais);
        btnSearch = findViewById(R.id.search_go_btn);
        portaisSearch = new ArrayList<String>();

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchTo(null);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        final ArrayList<PortaisChecked> portais = new ArrayList<>();
        PortaisChecked tmpPortal = new PortaisChecked(getContext());
        tmpPortal.setNome("Google Search");
        tmpPortal.setRepositorio("google-news-br");
        portais.add(tmpPortal);
        tmpPortal = new PortaisChecked(getContext());
        tmpPortal.setNome("Hacker-news");
        tmpPortal.setRepositorio("hacker-news");
        portais.add(tmpPortal);
        tmpPortal = new PortaisChecked(getContext());
        tmpPortal.setNome("BBC");
        tmpPortal.setRepositorio("bbc-news");
        portais.add(tmpPortal);
        tmpPortal = new PortaisChecked(getContext());
        tmpPortal.setNome("Bloomberg Business");
        tmpPortal.setRepositorio("bloomberg");
        portais.add(tmpPortal);
        tmpPortal = new PortaisChecked(getContext());
        tmpPortal.setNome("CNN Politoca");
        tmpPortal.setRepositorio("cnn");
        portais.add(tmpPortal);
        tmpPortal = new PortaisChecked(getContext());
        tmpPortal.setNome("Fox News");
        tmpPortal.setRepositorio("fox-news");
        tmpPortal = new PortaisChecked(getContext());
        tmpPortal.setNome("New Scientist");
        tmpPortal.setRepositorio("new-scientist");
        portais.add(tmpPortal);
        for (final PortaisChecked portal : portais){
            portal.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        portaisSearch.add(portal.getRepositorio());
                    }else{
                        portaisSearch.remove(portal.getRepositorio());
                    }
                }
            });
            listPortais.addView(portal);
        }
    }
    public void searchTo(View v){
        System.out.println(portaisSearch);
    }
}