package com.kh.homepage.board.controller;

import com.kh.homepage.board.model.Board;
import com.kh.homepage.board.model.Category;
import com.kh.homepage.board.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Controller
public class BoardController {

    private final BoardService bService;

    @Autowired
    public BoardController(BoardService bService) {
        this.bService = bService;
    }

    @RequestMapping("/list.bo")
    public String viewBoardList(int cpage
                                , Model model) {
        Page<Board> selectList = bService.selectBoardList(cpage);

        log.info("board size : {}", selectList.getSize());
        log.info("total size : {}", selectList.getTotalElements());
        log.info("current page : {}", selectList.getNumber());
        log.info("total page : {}", selectList.getTotalPages());


        List<Board> list = selectList.getContent();

        for (Board b : list) {
            log.info("{}", b);
        }

        model.addAttribute("list", list);
        return "board/boardListView";
    }

    @RequestMapping("/enroll.bo")
    public String viewEnrollForm(Model model) {
        ArrayList<Category> list = bService.selectCategoryList();
        model.addAttribute("category", list);
        return "board/enrollForm";
    }
}
