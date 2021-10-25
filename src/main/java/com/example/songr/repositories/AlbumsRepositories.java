package com.example.songr.repositories;

import com.example.songr.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumsRepositories extends CrudRepository<Album, Long> {
}
