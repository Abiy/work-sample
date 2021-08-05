package com.play.fair.repository;


import com.play.fair.data.AuctionBid;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuctionBidRepository extends CrudRepository<AuctionBid, Long> {

    List<AuctionBid> findByAuctionId(Long auctionId);

    AuctionBid findByAuctionBidId(long auctionBidId);

    @Override
    List<AuctionBid> findAll();
}
