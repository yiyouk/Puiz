package com.yi.puiz.controller;

import com.yi.puiz.domain.CommentDto;
import com.yi.puiz.serivce.CommentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RequestMapping("/comments")
@RestController
@Api("댓글 컨트롤러 API")
public class CommentsController {

    private static final Logger logger = LoggerFactory.getLogger(CommentsController.class);
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    private CommentsService commentsService;

    @ApiOperation(value = "댓글작성", notes = "댓글 작성, DB입력 성공여부에 따라 'success' 또는 'fail' 반환", response = String.class)
    @PostMapping
    public ResponseEntity<String> createComment(@RequestBody @ApiParam(value = "게시글 정보.", required = true) CommentDto commentDto) throws Exception {
        logger.info("createComment - 호출", commentDto);
        if (commentsService.createComment(commentDto)) {
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "댓글 목록", notes = "모든 댓글 반환", response = List.class)
    @GetMapping
    public ResponseEntity<List<CommentDto>> readComment() throws Exception {
        logger.info("readComments - 호출");
        return new ResponseEntity<List<CommentDto>>(commentsService.readComment(), HttpStatus.OK);
    }

    @ApiOperation(value = "댓글 수정", notes = "수정 댓글 정보 입력, DB수정 성공여부에 따라 'success' 또는 'fail' 반환", response = String.class)
    @PutMapping
    public ResponseEntity<String> updateComments(@RequestBody @ApiParam(value = "수정 댓글 정보.", required = true) CommentDto commentDto) throws Exception {
        logger.info("updateComments - 호출 {}", commentDto);

        if (commentsService.updateComment(commentDto)) {
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<String>(FAIL, HttpStatus.OK);
    }

    @ApiOperation(value = "댓글 글삭제", notes = "해당 댓글 삭제, DB삭제 성공여부에 따라 'success' 또는 'fail' 반환", response = String.class)
    @DeleteMapping
    public ResponseEntity<String> deleteComments(@RequestBody @ApiParam(value = "살제할 댓글", required = true) CommentDto commentDto) throws Exception {
        logger.info("deleteComments - 호출", commentDto);
        if (commentsService.deleteComment(commentDto)) {
            return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
        }
        return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
    }


}
