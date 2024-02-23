package com.kbtg.bootcamp.posttest.lottery;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryService {

    private final LotteryRepository lotteryRepository;

    public LotteryService(LotteryRepository lotteryRepository) {
        this.lotteryRepository = lotteryRepository;
    }

    public List<Lottery> getLotteryList() {
       return lotteryRepository.findAll();
    }

    public Lottery addLotteryTicket(LotteryRequestDto request) throws Exception{
        Lottery lottery = new Lottery();
        lottery.setTicket(request.getTicket());
        lottery.setPrice(request.getPrice());
        lottery.setAmount(request.getAmount());
        lotteryRepository.save(lottery);
        return lottery;
    }

}
