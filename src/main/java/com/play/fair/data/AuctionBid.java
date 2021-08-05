package com.play.fair.data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "auction_bid")
public class AuctionBid {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "auction_bid_id")
    private Long auctionBidId;

    @Column(name = "auction_id")
    private Long auctionId;

    @Column(name = "bid_price")
    private Double bidPrice;

    @Column(name = "bid_time")
    private LocalDateTime bidTime;

    @Column(name = "user_id")
    private String userId;


    public AuctionBid() {}

    public AuctionBid(Long auctionId, Double bidPrice, LocalDateTime bidTime, String userId) {
        this.auctionId = auctionId;
        this.bidPrice = bidPrice;
        this.bidTime = bidTime;
        this.userId = userId;
    }

    public Long getAuctionBidId() {
        return auctionBidId;
    }

    public void setAuctionBidId(Long auctionBidId) {
        this.auctionBidId = auctionBidId;
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

    public LocalDateTime getBidTime() {
        return bidTime;
    }

    public void setBidTime(LocalDateTime bidTime) {
        this.bidTime = bidTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuctionBid that = (AuctionBid) o;
        return Objects.equals(auctionBidId, that.auctionBidId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(auctionBidId);
    }


}
