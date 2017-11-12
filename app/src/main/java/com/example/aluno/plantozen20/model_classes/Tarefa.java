package com.example.aluno.plantozen20.model_classes;

import java.util.List;


public class Tarefa extends Nota {
    public enum TarefaStatus {PENDENTE, FINALZIADA, ESCONDIDA}

    public Tarefa() {
        this.thisTipo = Anexo.PaiTipo.TAREFA;
    }

    public List<Anexo> getAnexos() {
        return super.getAnexos(String.valueOf(this.getId()));
    }

}


