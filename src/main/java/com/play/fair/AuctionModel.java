package com.play.fair;

import java.time.LocalDateTime;

public class AuctionModel {

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long productId;
    private Double floorPrice;

    public AuctionModel(LocalDateTime startTime, LocalDateTime endTime, Long productId, Double floorPrice) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.productId = productId;
        this.floorPrice = floorPrice;
    }

    public AuctionModel() {
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

    public Double getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(Double floorPrice) {
        this.floorPrice = floorPrice;
    }
}
