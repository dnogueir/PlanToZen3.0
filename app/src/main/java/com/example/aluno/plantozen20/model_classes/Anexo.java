package com.example.aluno.plantozen20.model_classes;

import com.orm.SugarRecord;

public class Anexo extends SugarRecord {
    public enum Tipo {
        TEXTO, TAG
    }
    public enum PaiTipo {
        NOTA, TAREFA
    }

    public Tipo tipo;
    public Texto innTexto;
    public Tag innTag;

    public PaiTipo paiTipo;
    public Nota pai;

    public Anexo() {}

    public Anexo(Texto inn) {
        allnull();
        this.tipo = Tipo.TEXTO;
        this.innTexto = inn;
    }

    public Anexo(Tag inn) {
        allnull();
        this.tipo = Tipo.TAG;
        this.innTag = inn;
    }

    public void setPai(Nota pai) {
        setPai(pai, PaiTipo.NOTA);
    }
    public void setPai(Tarefa pai) {
        setPai(pai, PaiTipo.TAREFA);
    }
    public void setPai(Nota pai, PaiTipo paitipo) {
        this.pai = pai;
        this.paiTipo = paitipo;
    }

    void allnull() {
        this.innTexto = null;
        this.innTag = null;
    }
}

