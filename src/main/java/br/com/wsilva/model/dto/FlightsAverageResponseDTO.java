package br.com.wsilva.model.dto;

import java.util.HashMap;
import java.util.Map;

public class FlightsAverageResponseDTO {

    private Map<String, FlightsAverageDTO> result = new HashMap<>();

    public FlightsAverageResponseDTO() {
    }

    public Map<String, FlightsAverageDTO> getResult() {
        return result;
    }

    public void setResult(Map<String, FlightsAverageDTO> result) {
        this.result = result;
    }
}
