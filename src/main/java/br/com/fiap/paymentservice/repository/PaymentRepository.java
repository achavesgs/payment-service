package br.com.fiap.paymentservice.repository;

import br.com.fiap.paymentservice.dto.PaymentDTO;

public interface PaymentRepository {

    public PaymentDTO findById(int idTransacao);
    public PaymentDTO save(PaymentDTO paymentDTO);
    public PaymentDTO update(PaymentDTO paymentDTO);
    public PaymentDTO delete(int idPagamento);

}
