package com.example.aluno.plantozen20.model_classes;

import com.orm.SugarRecord;

public class Texto extends SugarRecord {

    public TextoTipo tipo;
    public String conteudo;

    public Texto () {}
    public Texto (TextoTipo tipo, String conteudo) {
        this.tipo = tipo;
        this.conteudo = conteudo;
    }

    public boolean isTitulo() {
        switch (tipo) {
            case TITULO:
                return true;
            case DESCRICAO:
                return false;
        }
        return false;
    }

}
