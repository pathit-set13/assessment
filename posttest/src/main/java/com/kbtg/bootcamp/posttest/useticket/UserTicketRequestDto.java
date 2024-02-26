package com.kbtg.bootcamp.posttest.useticket;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserTicketRequestDto {

    private Integer userId;
    private Integer ticketId;
    private String ticket;

    public UserTicketRequestDto(){

    }

}
