package com.example.demo.tickets.mapper;

import com.example.demo.tickets.dto.response.TicketResponse;
import com.example.demo.tickets.entity.Ticket;
import org.springframework.stereotype.Component;

/**
 * Mapper component responsible for converting between Entity and DTO layers.
 * This ensures separation of concerns and prevents leakage of database models to the API layer.
 */
@Component
public class TicketMapper {

    /**
     * Maps a Ticket entity to a TicketResponse DTO.
     *
     * @param ticket the source entity.
     * @return a populated TicketResponse DTO.
     */
    public TicketResponse toResponse(Ticket ticket) {
        return new TicketResponse(
                ticket.getId(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getStatus(),
                ticket.getCreatedAt(),
                ticket.getUpdatedAt()
        );
    }
}
