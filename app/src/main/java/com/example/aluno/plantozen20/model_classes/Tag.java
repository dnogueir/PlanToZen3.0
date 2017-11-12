package com.example.aluno.plantozen20.model_classes;

import com.orm.SugarRecord;

public class Tag extends SugarRecord {

    public String nome;
    public String simbolo;
    public int cor;

    public Tag () {}
    public Tag (String nome, String simbolo, int cor) {
        this.nome = nome;
        this.simbolo = simbolo;
        this.cor = cor;
    }

}
