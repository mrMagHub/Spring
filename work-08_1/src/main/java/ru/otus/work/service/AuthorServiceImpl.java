package ru.otus.work.service;

import org.springframework.stereotype.Service;
import ru.otus.work.domain.Author;
import ru.otus.work.repositories.AuthorRepository;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author save(Author author) {
        if (author == null) {
            return null;
        }

        List<Author> authors = authorRepository.findByName(author.getName());

        if (authors.isEmpty()) {
            author.setId(null);
           return authorRepository.save(author);
        } else {
           return authors.get(0);
        }
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id).orElse(null);
    }
}
