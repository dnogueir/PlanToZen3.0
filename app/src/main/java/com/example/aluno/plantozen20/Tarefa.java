package com.example.aluno.plantozen20;

import com.orm.SugarRecord;

import java.util.List;


public class Tarefa extends SugarRecord {
    List<Anexo> anexos;
    List<Dependencia> dependencias;
    TarefaStatus status;

    public Tarefa() {}

    public Tarefa(List<Anexo> anexos, List<Dependencia> dependencias) {
        this.anexos = anexos;
    }

}