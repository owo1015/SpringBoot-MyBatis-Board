package org.example.board.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardVO {
    private int id;
    private String title;
    private String content;
    private Timestamp createDate;
    private String userId;
}
