package com.udemy.libraryapi.service;

import com.udemy.libraryapi.domain.entity.Book;
import com.udemy.libraryapi.exception.BusinessException;
import com.udemy.libraryapi.model.repository.BookRepository;
import com.udemy.libraryapi.service.impl.BookServiceImpl;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class BookServiceTest {

    BookService service;

    @MockBean
    BookRepository repository;

    @BeforeEach
    void setup(){
        this.service = new BookServiceImpl(repository);
    }

    Book createBook(){
        return Book.builder()
                .isbn("123")
                .author("Fulano")
                .title("As aventuras")
                .build();
    }
    @Test
    @DisplayName("Should save a book")
    void saveBookTest(){
        Book book =  createBook();
        when(repository.existsByIsbn(anyString())).thenReturn(false);

        when(repository.save(book)).thenReturn(Book.builder()
                .id(1l)
                .isbn("123")
                .title("As aventuras")
                .author("Fulano")
                .build());

        Book savedBook = service.save(book);

        assertThat(savedBook.getId()).isNotNull();
        assertThat(savedBook.getIsbn()).isEqualTo("123");
        assertThat(savedBook.getTitle()).isEqualTo("As aventuras");
        assertThat(savedBook.getAuthor()).isEqualTo("Fulano");
    }

    @Test
    @DisplayName("Should throw error exception when try save isbn duplicated")
    void ShouldNotSaveSaveBookWithDuplicatedISBN(){
        Book book = createBook();
        when(repository.existsByIsbn(anyString())).thenReturn(true);

        Throwable exception = Assertions.catchThrowable(() -> service.save(book));

        BDDAssertions.assertThat(exception)
                .isInstanceOf(BusinessException.class)
                .hasMessage("Isbn já cadastrado.");

        Mockito.verify(repository, Mockito.never()).save(book);
    }
}
