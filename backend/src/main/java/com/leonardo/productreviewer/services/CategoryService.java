package com.leonardo.productreviewer.services;

import com.leonardo.productreviewer.exceptions.ObjectNotFoundException;
import com.leonardo.productreviewer.inputs.CategoryInput;
import com.leonardo.productreviewer.models.Category;
import com.leonardo.productreviewer.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public record CategoryService(CategoryRepository repository) {

    public Category create(CategoryInput input) {
        return repository.save(
                Category
                        .builder()
                        .description(input.description())
                        .build()
        );
    }

    public Category update(UUID id, CategoryInput input) {
        Category category = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Categoria de ID informado não pode ser encontrada."));
        category.setDescription(input.description());
        category = repository.save(category);
        return category;
    }

    public UUID delete(UUID id) {
        repository.delete(repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Categoria de ID informado não pode ser encontrada.")));
        return id;
    }

    public Category getById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Categoria de ID informado não pode ser encontrada."));
    }

    public List<Category> getAll() {
        return repository.findAll();
    }
}
