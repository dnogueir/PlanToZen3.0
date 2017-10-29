package com.example.aluno.plantozen20;

import com.orm.SugarRecord;

import java.util.List;

enum TipoDependencia {
    E, OU
}

public class Dependencia extends SugarRecord {

    TipoDependencia tipo;
    List<Tarefa> tarefas;

    public Dependencia () {}
    public Dependencia (TipoDependencia tipo, List<Tarefa> tarefas) {
        this.tipo = tipo;
        this.tarefas = tarefas;
    }

}
