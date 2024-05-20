package com.kh.homepage.board.model;

import com.kh.homepage.member.model.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_bid")
    @SequenceGenerator(name="seq_bid", sequenceName = "SEQ_BID", allocationSize = 1)
    private int boardNo;
    private String boardTitle;
    private String boardContent;
    private int count;
    private Date createDate;
    private String status;


    @ManyToOne
    @JoinColumn(name = "board_writer")
    private Member member;
}
