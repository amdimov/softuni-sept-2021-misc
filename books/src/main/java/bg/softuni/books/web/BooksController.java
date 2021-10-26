package bg.softuni.books.web;

import bg.softuni.books.model.dto.BookDTO;
import bg.softuni.books.service.BooksService;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/books")
public class BooksController {

  private final BooksService booksService;

  public BooksController(BooksService booksService) {
    this.booksService = booksService;
  }

  //called on http://localhost:8080/books
  @GetMapping
  public ResponseEntity<List<BookDTO>> getAllBooks() {
    List<BookDTO> allBooks = booksService.getAllBooks();

    return ResponseEntity.
        ok(allBooks);
  }

  @GetMapping("/{id}")
  public ResponseEntity<BookDTO> getBookById(@PathVariable("id") Long id) {
    Optional<BookDTO> book = booksService.getBookById(id);

    if (book.isEmpty()) {
      return ResponseEntity.
          notFound().
          build();
    } else {
      return ResponseEntity.
          ok(book.get());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<BookDTO> deleteBook(@PathVariable("id") Long id) {
    booksService.
        deleteBook(id);

    return ResponseEntity.
        noContent().
        build();
  }

  //My mistake :P
  @PostMapping()
  public ResponseEntity<BookDTO> create(
      @RequestBody BookDTO bookDTO,
      UriComponentsBuilder builder) {
    //http://localhost:8080/books/id
    long bookId = booksService.createBook(bookDTO);

    URI location = builder.path("/books/{id}").
        buildAndExpand(bookId).toUri();

    return ResponseEntity.
        created(location).
        build();

  }
}
