package com.example.aluno.plantozen20;

import com.orm.SugarRecord;

enum TipoTexto {
    TITULO, DESCRICAO
}

public class Texto extends SugarRecord<Texto> implements Anexo {

    TipoTexto tipo;
    String conteudo;

    public Texto () {}
    public Texto (TipoTexto tipo, String conteudo) {
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
