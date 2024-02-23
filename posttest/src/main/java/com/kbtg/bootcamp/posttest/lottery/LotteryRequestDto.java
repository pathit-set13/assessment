package com.kbtg.bootcamp.posttest.lottery;

import lombok.Getter;
import lombok.Setter;

@Getter
public class LotteryRequestDto {

    @Setter
    private String ticket;
    private Integer price;
    private Integer amount;

    public LotteryRequestDto(){
    }

}
