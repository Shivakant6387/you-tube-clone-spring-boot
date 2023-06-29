package com.example.shiva.youtubeclonespringboot.controller;

import com.example.shiva.youtubeclonespringboot.ApiInformation;
import com.example.shiva.youtubeclonespringboot.dto.ChannelDTO;
import com.example.shiva.youtubeclonespringboot.dto.PatchChannelDTO;
import com.example.shiva.youtubeclonespringboot.mapper.ChannelMapper;
import com.example.shiva.youtubeclonespringboot.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChannelController {

    private ChannelService channelService;
    private ChannelMapper channelMapper;

    @Autowired
    public ChannelController(ChannelService channelService, ChannelMapper channelMapper) {
        this.channelService = channelService;
        this.channelMapper = channelMapper;
    }

    @GetMapping("/channels")
    public List<ChannelDTO> getChannels() {
        return channelMapper.toChannelDTO(channelService.getChannels());
    }

    @GetMapping("/channels/{id}")
    public ChannelDTO getChannelById(@PathVariable Long id){
        return channelMapper.toChannelDTO(channelService.getChannelById(id));
    }

    @DeleteMapping("/channels/{id}")
    public ApiInformation deleteChannelById(@PathVariable Long id){
        channelService.deleteChannelById(id);
        return new ApiInformation("Channel deleted.", HttpStatus.OK.value());
    }

    @PatchMapping("/channels/{id}")
    public ChannelDTO updateChannelById(@PathVariable Long id, @Validated @RequestBody PatchChannelDTO patchChannelDTO){
        return channelMapper.toChannelDTO(channelService.updateChannelById(id, patchChannelDTO));
    }

    @GetMapping("/users/{id}/channels")
    public List<ChannelDTO> getChannelsByUserId(@PathVariable Long id){
        return channelMapper.toChannelDTO(channelService.getChannelsByUserId(id));
    }
}
