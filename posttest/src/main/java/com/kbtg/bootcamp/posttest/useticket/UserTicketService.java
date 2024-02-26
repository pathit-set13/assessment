package com.kbtg.bootcamp.posttest.useticket;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTicketService {

    private final UserTicketRepository userTicketRepository;

    public UserTicketService(UserTicketRepository userTicketRepository) {
        this.userTicketRepository = userTicketRepository;
    }

    public List<UserTicket> userTicketList() {
        return userTicketRepository.findAll()
                .stream()
                .toList();
    }
    
}
