package br.com.fiap.paymentservice.dto;

import java.math.BigDecimal;

public class PaymentDTO {
    private int idTransacao;
    private int nroCartao;
    private String validadeCartao;
    private BigDecimal valorCompra;
    private String bandeira;

    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public int getNroCartao() {
        return nroCartao;
    }

    public void setNroCartao(int nroCartao) {
        this.nroCartao = nroCartao;
    }

    public String getValidadeCartao() {
        return validadeCartao;
    }

    public void setValidadeCartao(String validadeCartao) {
        this.validadeCartao = validadeCartao;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }
}
