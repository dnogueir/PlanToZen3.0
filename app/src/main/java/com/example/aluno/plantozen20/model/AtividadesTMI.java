package com.example.aluno.plantozen20.model;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aluno.plantozen20.R;
import com.example.aluno.plantozen20.adapter.taskAdapter;

/**
 * Created by Aluno on 02/10/2017.
 */
public class AtividadesTMI extends Fragment {

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
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_blank, container, false);

        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.rv_recycler_view);
        rv.setHasFixedSize(true);
        taskAdapter adapter = new taskAdapter(new String[]{"Banho no dog", "Limpar cozinha", "Correr"},
                new String[]{"12/10/2017", "12/10/2017", "12/10/2017"});
        rv.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return rootView;
    }

}
