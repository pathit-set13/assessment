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
    private String ticket;
    @Setter
    private Integer price;
    @Setter
    private Integer amount;

    public Lottery() {
    }

    public void setTicket(String ticket) {
    }

}
