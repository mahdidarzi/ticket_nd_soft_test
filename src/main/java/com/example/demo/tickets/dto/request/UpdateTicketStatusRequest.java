package com.example.demo.tickets.dto.request;

import com.example.demo.tickets.entity.enums.TicketStatus;
import jakarta.validation.constraints.NotNull;

public record UpdateTicketStatusRequest(
        @NotNull(message = "Status is required")
        TicketStatus status
) {
}
