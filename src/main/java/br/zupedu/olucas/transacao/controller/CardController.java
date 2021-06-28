package br.zupedu.olucas.transacao.controller;

import br.zupedu.olucas.transacao.model.Transaction;
import br.zupedu.olucas.transacao.repository.TransactionRepository;
import br.zupedu.olucas.transacao.response.TransactionResponse;
import javassist.runtime.Desc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transactions")
public class CardController {

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCards(@PathVariable("id") UUID id) {
        Page<Transaction> transactions = transactionRepository.findTransactionWithLastTenTransaction(id,
                PageRequest.of(0, 10, Sort.Direction.DESC, "createdAt"));

        if (transactions.isEmpty())
            return new ResponseEntity(Map.of("message", "Card not found"), HttpStatus.NOT_FOUND);

        List<TransactionResponse> transactionResponses = transactions.stream()
                .map(TransactionResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(transactionResponses);
    }
}
