package br.zupedu.olucas.transacao.consumer;

import br.zupedu.olucas.transacao.model.Card;
import br.zupedu.olucas.transacao.model.Transaction;
import br.zupedu.olucas.transacao.repository.CardRepository;
import br.zupedu.olucas.transacao.repository.TransactionRepository;
import br.zupedu.olucas.transacao.requestAPI.TransactionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TransactionListener {

    TransactionRepository transactionRepository;
    CardRepository cardRepository;

    @Autowired
    public TransactionListener(TransactionRepository transactionRepository, CardRepository cardRepository) {
        this.transactionRepository = transactionRepository;
        this.cardRepository = cardRepository;
    }

    @Bean
    JsonMessageConverter jsonMessageConverter() {
        return new JsonMessageConverter();
    }

    @KafkaListener(topics = "${variable.kafka.consumer.topic.name.transactions}")
    public void listen(TransactionEvent transactionEvent) {
        Transaction transaction = transactionEvent.convertRequestToEntity();

        Optional<Card> optionalCard = cardRepository.findByExternalId(transaction.getCard().getExternalId());
        Card card;
        if(optionalCard.isEmpty())
            card = cardRepository.save(transaction.getCard());
        else
            card = optionalCard.get();

        transaction.setCard(card);
        transactionRepository.save(transaction);
    }
}
