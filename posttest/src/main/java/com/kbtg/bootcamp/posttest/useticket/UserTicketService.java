package com.kbtg.bootcamp.posttest.useticket;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTicketService {

    private final UserTicketRepository userTicketRepository;
    private final UserTicketRequestDto userTicketRequestDto;

    public UserTicketService(UserTicketRepository userTicketRepository, UserTicketRequestDto userTicketRequestDto) {
        this.userTicketRepository = userTicketRepository;
        this.userTicketRequestDto = userTicketRequestDto;
    }

    public List<UserTicket> userTicketList(Integer userId) {
        return userTicketRepository.findAll()
                .stream()
                .toList();
    }

    public String buyLottery(UserTicketRequestDto userTicketRequestDto) throws Exception {

        UserTicket userTicket = userTicketRepository.findById(Long.valueOf(userTicketRequestDto.getTicketId()))
                .orElseThrow(() -> new Exception("Ticket ID" + userTicketRequestDto.getTicketId() + "not found"));

        userTicket.setUserId(userTicket.getUserId());
        userTicketRepository.save(userTicket);
        return userTicket.getTicketId();
    }

    public String deleteLottery(UserTicketRequestDto userTicketRequestDto) throws Exception {
        UserTicket ticketDelete = userTicketRepository.findById(Long.valueOf(userTicketRequestDto.getTicketId()))
                .orElseThrow(() -> new Exception("Ticket ID" + userTicketRequestDto.getTicketId() + "not found"));

        userTicketRepository.delete(ticketDelete);
        return userTicketRequestDto.getTicket();
    }

}
