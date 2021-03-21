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
    public void run(String... args) {

        while (true){System.out.println("Number of books: " + bookRepository.count());

        Scanner sc = new Scanner(System.in);
        String firstname = sc.nextLine();
        String lastname = sc.nextLine();
        String book = sc.nextLine();
        String isbn = sc.nextLine();

        Author author = new Author(firstname, lastname);
        Book titleBook = new Book(book, isbn);

        author.getBooks().add(titleBook);
        titleBook.getAuthors().add(author);

        authorRepository.save(author);
        bookRepository.save(titleBook);}



    }
}
