package br.com.fiap.paymentservice.repository;

import br.com.fiap.paymentservice.dto.PaymentDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepositoryImpl implements PaymentRepository {

    private List<PaymentDTO> paymentList = new ArrayList<>();
    @Override
    public PaymentDTO findById(int idPayment) {
        for (PaymentDTO payment : paymentList) {
            if (payment.getIdTransacao() == idPayment)
                return payment;
        }

        return null;
    }

    @Override
    public PaymentDTO save(PaymentDTO paymentDTO) {
        for (int i = 0; i < paymentList.size(); i++) {
            if (paymentList.get(i).getIdTransacao() == paymentDTO.getIdTransacao()) {
                return null;
            }
        }
        paymentList.add(paymentDTO);
        paymentDTO.setIdTransacao(Integer.valueOf(paymentList.size()));
        return paymentDTO;
    }

    @Override
    public PaymentDTO update(PaymentDTO paymentDTO) {
        for (int i = 0; i < paymentList.size(); i++) {
            if (paymentList.get(i).getIdTransacao() == paymentDTO.getIdTransacao()) {
                paymentList.set(i, paymentDTO);
                return paymentDTO;
            }
        }
        return null;
    }

    public String delete(int idPagamento) {
        for (int i = 0; i < paymentList.size(); i++) {
            if (paymentList.get(i).getIdTransacao() == idPagamento) {
                paymentList.remove(i);
                return "Excluído com sucesso.";
            }
        }
        return null;
    }
}
