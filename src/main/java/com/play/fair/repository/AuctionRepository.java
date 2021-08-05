package com.play.fair.repository;


import com.play.fair.data.Auction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuctionRepository extends CrudRepository<Auction, Long> {

    List<Auction> findByProductId(Long productId);

    Auction findByAuctionId(long auctionId);

    @Override
    List<Auction> findAll();
}
