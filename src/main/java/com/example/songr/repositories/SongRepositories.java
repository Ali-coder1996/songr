package com.example.songr.repositories;

import com.example.songr.model.Album;
import com.example.songr.model.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepositories extends CrudRepository<Song,Long> {
    public List<Song> findByTitleAndAlbum(String title, Album album);

}
