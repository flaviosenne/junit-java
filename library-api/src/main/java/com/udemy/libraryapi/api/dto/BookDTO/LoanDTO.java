package com.udemy.libraryapi.api.dto.BookDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoanDTO {
    private String isbn;
    private String customer;
}
