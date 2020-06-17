package br.com.wsilva.model.projection;

import org.springframework.beans.factory.annotation.Value;

public interface FlightsAverageProjection {

	@Value("#{target.fly_to}")
	String getFlyTo();

	@Value("#{target.city_to}")
	String getCityTo();

	@Value("#{target.price}")
	Float getPrice();
}