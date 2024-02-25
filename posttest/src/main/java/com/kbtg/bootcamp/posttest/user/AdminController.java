package com.kbtg.bootcamp.posttest.user;

import com.kbtg.bootcamp.posttest.lottery.Lottery;
import com.kbtg.bootcamp.posttest.lottery.LotteryRequestDto;
import com.kbtg.bootcamp.posttest.lottery.LotteryService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final LotteryService lotteryService;

    public AdminController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    @GetMapping("")
    public String greetingAdmin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Welcome Admin.";
    }

    @PostMapping("/lotteries")
    public Lottery addLotteryTicket(@RequestBody LotteryRequestDto lotteryRequestDto) throws Exception {
        return lotteryService.addLotteryTicket(lotteryRequestDto);
    }

}
