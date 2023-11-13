package com.yi.puiz.mapper;

import com.yi.puiz.domain.CommentDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface CommentsMapper {
    public int createComment(CommentDto commentDto)throws SQLException; //작성
    public List<CommentDto> readComment() throws SQLException; //조회
    public int updateComment(CommentDto commentDto) throws SQLException; //수정
    public int deleteComment(CommentDto commentDto) throws SQLException; //조회
}
