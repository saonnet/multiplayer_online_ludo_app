package com.saonnet.ludo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AddScoreDTO {

    @JsonProperty("user_id")
    private String userId;
}
