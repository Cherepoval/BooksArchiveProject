package cherepoval.springFramework.BooksArchive.repositories;

import cherepoval.springFramework.BooksArchive.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
}
