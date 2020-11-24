package br.com.biblioteca.bookuser.book;

import br.com.biblioteca.bookuser.book.services.DeleteBookServiceImpl;
import br.com.biblioteca.bookuser.exceptions.BookIntegrityException;
import br.com.biblioteca.bookuser.exceptions.BookNotDeletedException;
import br.com.biblioteca.bookuser.exceptions.BookNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static br.com.biblioteca.bookuser.book.builders.BookBuilder.createBook;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Tag("service")
@DisplayName("Valida funcionalidade do serviço responsável por deletar um book")
public class DeleteBookServiceTest {

    @Mock
    private BookRepository bookRepository;

    private DeleteBookServiceImpl deleteBook;

    @BeforeEach
    public void setUp() {
        this.deleteBook = new DeleteBookServiceImpl(bookRepository);
    }

    @Test
    @DisplayName("Deve deletar um livro")
    void shouldBookDeleted() {
        when(bookRepository.existsById(anyLong())).thenReturn(true);
        when(bookRepository.findById(anyLong())).thenReturn(Optional.of(createBook().id(1L).build()));
        deleteBook.delete(1L);
        verify(bookRepository).existsById(anyLong());
    }

    @Test
    @DisplayName("Deve lançar exceção quando o livro não puder ser excluido")
    void shouldThrowBookNotDeletedException() {
        lenient().when(bookRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(BookNotDeletedException.class, () -> this.deleteBook.delete(1L));
    }

    @Test
    @DisplayName("Deve lançar exceção quando o livro tiver sido emprestado")
    void shouldThrowBookIntegrityException() {
        when(bookRepository.existsById(anyLong())).thenReturn(true);
        when(bookRepository.findById(anyLong())).thenReturn(Optional.of(createBook().loanSpecificID("002").build()));
        assertThrows(BookIntegrityException.class, () -> this.deleteBook.delete(2L));
    }
}
