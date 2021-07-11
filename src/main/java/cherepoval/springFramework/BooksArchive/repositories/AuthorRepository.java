package cherepoval.springFramework.BooksArchive.repositories;

import cherepoval.springFramework.BooksArchive.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
