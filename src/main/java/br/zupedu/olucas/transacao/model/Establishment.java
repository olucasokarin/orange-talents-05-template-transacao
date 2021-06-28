package br.zupedu.olucas.transacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Establishment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    private String address;

    @Deprecated
    public Establishment() {
    }

    public Establishment(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }
}
