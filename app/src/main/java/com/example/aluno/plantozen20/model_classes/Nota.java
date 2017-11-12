package com.example.aluno.plantozen20.model_classes;

import android.util.Log;
import android.util.Pair;

import com.google.gson.Gson;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Nota extends SugarRecord {

    public Anexo.PaiTipo thisTipo;

    public Nota() {
        this.thisTipo = Anexo.PaiTipo.NOTA;
    }

    public void addAnexo(Anexo anexo) {
        anexo.setPai(this, thisTipo);
        anexo.save();
    }

    public void addAnexos(List<Anexo> anexos) {
        for (Anexo anexo: anexos) {
            addAnexo(anexo);
        }
    }

    public void addTituloDescr(String titulo_s, String descr_s) {
        Log.i("adicionando novo titulo e descr. Titulo: <" + titulo_s,
                ">; Descr: <" + descr_s + ">");
        Texto outNome = new Texto(Texto.Tipo.TITULO, titulo_s);
        Texto outDescr = new Texto(Texto.Tipo.DESCRICAO, descr_s);
        outNome.save();
        outDescr.save();
        this.addAnexo(new Anexo(outNome));
        this.addAnexo(new Anexo(outDescr));
        //
    }

    public List<Anexo> getAnexos() {
        return getAnexos(String.valueOf(this.getId()));
    }

    public List<Anexo> getAnexos(String id) {
        return Anexo.find(Anexo.class, "pai = ? and pai_tipo = ?", id, String.valueOf(thisTipo));
    }

    public Pair<List<Anexo>, Pair<String, String>> getHeader () {
        return getHeader(String.valueOf(this.getId()));
    }
    public Pair<List<Anexo>, Pair<String, String>> getHeader (String id) {
        List<Anexo> anexos = getAnexos(id);
        List<Anexo> outros = new ArrayList<Anexo>();
        String titulo = null;
        String descr = null;
        if (anexos != null) {
            for (Anexo anexo: anexos) {
                if (anexo.tipo == Anexo.Tipo.TEXTO && anexo.innTexto.tipo == Texto.Tipo.TITULO) {
                    titulo = anexo.innTexto.conteudo;
                } else if (anexo.tipo == Anexo.Tipo.TEXTO && anexo.innTexto.tipo == Texto.Tipo.DESCRICAO) {
                    descr = anexo.innTexto.conteudo;
                } else {
                    outros.add(anexo);
                }
            }
        }
        return Pair.create(outros, Pair.create(titulo, descr));
    }
    public boolean anyTagEq(List<Anexo> anexos, String tag) {
        for (Anexo anexo: anexos) {
            Log.i("Anexo::", String.valueOf(new Gson().toJson(anexo)));
            if (anexo.tipo == Anexo.Tipo.TAG && anexo.innTag.nome.equals(tag)) {
                return true;
            }
        }
        return false;
    }


}

