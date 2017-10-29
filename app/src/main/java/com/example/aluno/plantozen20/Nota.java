package com.example.aluno.plantozen20;

import android.util.Log;

import com.orm.SugarRecord;
import com.orm.util.NamingHelper;

import java.util.List;

public class Nota extends SugarRecord {

    public Nota() {}

    public void addAnexo(Anexo anexo) {
        anexo.setPai(this);
    }

    public void addAnexos(List<Anexo> anexos) {
        for (Anexo anexo: anexos) {
            addAnexo(anexo);
        }
    }

    public void addTituloDescr(String titulo_s, String descr_s) {
        Log.i("adicionando novo titulo e descr. Titulo: <" + titulo_s,
                ">; Descr: <" + descr_s + ">");
        Texto outNome = new Texto(TextoTipo.TITULO, titulo_s);
        Texto outDescr = new Texto(TextoTipo.DESCRICAO, descr_s);
        Anexo nome = new Anexo(outNome);
        Anexo descr = new Anexo(outDescr);
        this.addAnexo(nome);
        this.addAnexo(descr);
        //
        outNome.save();
        outDescr.save();
        nome.save();
        descr.save();
    }

    public List<Anexo> getAnexos() {
        String helper = NamingHelper.toSQLNameDefault("paiNota");
        String subs = String.valueOf(this.getId());
        Log.i("Helper: <" + helper + ">;", "subs: <" + subs + ">;");
        return Anexo.find(Anexo.class, "pai_nota" + " = ?", subs);
    }

}

