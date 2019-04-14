package br.com.fiap.paymentservice.servico;

import br.com.fiap.paymentservice.dto.PaymentDTO;
import br.com.fiap.paymentservice.repository.PaymentRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@Api(value = "Payment", description = "Payment Service REST API")
public class Service {

    @Autowired
    PaymentRepository paymentRepository;

    @ApiOperation(httpMethod = "GET", value = "Get Payment By Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns Payment and Success Status", response = PaymentDTO.class)
    })
    @RequestMapping(value="findById/{idTransacao}", method = RequestMethod.GET)
    public ResponseEntity<PaymentDTO> findById(@PathVariable(value="idTransacao") int idTransacao) {
        return new ResponseEntity<PaymentDTO>(paymentRepository.findById(idTransacao), HttpStatus.valueOf(200));
    }

    @ApiOperation(httpMethod = "POST", value = "Post Payment")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Returns generated Payment and Created Status", response = PaymentDTO.class)
    })
    @RequestMapping(value="save", method = RequestMethod.POST)
    public ResponseEntity<PaymentDTO> save(@Valid @RequestBody PaymentDTO paymentDTO) {
        PaymentDTO savedTransaction = paymentRepository.save(paymentDTO);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{idTransacao}")
                .buildAndExpand(savedTransaction.getIdTransacao()).toUri();
        return ResponseEntity.created(location).build();
    }

    @ApiOperation(httpMethod = "PATCH", value = "Update Payment")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Returns success Status")
    })
    @RequestMapping(value="update", method = RequestMethod.PUT)
    public ResponseEntity<PaymentDTO> update(@Valid @RequestBody PaymentDTO paymentDTO) {
        return new ResponseEntity<PaymentDTO>(paymentRepository.update(paymentDTO), HttpStatus.valueOf(200));
    }

    @ApiOperation(httpMethod = "DELETE", value = "Delete Payment")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retuns Success Status")
    })
    @RequestMapping(value="delete/{idTransacao}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable(value="idTransacao") int idTransacao) {
        return new ResponseEntity<String>(paymentRepository.delete(idTransacao), HttpStatus.valueOf(200));
    }

}
