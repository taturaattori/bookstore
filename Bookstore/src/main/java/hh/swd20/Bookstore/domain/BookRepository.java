package hh.swd20.Bookstore.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{

	Optional<Book> findById(Long id);
	
}
