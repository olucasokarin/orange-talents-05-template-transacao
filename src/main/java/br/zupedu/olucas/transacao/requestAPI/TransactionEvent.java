package br.zupedu.olucas.transacao.requestAPI;

import br.zupedu.olucas.transacao.model.Card;
import br.zupedu.olucas.transacao.model.Establishment;
import br.zupedu.olucas.transacao.model.Transaction;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TransactionEvent {
    private String id;
    private BigDecimal valor;
    private Estabelecimento estabelecimento;
    private Cartao cartao;
    private LocalDateTime efetivadaEm;

    @JsonCreator
    public TransactionEvent(@JsonProperty("id") String id,
                            @JsonProperty("valor") BigDecimal valor,
                            @JsonProperty("estabelecimento") Estabelecimento estabelecimento,
                            @JsonProperty("cartao") Cartao cartao,
                            @JsonProperty("efetivadaEm") LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public Transaction convertRequestToEntity() {
        Establishment establishment = estabelecimento.convertRequestToEntity();
        Card card = cartao.convertRequestToEntity();

        return new Transaction(UUID.fromString(this.id), this.valor, establishment, card, this.efetivadaEm);
    }
}

class Estabelecimento {
    private String nome;
    private String cidade;
    private String endereco;

    @JsonCreator
    public Estabelecimento(@JsonProperty("nome") String nome,
                           @JsonProperty("cidade") String cidade,
                           @JsonProperty("endereco") String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }
    Establishment convertRequestToEntity() {
        return new Establishment(this.nome, this.cidade, this.endereco);
    }
}

class Cartao {
    private String id;
    private String email;

    @JsonCreator
    public Cartao(@JsonProperty("id") String id,
                  @JsonProperty("email") String email) {
        this.id = id;
        this.email = email;
    }

    Card convertRequestToEntity() {
        return new Card(UUID.fromString(this.id), this.email);
    }
}
