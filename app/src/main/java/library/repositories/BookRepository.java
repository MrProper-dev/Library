package library.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import library.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

    @Modifying
    @Query("update Book b set b.loanStatus=true where b.id = :id")
    void setStatusTrue(@Param("id") int id);

    @Modifying
    @Query("update Book b set b.loanStatus=false where b.id = :id")
    void setStatusFalse(@Param("id") int id);

    @Query("select b.loanStatus from Book b where b.id = :id")
    Boolean getStatus(@Param("id") int id);

    @Query("select b from Book b where lower(b.title) like lower(concat(:oneOf, '%'))" +
           "or lower(b.author.fullName) like lower(concat(:oneOf, '%'))")
    Slice<Book> findByTitleAndAuthorName(@Param("oneOf") String oneOf, Pageable pageable);

    @Query("select b.image from Book b where b.id=:id")
    String getImage(@Param("id") int id);

}

