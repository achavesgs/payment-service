package br.com.fiap.paymentservice.dto;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class PaymentDTO {
	
	@ApiModelProperty(notes = "The database generated Order ID")
    private int idTransacao;
	
	@ApiModelProperty(notes = "Credit card Number")
    private int nroCartao;
	
	@ApiModelProperty(notes = "Validity Date")
    private String validadeCartao;
	
	@ApiModelProperty(notes = "Amount")
    private BigDecimal valorCompra;
	
	@ApiModelProperty(notes = "Credit Card Banner")
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
