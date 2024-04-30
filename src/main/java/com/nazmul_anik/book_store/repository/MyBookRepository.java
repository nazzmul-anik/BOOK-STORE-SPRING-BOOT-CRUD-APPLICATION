package com.nazmul_anik.book_store.repository;

import com.nazmul_anik.book_store.entity.MyBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookRepository extends JpaRepository<MyBooks, Integer> {
}
