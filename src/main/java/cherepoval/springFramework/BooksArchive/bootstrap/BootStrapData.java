package cherepoval.springFramework.BooksArchive.bootstrap;

import cherepoval.springFramework.BooksArchive.domain.Author;
import cherepoval.springFramework.BooksArchive.domain.Book;
import cherepoval.springFramework.BooksArchive.repositories.AuthorRepository;
import cherepoval.springFramework.BooksArchive.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Number of books: " + bookRepository.count());

        Scanner sc = new Scanner(System.in);
        String fn = sc.nextLine();
        String ln = sc.nextLine();
        String bk = sc.nextLine();
        String in = sc.nextLine();

        Author a = new Author(fn, ln);
        Book b = new Book(bk, in);

        a.getBooks().add(b);
        b.getAuthors().add(a);

        authorRepository.save(a);
        bookRepository.save(b);

        run();

    }
}
