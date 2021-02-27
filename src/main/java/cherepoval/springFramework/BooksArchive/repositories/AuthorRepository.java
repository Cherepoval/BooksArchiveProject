package cherepoval.springFramework.BooksArchive.repositories;

import cherepoval.springFramework.BooksArchive.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository <Author, Long>{
}
