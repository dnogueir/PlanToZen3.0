package com.example.aluno.plantozen20;

import com.orm.SugarRecord;

import java.util.List;


enum Status {PENDENTE, FINALZIADA, ESCONDIDA}

public class Tarefa extends SugarRecord<Tarefa> {
    List<Anexo> anexos;
    List<Dependencia> dependencias;
    Status status;

    public Tarefa() {}

    public Tarefa(List<Anexo> anexos, List<Dependencia> dependencias) {
        this.anexos = anexos;
    }

}