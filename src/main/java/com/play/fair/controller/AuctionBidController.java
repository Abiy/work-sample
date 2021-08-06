package com.play.fair.controller;


import com.play.fair.AuctionBidModel;
import com.play.fair.data.Auction;
import com.play.fair.data.AuctionBid;
import com.play.fair.repository.AuctionBidRepository;
import com.play.fair.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class AuctionBidController {

    private final AuctionBidRepository bidRepository;
    private final AuctionRepository auctionRepository;

    @Autowired
    AuctionBidController(AuctionBidRepository auctionBidRepository, AuctionRepository auctionRepository) {
        this.bidRepository = auctionBidRepository;
        this.auctionRepository = auctionRepository;
    }

    @GetMapping("/bids")
    public List<AuctionBid> products() {
        return bidRepository.findAll();
    }

    @GetMapping("/auctions/{auctionId}/bids")
    public List<AuctionBid> productsByName(@PathVariable Long auctionId) {
        return bidRepository.findByAuctionId(auctionId);
    }

    @PostMapping("/auctions/{auctionId}/bids")
    public AuctionBid createAuctionBid(@RequestBody AuctionBidModel model, @PathVariable Long auctionId) {
        AuctionBid auctionBid = new AuctionBid(auctionId, model.getBidPrice(),
                LocalDateTime.now(), model.getUserId());
        //validate auction is open
        //validate bid is above floor price
        //Compute Winner and return Auction and Bid Details
        Auction auction = auctionRepository.findByAuctionId(auctionId);
        if (Objects.isNull(auction) || auction.getFloorPrice() > model.getBidPrice()){
            throw new RuntimeException("Invalid Auction or Bid Price");
        }
        LocalDateTime now = LocalDateTime.now();
        if(now.isAfter(auction.getEndTime()) || now.isBefore(auction.getStartTime())){
            throw new RuntimeException("Auction is not currently open.");
        }
        AuctionBid auctionResult = bidRepository.save(auctionBid);
        List<AuctionBid> bids = bidRepository.findByAuctionId(auctionId);
        Optional<AuctionBid> winner = bids.stream()
                .sorted(Comparator.comparingDouble(AuctionBid::getBidPrice).reversed())
                .findFirst();
        if (winner.isPresent()){
            auction.setWinnerPrice(winner.get().getBidPrice());
        }
        auctionRepository.save(auction);
        return auctionResult;

    }
}
