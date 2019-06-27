package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public DevBootstrap(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //Pub1
        Publisher pub1 = new Publisher("Pub1", "Fahe Street 1 2 3");
        Book book1 = new Book();
        book1.getPublisher().add(pub1);


        //Pub2
        Publisher pub2 = new Publisher("Pub2", "martín Machío 8");
        Book book2 = new Book();
        book2.getPublisher().add(pub2);
    }
}
