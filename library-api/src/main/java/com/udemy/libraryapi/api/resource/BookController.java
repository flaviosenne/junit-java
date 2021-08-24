package com.udemy.libraryapi.api.resource;

import com.udemy.libraryapi.api.dto.BookDTO.BookDTO;
import com.udemy.libraryapi.domain.entity.Book;
import com.udemy.libraryapi.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService service;

    public BookController(BookService service){
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO create(@RequestBody BookDTO dto){
        Book entity = Book.builder()
                .author(dto.getAuthor())
                .isbn(dto.getIsbn())
                .title(dto.getTitle())
                .build();

        entity = service.save(entity);

        return BookDTO.builder()
                .id(entity.getId())
                .author(entity.getAuthor())
                .isbn(entity.getIsbn())
                .title(entity.getTitle())
                .build();

    }
}
