package com.kh.homepage.board.repository;

import com.kh.homepage.board.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class CategoryRepositoryTest {

    @Autowired
    CategoryRepository categoryRepository;

    @Test
    void addSample() {
        String[] categories = {"공통", "운동", "등산", "게임", "낚시", "요리", "기타"};
        for (int i = 0; i < 7; i++) {
            categoryRepository.save(new Category((i+1)*10, categories[i]));
        }

    }
}