package com.example.aluno.plantozen20.adapter;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.content.DialogInterface;
import android.widget.EditText;


import com.example.aluno.plantozen20.R;
import com.example.aluno.plantozen20.model_classes.Tarefa;

/**
 * Created by tamir on 01/10/2017.
 */

public class newActivity extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.nova_atividade, null))
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        EditText tarefaNome_EditText = (EditText) getDialog().findViewById(R.id.TarefaNome_EditText);
                        EditText tarefaDescr_EditText = (EditText) getDialog().findViewById(R.id.TarefaDescr_EditText);
                        if (tarefaNome_EditText == null || tarefaDescr_EditText == null) {
                            return;
                        }

                        String tarefaNome = String.valueOf(tarefaNome_EditText.getText());
                        String tarefaDescr = String.valueOf(tarefaDescr_EditText.getText());
                        Tarefa tarefa = new Tarefa();
                        tarefa.save();
                        tarefa.addTituloDescr(tarefaNome, tarefaDescr);

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                })
                .setTitle("Nova Atividade");

        return builder.create();
    }
}