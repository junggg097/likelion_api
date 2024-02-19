package com.example.api.dto;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
// Request Body 또는 Response Body 를 나타낸다.
// 이걸 HTTP Client 들이 그대로 활용 가능
public class ArticleDto {
    private Long id;
    @Setter
    private String title;
    @Setter
    private String content;
    @Setter
    private String writer;

}