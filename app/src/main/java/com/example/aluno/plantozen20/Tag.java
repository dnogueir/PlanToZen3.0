package com.example.aluno.plantozen20;

import com.orm.SugarRecord;

public class Tag extends SugarRecord<Tag> implements Anexo {

    String nome;
    String simbolo;
    int cor;

    public Tag () {}
    public Tag (String nome, String simbolo, int cor) {
        this.nome = nome;
        this.simbolo = simbolo;
        this.cor = cor;
    }

}
