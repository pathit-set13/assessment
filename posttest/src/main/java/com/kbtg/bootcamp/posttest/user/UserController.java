package com.kbtg.bootcamp.posttest.user;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import com.kbtg.bootcamp.posttest.lottery.LotteryRequestDto;
import com.kbtg.bootcamp.posttest.lottery.LotteryService;
import com.kbtg.bootcamp.posttest.useticket.UserTicket;
import com.kbtg.bootcamp.posttest.useticket.UserTicketRequestDto;
import com.kbtg.bootcamp.posttest.useticket.UserTicketService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final LotteryService lotteryService;
    private final UserTicketService userTicketService;

    public UserController(LotteryService lotteryService, UserTicketService userTicketService) {
        this.lotteryService = lotteryService;
        this.userTicketService = userTicketService;
    }

    @PreAuthorize("hasRole('ADMIN)")
    @GetMapping("/admin")
    public String greetingAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Welcome Admin.";
    }

    @PostMapping("/admin/lotteries")
    public Lottery addLotteryTicket(@RequestBody LotteryRequestDto lotteryRequestDto) throws Exception {
        return lotteryService.addLotteryTicket(lotteryRequestDto);
    }

    @PreAuthorize("hasRole('MEMBER') or hasRole('ADMIN)")
    @GetMapping("/users")
    public String greetingUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Welcome Member.";
    }

    @GetMapping("/users/{userId}/lotteries")
    public List<UserTicket> userTicketList(@PathVariable Integer userId) {
        return this.userTicketService.userTicketList(userId);
    }

    @PostMapping("/users/{userId}/lotteries/{ticketId}")
    public String buyLottery(
            @PathVariable Integer userId, Integer ticketId,
            @RequestBody UserTicketRequestDto userTicketRequestDto) throws Exception {
        return this.userTicketService.buyLottery(userTicketRequestDto);
    }

    @DeleteMapping("/users/{userId}/lotteries/{ticketId}")
    public String deleteLottery(
            @PathVariable Integer userId, Integer ticketId,
            @RequestBody UserTicketRequestDto userTicketRequestDto) throws Exception {
        return this.userTicketService.deleteLottery(userTicketRequestDto);
    }


}
