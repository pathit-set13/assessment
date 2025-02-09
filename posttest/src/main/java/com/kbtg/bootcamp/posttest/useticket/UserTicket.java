package com.kbtg.bootcamp.posttest.useticket;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import com.kbtg.bootcamp.posttest.user.UserAccount;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Entity
@Table(name = "user_ticket")
public class UserTicket {

    @Setter
    @Column(name = "userId")
    private Integer userId;

    @Setter
    @Column(name = "ticketId")
    private String ticketId;

    @OneToMany(mappedBy = "user_account", cascade = CascadeType.ALL)
    private final List<UserAccount> userAccountList;

    @OneToMany(mappedBy = "lottery")
    private final List<Lottery> lotteries;

    public UserTicket(Integer userId, String ticketId, List<UserAccount> userAccountList, List<Lottery> lotteries) {
        this.userId = userId;
        this.ticketId = ticketId;
        this.userAccountList = userAccountList;
        this.lotteries = lotteries;
    }

    @Setter
    @Column(name = "amount")
    private Integer amount;

}
