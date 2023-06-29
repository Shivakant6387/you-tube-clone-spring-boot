package com.example.shiva.youtubeclonespringboot.repository;

import com.example.shiva.youtubeclonespringboot.entity.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChannelRepository  extends JpaRepository<Channel, Long> {

    List<Channel> findAllByUser_Id(Long id);
}
