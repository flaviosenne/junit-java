package com.udemy.libraryapi.model.repository;

import com.udemy.libraryapi.domain.entity.Book;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    BookRepository repository;

    @Test
    @DisplayName("Should return true when exist book in DB with ISBN provider")
    void ShouldReturnTrueWhenExistBookInDB(){
        // cenario
        String isbn = "123";
        Book book = Book.builder().author("Fulano").title("As Aventuras").isbn(isbn).build();
        entityManager.persist(book);

        // execução
        boolean exist = repository.existsByIsbn(isbn);

        // verificação
        BDDAssertions.assertThat(exist).isTrue();
    }

    @Test
    @DisplayName("Should return false when do not exist book in DB with ISBN provider")
    void ShouldReturnFalseWhenDoesExistBookInDB(){
        // cenario
        String isbn = "123";

        // execução
        boolean exist = repository.existsByIsbn(isbn);

        // verificação
        BDDAssertions.assertThat(exist).isFalse();
    }
}
