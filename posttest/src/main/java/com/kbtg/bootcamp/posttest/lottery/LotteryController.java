package com.kbtg.bootcamp.posttest.lottery;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lotteries")
public class LotteryController {

    private final LotteryService lotteryService;

    public LotteryController(LotteryService lotteryService, LotteryRepository lotteryRepository) {
        this.lotteryService = lotteryService;
    }

    @GetMapping("")
    public List<LotteryResponse> getLotteryList() {
        return this.lotteryService.getLotteryList();
    }

}
