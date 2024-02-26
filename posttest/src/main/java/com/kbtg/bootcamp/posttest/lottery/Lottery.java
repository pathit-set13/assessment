package com.kbtg.bootcamp.posttest.lottery;

import com.kbtg.bootcamp.posttest.useticket.UserTicket;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "lottery")
public class Lottery {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticketId")
    private UserTicket userTicketId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket")
    private UserTicket userTicket;

}
