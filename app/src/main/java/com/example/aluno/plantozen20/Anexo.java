package com.example.aluno.plantozen20;

import android.util.Log;

import com.google.gson.Gson;
import com.orm.SugarRecord;

import java.util.List;

public class Anexo extends SugarRecord {

    public AnexoTipo tipo;
    public Texto innTexto;
    public Tag innTag;

    public AnexoPaiTipo paiTipo;
    public Nota paiNota;
    public Tarefa paiTarefa;

    public Anexo() {}

    public Anexo(Texto obj) {
        allnull();
        this.tipo = AnexoTipo.TEXTO;
        this.innTexto = obj;
    }

    public Anexo(Tag obj) {
        allnull();
        this.tipo = AnexoTipo.TAG;
        this.innTag = obj;
    }

    public void setPai(Nota pai) {
        this.paiNota = pai;
        this.paiTipo = AnexoPaiTipo.NOTA;
        Gson gson = new Gson();
        Log.i("Pai desta nota settado: ", gson.toJson(this));
        Log.i("Pai id: ", gson.toJson(paiNota.getId()));
    }
    public void setPai(Tarefa pai) {
        this.paiTarefa = pai;
        this.paiTipo = AnexoPaiTipo.TAREFA;
    }

    void allnull() {
        this.innTexto = null;
        this.innTag = null;
        this.paiNota = null;
        this.paiTarefa = null;
    }
}

