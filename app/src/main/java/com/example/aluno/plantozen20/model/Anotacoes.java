package com.example.aluno.plantozen20.model;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aluno.plantozen20.model_classes.Anexo;
import com.example.aluno.plantozen20.model_classes.AnexoTipo;
import com.example.aluno.plantozen20.model_classes.Nota;
import com.example.aluno.plantozen20.R;
import com.example.aluno.plantozen20.model_classes.TextoTipo;
import com.example.aluno.plantozen20.adapter.MyAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aluno on 02/10/2017.
 */
public class Anotacoes extends Fragment {

    public Anotacoes() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Pega as informações do BD, e acaba montando uma array de strings
        Log.i("Antes de tudo!", "Antes de todo ~~~~~~~~~~");
        List<String> strings1 = new ArrayList<String>();
        List<String> strings2 = new ArrayList<String>();
        List<Nota> notas = Nota.listAll(Nota.class);
        Gson gson = new Gson(); // debug
        if (notas != null) {
            for (Nota nota: notas) {
                Log.i("Nova nota!", "~~~~~~~~~~~~~~~~");
                // procura por um anexo de texto de título e descrição
                String titulo = null;
                String descr = null;
                List<Anexo> anexos = nota.getAnexos();
                if (anexos != null) {
                    for (Anexo anexo: anexos) {
                        Log.i("Anexo:", gson.toJson(anexo));
                        if (anexo.tipo == AnexoTipo.TEXTO && anexo.innTexto.tipo == TextoTipo.TITULO) {
                            titulo = anexo.innTexto.conteudo;
                        } else if (anexo.tipo == AnexoTipo.TEXTO && anexo.innTexto.tipo == TextoTipo.DESCRICAO) {
                            descr = anexo.innTexto.conteudo;
                        }
                    }
                }
                strings1.add(titulo);
                strings2.add(descr);
                Log.i("Titulo: <" + titulo, ">; Descr: <" + descr + ">");
            }
        }
        String[] strings1_arr = strings1.toArray(new String[strings1.size()]);
        String[] strings2_arr = strings2.toArray(new String[strings2.size()]);

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        MyAdapter adapter = new MyAdapter(strings1_arr, strings2_arr);
        //MyAdapter adapter = new MyAdapter(new String[]{"Anotacão 1", "Anotacão 2", "Anotacão 3", "Anotacão 4"},
        //        new String[]{"06/10/2017", "04/10/2017", "01/10/2017", "27/09/2017"});
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }

}
