package com.kbtg.bootcamp.posttest.lottery;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "lottery")
public class Lottery {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ticketId;

    @Column(name = "ticket")
    private String ticket;

    @Column(name = "price")
    @Setter
    private Integer price;

    @Column(name = "amount")
    @Setter
    private Integer amount;

    public Lottery() {
    }

    public void setTicket(String ticket) {
    }

}
