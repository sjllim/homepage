package com.kh.homepage.board.service;

import com.kh.homepage.board.model.Board;
import com.kh.homepage.board.model.Category;
import org.springframework.data.domain.Page;

import java.util.ArrayList;


public interface BoardService {
    Page<Board> selectBoardList(int currPage);

    ArrayList<Category> selectCategoryList();
}
