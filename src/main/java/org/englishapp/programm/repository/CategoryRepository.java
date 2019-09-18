package org.englishapp.programm.repository;

import org.englishapp.programm.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
