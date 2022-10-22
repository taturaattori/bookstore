package hh.swd20.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;
import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;
import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository brepository, CategoryRepository crepository, UserRepository urepository) {
		return (args) -> {
			log.info("save some sample categories");
			log.info("save a couple of books");
			Category category1 = new Category("Fiction");
			crepository.save(category1);
			Category category2 = new Category("Poetry");
			crepository.save(category2);
			
			log.info("fetch all categories");
			for (Category category : crepository.findAll()) {
				log.info(category.toString());
			}
			
			brepository.save(new Book("Catcher in the rye", "J.D. Salinger", 1951, null, 0, category1));
			brepository.save(new Book("Lord of the Flies", "William Golding", 1954, null, 0, category1));
			
			User user1 = new User("user1", "$2a$10$yt.c4X2XqTFXNDK7b7vRpeGuK5RRHSGgET5eoTeXt3NLt4Zf3/dbe", "user@mail.com", "USER");
			User user2 = new User("admin1", "$2a$10$XcojoSPjpx.bNgtLPFAideEvXfNSwncgxlqocReHb5/gxuIUYZBSa", "admin@mail.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}
		};
	}
}
