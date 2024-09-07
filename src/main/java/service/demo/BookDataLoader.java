package service.demo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import service.domain.Book;
import service.domain.BookRepository;

import java.util.List;

@Component
@Profile("testdata")
public class BookDataLoader {

    private final BookRepository repository;

    public BookDataLoader(BookRepository repository) {
        this.repository = repository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        repository.deleteAll();
        var book1 = Book.of("1234567891", "Northern Lights", "Lyra Silverstar", 9.90, "Superman");
        var book2 = Book.of("1234567892", "Polar Journey", "Iorek Polarson", 12.90, "Batman");
        repository.saveAll(List.of(book1, book2));
    }
}
