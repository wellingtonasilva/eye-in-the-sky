package br.com.wsilva.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FlightsBagLimitDTO {

    @JsonProperty("hand_width")
    private Integer handWidth;

    @JsonProperty("hand_height")
    private Integer handHeight;

    @JsonProperty("hand_length")
    private Integer handLength;

    @JsonProperty("hand_weight")
    private Integer handWeight;

    @JsonProperty("hold_width")
    private Integer holdWidth;

    @JsonProperty("hold_height")
    private Integer holdHeight;

    @JsonProperty("hold_length")
    private Integer holdLength;

    @JsonProperty("hold_dimensions_sum")
    private Integer holdDimensionSum;

    @JsonProperty("hold_weight")
    private Integer holdWeight;

    public FlightsBagLimitDTO() {
    }

    public Integer getHandWidth() {
        return handWidth;
    }

    public void setHandWidth(Integer handWidth) {
        this.handWidth = handWidth;
    }

    public Integer getHandHeight() {
        return handHeight;
    }

    public void setHandHeight(Integer handHeight) {
        this.handHeight = handHeight;
    }

    public Integer getHandLength() {
        return handLength;
    }

    public void setHandLength(Integer handLength) {
        this.handLength = handLength;
    }

    public Integer getHandWeight() {
        return handWeight;
    }

    public void setHandWeight(Integer handWeight) {
        this.handWeight = handWeight;
    }

    public Integer getHoldWidth() {
        return holdWidth;
    }

    public void setHoldWidth(Integer holdWidth) {
        this.holdWidth = holdWidth;
    }

    public Integer getHoldHeight() {
        return holdHeight;
    }

    public void setHoldHeight(Integer holdHeight) {
        this.holdHeight = holdHeight;
    }

    public Integer getHoldLength() {
        return holdLength;
    }

    public void setHoldLength(Integer holdLength) {
        this.holdLength = holdLength;
    }

    public Integer getHoldDimensionSum() {
        return holdDimensionSum;
    }

    public void setHoldDimensionSum(Integer holdDimensionSum) {
        this.holdDimensionSum = holdDimensionSum;
    }

    public Integer getHoldWeight() {
        return holdWeight;
    }

    public void setHoldWeight(Integer holdWeight) {
        this.holdWeight = holdWeight;
    }
}
