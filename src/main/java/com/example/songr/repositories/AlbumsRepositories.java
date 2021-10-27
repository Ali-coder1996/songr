package com.example.songr.repositories;

import com.example.songr.model.Album;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlbumsRepositories extends CrudRepository<Album, Long> {
    public List<Album> findByTitle(String album);

    Album getById(long parseLong);
}
