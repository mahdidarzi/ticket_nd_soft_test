package com.example.demo.tickets.service.impl;

import com.example.demo.tickets.aspect.LogExecutionTime;
import com.example.demo.tickets.dto.request.CreateTicketRequest;
import com.example.demo.tickets.dto.response.TicketResponse;
import com.example.demo.tickets.entity.Ticket;
import com.example.demo.tickets.exception.TicketNotFoundException;
import com.example.demo.tickets.mapper.TicketMapper;
import com.example.demo.tickets.repository.TicketRepository;
import com.example.demo.tickets.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Override
    @LogExecutionTime
    @Transactional
    public TicketResponse createTicket(CreateTicketRequest request) {
        Ticket ticket = Ticket.builder()
                .title(request.title())
                .description(request.description())
                .build();

        Ticket savedTicket = ticketRepository.save(ticket);
        return ticketMapper.toResponse(savedTicket);
    }

    @Override
    @LogExecutionTime
    @Transactional(readOnly = true)
    public List<TicketResponse> getAllTickets() {
        return ticketRepository.findAll().stream()
                .map(ticketMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @LogExecutionTime
    @Transactional(readOnly = true)
    public TicketResponse getTicketById(UUID id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException(id));
        return ticketMapper.toResponse(ticket);
    }
}
