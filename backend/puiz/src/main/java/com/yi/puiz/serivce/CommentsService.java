package com.yi.puiz.serivce;

import com.yi.puiz.domain.CommentDto;

import java.util.List;


public interface CommentsService {
    public boolean createComment(CommentDto commentDto)throws Exception; //작성
    public List<CommentDto> readComment() throws Exception; //조회
    public boolean updateComment(CommentDto commentDto) throws Exception; //수정
    public boolean deleteComment(CommentDto commentDto) throws Exception; //조회
}
