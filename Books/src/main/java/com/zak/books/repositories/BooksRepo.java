package com.zak.books.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zak.books.models.Books;

@Repository
public interface BooksRepo extends CrudRepository<Books,Long>{
	List<Books> findAll();
}
