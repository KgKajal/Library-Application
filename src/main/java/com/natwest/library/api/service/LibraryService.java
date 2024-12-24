package com.natwest.library.api.service;

import com.natwest.library.api.exception.BookOutOfStockException;
import com.natwest.library.api.exception.InvalidBookAuthorException;
import com.natwest.library.api.exception.InvalidBookIdException;
import com.natwest.library.model.BookDetails;
import com.natwest.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository bookRepository;

    public BookDetails saveBook(BookDetails book){
        return bookRepository.save(book);
    }

    public List<BookDetails> getBook(){
        return bookRepository.findAll();
    }

    public BookDetails getBookById(Long bookId){
        Optional<BookDetails> book = bookRepository.findById(bookId);
        if (book.isPresent()){
            return book.get();
        }
        throw new InvalidBookIdException("Book id "+bookId+" is not present in our library");
    }

    public List<BookDetails> getBookByAuthor(String author){
        List<BookDetails> books = bookRepository.findBookByAuthor(author);
        if (books.isEmpty()){
            throw new InvalidBookAuthorException(author+"'s books not available in our library");
        }
        return books;
    }

    public List<BookDetails> getBookByName(String bookName){
        List<BookDetails> books = bookRepository.findBookByName(bookName);

        if (books.isEmpty()){
            throw new InvalidBookAuthorException(bookName+" books not available in our library");
        }
        return books;
    }

    public List<BookDetails> getBookByPublishYear(Long publishYear){
        List<BookDetails> books = bookRepository.findBookByPublishYear(publishYear);

        if (books.isEmpty()){
            throw new InvalidBookAuthorException(publishYear+", this publish year of books are not available in our library");
        }
        return books;
    }

    public BookDetails takeBook(Long id, int no){
        BookDetails book = getBookById(id);
        int quantity = book.getQuantity();

        if (quantity<no || quantity==0){
            throw new BookOutOfStockException("Apology! we don't have "+no+" copies of books \nWe have only "+quantity+" copies of this book");
        }

        book.setQuantity(quantity-no);
        saveBook(book);
        return book;
    }

    public String deleteBook(Long id){
        BookDetails book = getBookById(id);
        bookRepository.deleteById(id);
        return "Book deleted successfully";
    }
}
