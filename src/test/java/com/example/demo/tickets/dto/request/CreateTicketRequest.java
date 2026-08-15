package com.example.demo.tickets.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateTicketRequest(

        @NotBlank(message = "عنوان تیکت الزامی است")
        @Size(max = 150, message = "عنوان تیکت نباید بیشتر از 150 کاراکتر باشد")
        String title,

        @NotBlank(message = "توضیحات تیکت الزامی است")
        @Size(max = 2000, message = "توضیحات تیکت نباید بیشتر از 2000 کاراکتر باشد")
        String description
) {
}
