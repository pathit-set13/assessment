package com.kbtg.bootcamp.posttest.lottery;

import lombok.Getter;

@Getter
public class LotteryRequest {

    private String ticket;
    private Integer price;
    private Integer amount;

    public LotteryRequest(){
    }



}
