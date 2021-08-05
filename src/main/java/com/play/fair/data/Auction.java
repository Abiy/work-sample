package com.play.fair.data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "auction")
public class Auction {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "auction_id")
    private Long auctionId;

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "winner_price")
    private Double winnerPrice;

    @Column(name = "version")
    @Version
    private Long version;

    @Column(name = "floor_price")
    private Double floorPrice;

    public Auction() {}

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getWinnerPrice() {
        return winnerPrice;
    }

    public void setWinnerPrice(Double winnerPrice) {
        this.winnerPrice = winnerPrice;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auction auction = (Auction) o;
        return Objects.equals(auctionId, auction.auctionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(auctionId);
    }

    @Override
    public String toString() {
        return "Auction{" +
                "auctionId=" + auctionId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", productId='" + productId + '\'' +
                ", winnerPrice=" + winnerPrice +
                ", version=" + version +
                '}';
    }


    public void setFloorPrice(Double floorPrice) {
        this.floorPrice = floorPrice;
    }

    public Double getFloorPrice() {
        return floorPrice;
    }
}
