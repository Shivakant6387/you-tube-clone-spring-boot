package com.example.shiva.youtubeclonespringboot.controller;

import com.example.shiva.youtubeclonespringboot.dto.ReplyDTO;
import com.example.shiva.youtubeclonespringboot.mapper.ReplyMapper;
import com.example.shiva.youtubeclonespringboot.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReplyController {


    private ReplyService replyService;
    private ReplyMapper replyMapper;

    @Autowired
    public ReplyController(ReplyService replyService, ReplyMapper replyMapper) {
        this.replyService = replyService;
        this.replyMapper = replyMapper;
    }


    @GetMapping("/replies")
    public List<ReplyDTO> getReplies() {
        return replyMapper.toReplyDTO(replyService.getReplies());
    }


    @GetMapping("/comments/{id}/replies")
    public List<ReplyDTO> getRepliesByCommentId(@PathVariable Long id) {
        return replyMapper.toReplyDTO(replyService.getRepliesByCommentId(id));
    }


    @PostMapping("/replies")
    public ReplyDTO postReply(@RequestBody ReplyDTO replyDTO) {
        return replyMapper.toReplyDTO(replyService.postReply(replyMapper.toReplyEntity(replyDTO)));
    }
}