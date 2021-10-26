package bg.softuni.books.service;

import bg.softuni.books.model.dto.BookDTO;
import java.util.List;
import java.util.Optional;

public interface BooksService {
  List<BookDTO> getAllBooks();

  Optional<BookDTO> getBookById(long id);

  void deleteBook(long id);

  long createBook(BookDTO bookDTO);
}
