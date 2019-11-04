package com.quickcard.domain.entidades;

import com.quickcard.domain.interfaces.entidade.ICartaoMemoria;
import org.dozer.Mapping;

public class CartaoMemoria extends EntidadeBasica implements ICartaoMemoria {

    public CartaoMemoria() { super(); }

    @Mapping("frenteCartao")
    private String frenteCartao;
    @Mapping("versoCartao")
    private String versoCartao;

    @Mapping("dataVisualizacao")
    private String dataVisualizacao;
    @Mapping("dataVisualizacao")
    private String timeVisualizacao;

    @Mapping("acertoFacil")
    private int acertoFacil;
    @Mapping("acertoMedio")
    private int acertoMedio;
    private int acertoDificil = -1;

    @Override
    public String getFrenteCartao() {
        return this.frenteCartao;
    }

    @Override
    public String getVersoCartao()  {
        return this.versoCartao;
    }

    @Override
    public String getDataVisualizacao() {
        return this.dataVisualizacao;
    }

    @Override
    public String getTimeVisualizacao() {
        return this.timeVisualizacao;
    }

    @Override
    public int getAcertoFacil() {
        return this.acertoFacil;
    }

    @Override
    public int getAcertoMedio() {
        return this.acertoMedio;
    }

    @Override
    public int getAcertoDificil() {
        return this.acertoDificil;
    }

    @Override
    public void setFrenteCartao(String frenteCartao) {
        this.frenteCartao = frenteCartao;
    }

    @Override
    public void setVersoCartao(String versoCartao) {
        this.versoCartao = versoCartao;
    }

    @Override
    public void setDataVisualizacao(String dataVisualizacao) {
        this.dataVisualizacao = dataVisualizacao;
    }

    @Override
    public void setTimeVisualizacao(String timeVisualizacao) {
        this.timeVisualizacao = timeVisualizacao;
    }

    @Override
    public void setAcertoFacil(int acertoFacil) {
        this.acertoFacil = acertoFacil;
    }

    @Override
    public void setAcertoMedio(int acertoMedio) {
        this.acertoMedio = acertoMedio;
    }
}
