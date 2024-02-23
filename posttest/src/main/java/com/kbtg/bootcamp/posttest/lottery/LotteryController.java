package com.kbtg.bootcamp.posttest.lottery;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lotteries")
public class LotteryController {

    private final LotteryService lotteryService;

    private final LotteryRepository lotteryRepository;

    public LotteryController(LotteryService lotteryService, LotteryRepository lotteryRepository) {
        this.lotteryService = lotteryService;
        this.lotteryRepository = lotteryRepository;
    }

    @GetMapping("")
    public List<Lottery> getLotteryList() {
        return lotteryRepository.findAll();
    }

    @PostMapping("")
    public Lottery addLotteryTicket(@RequestBody LotteryRequestDto lotteryRequestDto) throws Exception {
        return lotteryService.addLotteryTicket(lotteryRequestDto);
    }

}
