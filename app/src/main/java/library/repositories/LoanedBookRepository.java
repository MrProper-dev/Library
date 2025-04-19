package library.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import library.entities.LoanedBook;

@Repository
public interface LoanedBookRepository extends JpaRepository<LoanedBook, Integer>{
    
    void deleteByBookId(int id);

}
