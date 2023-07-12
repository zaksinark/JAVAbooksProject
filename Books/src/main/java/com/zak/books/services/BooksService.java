package com.zak.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zak.books.models.Books;
import com.zak.books.repositories.BooksRepo;

@Service
public class BooksService {
	private final BooksRepo bookRepo;
	public BooksService(BooksRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	public Books getOne(Long id) {
		Optional<Books> book = bookRepo.findById(id);
		return book.isPresent() ? book.get() : null;
	}

	public List<Books> getAll() {
		return (List<Books>) bookRepo.findAll();
	}

	public Books create(Books dojo) {
		return bookRepo.save(dojo);
	}

	public Books update(Books dojo) {
		return bookRepo.save(dojo);
	}

	public void delete(Long id) {
		bookRepo.deleteById(id);
	}
}
