package cherepoval.springFramework.BooksArchive.repositories;

import cherepoval.springFramework.BooksArchive.domain.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
