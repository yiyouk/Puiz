package com.yi.puiz.domain;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CommentDto {
    private int id;
    private String content;
    private String password;
}
