package com.nazmul_anik.book_store.service;

import com.nazmul_anik.book_store.entity.MyBooks;
import com.nazmul_anik.book_store.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {
    @Autowired
    MyBookRepository myBookRepository;
    public void saveMyBooks(MyBooks book){
        myBookRepository.save(book);
    }
    public List<MyBooks> getAllBooks(){
        return myBookRepository.findAll();
    }
    public void deleteById(int id){
        myBookRepository.deleteById(id);
    }
}
