package com.example.demo.tickets.service;

import com.example.demo.tickets.dto.request.CreateTicketRequest;
import com.example.demo.tickets.dto.response.TicketResponse;

import java.util.List;
import java.util.UUID;

public interface TicketService {
    TicketResponse createTicket(CreateTicketRequest request);
    List<TicketResponse> getAllTickets();
    TicketResponse getTicketById(UUID id);
}
