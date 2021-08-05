package com.play.fair.controller;


import com.play.fair.AuctionModel;
import com.play.fair.data.Auction;
import com.play.fair.data.Product;
import com.play.fair.repository.AuctionRepository;
import com.play.fair.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AuctionController {

    private final AuctionRepository auctionRepository;

    @Autowired
    AuctionController(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @GetMapping("/auctions")
    public List<Auction> products() {
        return auctionRepository.findAll();
    }

    @GetMapping("/auctions/{auctionId}")
    public Auction productsByName(@PathVariable Long auctionId) {
        return auctionRepository.findByAuctionId(auctionId);
    }

    @GetMapping("/products/{productId}/auctions")
    public List<Auction> productsById(@PathVariable Long productId) {
        return auctionRepository.findByProductId(productId);
    }

    @PostMapping("/auctions")
    public Auction createAuction(@RequestBody AuctionModel auctionModel) {
        Auction auction = new Auction();
        auction.setStartTime(auctionModel.getStartTime());
        auction.setEndTime(auctionModel.getEndTime());
        auction.setProductId(auctionModel.getProductId());
        auction.setFloorPrice(auctionModel.getFloorPrice());

        Auction auctionResult = auctionRepository.save(auction);
        return auctionResult;

    }
}
