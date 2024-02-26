package com.kbtg.bootcamp.posttest.lottery;

import org.apache.coyote.BadRequestException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        Lottery lotteryTicket = lotteryRepository.findByTicket(request.getTicket());

        if (lotteryTicket != null) {

            lotteryTicket.setAmount(lotteryTicket.getAmount() + request.getAmount());
            lotteryRepository.save(lotteryTicket);
            return lotteryTicket;

        } else {

            Lottery lottery = new Lottery();
            lottery.setTicket(request.getTicket());
            lottery.setPrice(request.getPrice());
            lottery.setAmount(request.getAmount());
            lotteryRepository.save(lottery);
            return lottery;

        }
    }

    public Lottery getLotteryTicketByID(Integer ticketId) throws ChangeSetPersister.NotFoundException {
        return lotteryRepository.findById(String.valueOf(ticketId))
                .stream()
                .filter(lottery -> lottery.getTicketId().equals(ticketId))
                .findFirst()
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Lottery editLotteryById(Integer ticketId, LotteryRequestDto requestDto) throws BadRequestException {
        Optional<Lottery> optionalLottery = lotteryRepository.findById(String.valueOf(Long.valueOf(ticketId)));
        if (optionalLottery.isEmpty()) {
            throw new BadRequestException("Invalid ticket id");
        } else {
            Lottery lottery = optionalLottery.get();
            lottery.setTicket(requestDto.getTicket());
            lotteryRepository.save(lottery);
            return lottery;
        }
    }

    public void deleteLotteryById(Integer ticketId) {
        lotteryRepository.deleteById(String.valueOf(ticketId));
    }
}
