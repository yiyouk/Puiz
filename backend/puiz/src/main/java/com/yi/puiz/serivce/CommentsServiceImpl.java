package com.yi.puiz.serivce;

import com.yi.puiz.domain.CommentDto;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.yi.puiz.mapper.CommentsMapper;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentsServiceImpl implements CommentsService{

    @Autowired
    private SqlSession sqlSession;

    @Override
    public boolean createComment(CommentDto commentDto)throws Exception{
        return sqlSession.getMapper(CommentsMapper.class).createComment(commentDto) == 1;
    } //작성

    @Override
    public List<CommentDto> readComment() throws Exception{
        return sqlSession.getMapper(CommentsMapper.class).readComment();
    } //조회

    @Override
    @Transactional
    public boolean updateComment(CommentDto commentDto) throws Exception{
        return sqlSession.getMapper(CommentsMapper.class).updateComment(commentDto) == 1;
    } //수정

    @Override
    @Transactional
    public boolean deleteComment(CommentDto commentDto) throws Exception{
        return sqlSession.getMapper(CommentsMapper.class).deleteComment(commentDto) == 1;
    } //삭제

}
