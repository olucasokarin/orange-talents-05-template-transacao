package br.zupedu.olucas.transacao.repository;

import br.zupedu.olucas.transacao.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("select t from Transaction t where t.card.externalId = :id")
    Page<Transaction> findTransactionWithLastTenTransaction(UUID id, Pageable pageable);
}
