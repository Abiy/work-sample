package com.play.fair;

import java.time.LocalDateTime;

public class AuctionBidModel {

    private Long auctionId;
    private Double bidPrice;
    private String userId;

    public AuctionBidModel(Long auctionId, Double bidPrice, String userId) {
        this.auctionId = auctionId;
        this.bidPrice = bidPrice;
        this.userId = userId;
    }

    public AuctionBidModel(Long auctionId) {
        this.auctionId = auctionId;
    }

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public Double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(Double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
