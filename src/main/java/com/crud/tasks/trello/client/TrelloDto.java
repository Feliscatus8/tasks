package com.crud.tasks.trello.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TrelloDto {
    @JsonProperty("board")
    private int board;

    @JsonProperty("card")
    private int card;
}
