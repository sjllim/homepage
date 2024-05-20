package com.kh.homepage.board.repository;

import com.kh.homepage.board.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
