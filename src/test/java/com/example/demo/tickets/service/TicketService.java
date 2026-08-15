package com.example.demo.tickets.service;

import com.example.demo.tickets.dto.request.CreateTicketRequest;
import com.example.demo.tickets.dto.response.TicketResponse;
import com.example.demo.tickets.entity.enums.TicketStatus;

import java.util.List;
import java.util.UUID;

public interface TicketService {

    TicketResponse createTicket(CreateTicketRequest request);

    List<TicketResponse> getAllTickets();

    TicketResponse getTicketById(UUID id);

    TicketResponse updateTicketStatus(UUID id, TicketStatus newStatus);
}
