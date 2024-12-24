package com.natwest.library.api.controller;

import com.natwest.library.api.exception.InvalidBookAuthorException;
import com.natwest.library.api.exception.InvalidBookIdException;
import com.natwest.library.api.service.LibraryService;
import com.natwest.library.model.BookDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService bookService;

    @PostMapping("/book")
    public ResponseEntity<BookDetails> addBook(@RequestBody BookDetails book){
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDetails>> getBooks(){
        return new ResponseEntity<>(bookService.getBook(), HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookDetails> getBooksById(@PathVariable Long id){
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @GetMapping("/author-books/{author}")
    public ResponseEntity<List<BookDetails>> getBookByAuthor(@PathVariable String author){
        return new ResponseEntity<>(bookService.getBookByAuthor(author), HttpStatus.OK);
    }

    @GetMapping("/books/{name}")
    public ResponseEntity<List<BookDetails>> getBookByName(@PathVariable String name){
        return new ResponseEntity<>(bookService.getBookByName(name), HttpStatus.OK);
    }

    @GetMapping("/year-books/{publishYear}")
    public ResponseEntity<List<BookDetails>> getBookByName(@PathVariable Long publishYear){
        return new ResponseEntity<>(bookService.getBookByPublishYear(publishYear), HttpStatus.OK);
    }

    @PutMapping("/book/{id}/{no}")
    public ResponseEntity<BookDetails> takeBook(@PathVariable Long id, @PathVariable int no){
        return new ResponseEntity<>(bookService.takeBook(id, no), HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id){
        return new ResponseEntity<>(bookService.deleteBook(id), HttpStatus.OK);
    }

}
