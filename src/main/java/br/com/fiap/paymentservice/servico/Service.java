package br.com.fiap.paymentservice.servico;

import br.com.fiap.paymentservice.dto.PaymentDTO;
import br.com.fiap.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class Service {

    @Autowired
    PaymentRepository paymentRepository;

    @RequestMapping(value="findById/{idTransacao}", method = RequestMethod.GET)
    public ResponseEntity<PaymentDTO> findById(@PathVariable(value="idTransacao") int idTransacao) {
        return new ResponseEntity<PaymentDTO>(paymentRepository.findById(idTransacao), HttpStatus.valueOf(200));
    }

    @RequestMapping(value="save", method = RequestMethod.POST)
    public ResponseEntity<PaymentDTO> save(@Valid @RequestBody PaymentDTO paymentDTO) {
        PaymentDTO savedTransaction = paymentRepository.save(paymentDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{idTransacao}")
                .buildAndExpand(savedTransaction.getIdTransacao()).toUri();
        return ResponseEntity.created(location).build();
    }

    @RequestMapping(value="update", method = RequestMethod.PUT)
    public ResponseEntity<PaymentDTO> update(@Valid @RequestBody PaymentDTO paymentDTO) {
        return new ResponseEntity<PaymentDTO>(paymentRepository.update(paymentDTO), HttpStatus.valueOf(200));
    }

    @RequestMapping(value="delete/{idTransacao}", method = RequestMethod.DELETE)
    public ResponseEntity<PaymentDTO> delete(@Valid @RequestBody int idTransacao) {
        return new ResponseEntity<PaymentDTO>(paymentRepository.delete(idTransacao), HttpStatus.valueOf(200));
    }

}
