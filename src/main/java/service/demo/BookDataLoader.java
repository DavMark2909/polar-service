package service.demo;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import service.domain.Book;
import service.domain.BookRepository;

@Component
@Profile("testdata")
public class BookDataLoader {

    private final BookRepository repository;

    public BookDataLoader(BookRepository repository) {
        this.repository = repository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData(){
        var book1 = new Book("1234567891", "Suka blyat", "Polish Kurwa", 9.90);
        var book2 = new Book("1234567892", "GOAT", "Mark Davletov", 29.09);
        repository.save(book1);
        repository.save(book2);
    }
}
