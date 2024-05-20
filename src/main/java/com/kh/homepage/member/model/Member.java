package com.kh.homepage.member.model;

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
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mid")
    @SequenceGenerator(name="seq_mid", sequenceName = "SEQ_MID", allocationSize = 1)
    private int userNo;

    private String userId;
    private String userPwd;
    private String userName;
    private String email;
    private String birthday;
    private String gender;
    private String phone;
    private String address;
    private Date enrollDate;
    private Date modifyDate;
    private String status;
}
