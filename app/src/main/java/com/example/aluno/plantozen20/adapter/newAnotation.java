package com.example.aluno.plantozen20.adapter;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Pair;
import android.view.LayoutInflater;
import android.content.DialogInterface;
import android.widget.EditText;


import com.example.aluno.plantozen20.activity.MainActivity;
import com.example.aluno.plantozen20.model_classes.Nota;
import com.example.aluno.plantozen20.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tamir on 01/10/2017.
 */

public class newAnotation extends DialogFragment {
    MainActivity rootRef;

    public void rootRef(MainActivity rootRef) {
        this.rootRef = rootRef;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.nova_anotacao, null))
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        EditText notaNome_EditText = (EditText) getDialog().findViewById(R.id.NotaNome_EditText);
                        EditText notaDescr_EditText = (EditText) getDialog().findViewById(R.id.NotaDescr_EditText);
                        if (notaNome_EditText == null || notaDescr_EditText == null) {
                            return;
                        }
                        String notaNome = String.valueOf(notaNome_EditText.getText());
                        String notaDescr = String.valueOf(notaDescr_EditText.getText());
                        Nota nota = new Nota();
                        nota.save();
                        nota.addTituloDescr(notaNome, notaDescr);

                        MyAdapter adapter = rootRef.aba_anotacoes.adapter;
                        adapter.pushData(notaNome, notaDescr);
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                })
                .setTitle("Nova Anotação");

        return builder.create();
    }
}

