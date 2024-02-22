package com.kbtg.bootcamp.posttest.lottery;

import lombok.Getter;

@Getter
public class LotteryRequest {

    private String ticket;
    private Integer price;
    private Integer amount;

    public LotteryRequest(){
    }

    public String getTicket() {
        return ticket;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getAmount() {
        return amount;
    }
}
