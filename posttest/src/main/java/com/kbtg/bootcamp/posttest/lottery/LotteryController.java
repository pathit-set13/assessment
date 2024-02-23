package com.kbtg.bootcamp.posttest.lottery;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lotteries")
public class LotteryController {

    private final LotteryService lotteryService;

    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    @GetMapping("")
    public List<Lottery> getLotteryList() {
        return this.lotteryService.getLotteryList();
    }

    @PostMapping("")
    public Lottery addLotteryTicket(@RequestBody LotteryRequestDto lotteryRequestDto) throws Exception {
        return lotteryService.addLotteryTicket(lotteryRequestDto);
    }

}
