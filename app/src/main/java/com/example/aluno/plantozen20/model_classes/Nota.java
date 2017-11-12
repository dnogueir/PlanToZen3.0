package com.example.aluno.plantozen20.model_classes;

        import android.util.Log;

        import com.orm.SugarRecord;

        import java.util.List;

public class Nota extends SugarRecord {

    public AnexoPaiTipo thisTipo;

    public Nota() {
        this.thisTipo = AnexoPaiTipo.NOTA;
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
        Texto outNome = new Texto(TextoTipo.TITULO, titulo_s);
        Texto outDescr = new Texto(TextoTipo.DESCRICAO, descr_s);
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

}

