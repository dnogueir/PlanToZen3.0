package com.example.aluno.plantozen20.model_classes;

import com.orm.SugarRecord;

public class Anexo extends SugarRecord {

    public AnexoTipo tipo;
    public Texto innTexto;
    public Tag innTag;

    public AnexoPaiTipo paiTipo;
    public Nota pai;

    public Anexo() {}

    public Anexo(Texto inn) {
        allnull();
        this.tipo = AnexoTipo.TEXTO;
        this.innTexto = inn;
    }

    public Anexo(Tag inn) {
        allnull();
        this.tipo = AnexoTipo.TAG;
        this.innTag = inn;
    }

    public void setPai(Nota pai) {
        setPai(pai, AnexoPaiTipo.NOTA);
    }
    public void setPai(Tarefa pai) {
        setPai(pai, AnexoPaiTipo.TAREFA);
    }
    public void setPai(Nota pai, AnexoPaiTipo paitipo) {
        this.pai = pai;
        this.paiTipo = paitipo;
    }

    void allnull() {
        this.innTexto = null;
        this.innTag = null;
    }
}

