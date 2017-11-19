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

import com.example.aluno.plantozen20.adapter.MyAdapter;
import com.example.aluno.plantozen20.model_classes.Anexo;
import com.example.aluno.plantozen20.R;
import com.example.aluno.plantozen20.model_classes.Tag;
import com.example.aluno.plantozen20.model_classes.Tarefa;
import com.example.aluno.plantozen20.model_classes.Texto;
import com.example.aluno.plantozen20.adapter.taskAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aluno on 02/10/2017.
 */
public class AtividadesTMI extends Fragment {

    public taskAdapter adapter;

    public AtividadesTMI() {
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
        List<String> titulos = new ArrayList<String>();
        List<String> descrs = new ArrayList<String>();
        List<Tarefa> tarefas = Tarefa.listAll(Tarefa.class);
        if (tarefas != null) {
            for (Tarefa tarefa: tarefas) {
                Pair<List<Anexo>, Pair<String, String>> header = tarefa.getHeader();
                if (tarefa.anyTagEq(header.first, "TMI")) {
                    titulos.add(header.second.first);
                    descrs.add(header.second.second);
                }
            }
        }


        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        adapter = new taskAdapter(titulos, descrs);
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }

}
