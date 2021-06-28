package br.zupedu.olucas.transacao.repository;

import br.zupedu.olucas.transacao.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, Long> {
    Optional<Card> findByExternalId(UUID externalId);
}
