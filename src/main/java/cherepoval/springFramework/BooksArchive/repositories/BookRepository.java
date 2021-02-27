package cherepoval.springFramework.BooksArchive.repositories;

import cherepoval.springFramework.BooksArchive.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
