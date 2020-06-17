package br.com.wsilva.model.projection;

import org.springframework.beans.factory.annotation.Value;

public interface FlightsBagsPriceAverageProjection {

    @Value("#{target.fly_to}")
    String getFlyTo();

    @Value("#{target.hand}")
    Integer getHand();

    @Value("#{target.price}")
    Float getPrice();
}