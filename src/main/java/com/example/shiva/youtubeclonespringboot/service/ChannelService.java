package com.example.shiva.youtubeclonespringboot.service;

import com.example.shiva.youtubeclonespringboot.dto.PatchChannelDTO;
import com.example.shiva.youtubeclonespringboot.entity.Channel;
import com.example.shiva.youtubeclonespringboot.exception.ChannelNotFoundException;
import com.example.shiva.youtubeclonespringboot.repository.ChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {

    private ChannelRepository channelRepository;

    @Autowired
    public ChannelService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public List<Channel> getChannels() {
        return channelRepository.findAll();
    }

    public Channel getChannelById(Long id) {
        return channelRepository.findById(id)
                .orElseThrow(() -> new ChannelNotFoundException("Can not find this channel"));
    }

    public List<Channel> getUserChannelsById(Long id) {
        return channelRepository.findAllByUser_Id(id);
    }

    public Channel save(Channel channel) {
        return channelRepository.save(channel);
    }

    public void deleteChannelById(Long id) {
        channelRepository.deleteById(id);
    }

    public Channel updateChannelById(Long id, PatchChannelDTO patchChannelDTO) {
        Channel channel = getChannelById(id);
        channel.setDescription(patchChannelDTO.getDescription());
        return channelRepository.save(channel);
    }

    public List<Channel> getChannelsByUserId(Long id) {
        return channelRepository.findAllByUser_Id(id);
    }

}
