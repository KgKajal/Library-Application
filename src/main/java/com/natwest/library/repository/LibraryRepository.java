package com.natwest.library.repository;

import com.natwest.library.model.BookDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<BookDetails, Long> {

    @Query("SELECT book FROM BookDetails book WHERE book.authorName = :author")
    List<BookDetails> findBookByAuthor(@Param("author") String author);

    @Query("SELECT book FROM BookDetails book WHERE book.bookName = :bookName")
    List<BookDetails> findBookByName(@Param("bookName") String bookName);

    @Query("SELECT book FROM BookDetails book WHERE book.publishYear = :publishYear")
    List<BookDetails> findBookByPublishYear(@Param("publishYear") Long publishYear);
}
