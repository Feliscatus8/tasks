package com.crud.tasks.trello.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BadgesDto {
    @JsonProperty("attachments")
    private AttachmentsByTypeDto attachments;
}
