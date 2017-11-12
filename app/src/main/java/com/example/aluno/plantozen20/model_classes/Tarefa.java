package com.example.aluno.plantozen20.model_classes;

import java.util.List;


public class Tarefa extends Nota {
    TarefaStatus status;

    public Tarefa() {
        this.thisTipo = AnexoPaiTipo.TAREFA;
    }

    public List<Anexo> getAnexos() {
        return super.getAnexos(String.valueOf(this.getId()));
    }

}


