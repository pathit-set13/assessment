package com.kbtg.bootcamp.posttest.user;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import com.kbtg.bootcamp.posttest.lottery.LotteryRequestDto;
import com.kbtg.bootcamp.posttest.lottery.LotteryService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final LotteryService lotteryService;

    public UserController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
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

//    @PostMapping("/users/:userId/lotteries/:ticketId")
//    public


}
