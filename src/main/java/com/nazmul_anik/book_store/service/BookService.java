package com.nazmul_anik.book_store.service;

import com.nazmul_anik.book_store.entity.Book;
import com.nazmul_anik.book_store.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public void save(Book book){
        bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).get();
    }


    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }
}
