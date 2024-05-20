package com.kh.homepage.board.service;

import com.kh.homepage.board.model.Board;
import com.kh.homepage.board.model.Category;
import com.kh.homepage.board.repository.BoardRepository;
import com.kh.homepage.board.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public BoardServiceImpl(BoardRepository boardRepository
                            , CategoryRepository categoryRepository) {
        this.boardRepository = boardRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<Board> selectBoardList(int currPage) {
        return boardRepository.findAll(PageRequest.of(currPage, 10, Sort.by(Sort.Direction.DESC, "boardNo")));
    }

    @Override
    public ArrayList<Category> selectCategoryList() {
        return (ArrayList<Category>)categoryRepository.findAll();
    }
}
