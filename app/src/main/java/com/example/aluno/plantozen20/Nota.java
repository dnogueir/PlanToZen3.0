package com.example.aluno.plantozen20;

import com.orm.SugarRecord;

import java.util.List;

public class Nota extends SugarRecord<Nota> {
    List<Anexo> anexos;

    public Nota() {}

    public Nota(List<Anexo> anexos) {
        this.anexos = anexos;
    }

}

