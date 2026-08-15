package com.example.demo.tickets.dto.response;

import com.example.demo.tickets.entity.enums.TicketStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record TicketResponse(

        UUID id,
        String title,
        String description,
        TicketStatus status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
