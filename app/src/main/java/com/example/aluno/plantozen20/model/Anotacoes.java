package com.example.aluno.plantozen20.model;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aluno.plantozen20.model_classes.Anexo;
import com.example.aluno.plantozen20.model_classes.Nota;
import com.example.aluno.plantozen20.R;
import com.example.aluno.plantozen20.model_classes.Texto;
import com.example.aluno.plantozen20.adapter.MyAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aluno on 02/10/2017.
 */
public class Anotacoes extends Fragment {

    public MyAdapter adapter;

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
        List<String> strings1 = new ArrayList<String>();
        List<String> strings2 = new ArrayList<String>();
        List<Nota> notas = Nota.listAll(Nota.class);
        if (notas != null) {
            for (Nota nota: notas) {
                Pair<List<Anexo>, Pair<String, String>> header = nota.getHeader();
                strings1.add(header.second.first);
                strings2.add(header.second.second);
            }
        }

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(false);
        adapter = new MyAdapter();
        adapter.setData(strings1, strings2);
        //MyAdapter adapter = new MyAdapter(new String[]{"Anotacão 1", "Anotacão 2", "Anotacão 3", "Anotacão 4"},
        //        new String[]{"06/10/2017", "04/10/2017", "01/10/2017", "27/09/2017"});
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }

}
