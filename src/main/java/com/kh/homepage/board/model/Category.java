package com.kh.homepage.board.model;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Category {

    @Id
    private int categoryNo;
    private String categoryName;
}
