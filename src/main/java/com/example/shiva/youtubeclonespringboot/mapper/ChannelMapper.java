package com.example.shiva.youtubeclonespringboot.mapper;

import com.example.shiva.youtubeclonespringboot.dto.ChannelDTO;
import com.example.shiva.youtubeclonespringboot.entity.Channel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ChannelMapper {

    @Mappings({
            @Mapping(target = "user", source = "channel.user.userName")
    })
    ChannelDTO toChannelDTO(Channel channel);
    List<ChannelDTO> toChannelDTO(Collection<Channel> channel);

}