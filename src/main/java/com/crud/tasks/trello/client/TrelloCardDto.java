package com.crud.tasks.trello.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrelloCardDto {
    private String name;

    private String description;

    private String pos;

    private String listId;
}
