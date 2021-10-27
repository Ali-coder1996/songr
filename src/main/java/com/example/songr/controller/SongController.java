package com.example.songr.controller;

import com.example.songr.model.Album;
import com.example.songr.model.Song;
import com.example.songr.repositories.AlbumsRepositories;
import com.example.songr.repositories.SongRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class SongController {

    @Autowired
    SongRepositories songRepositories;

    @Autowired
    AlbumsRepositories albumsRepositories;

    @GetMapping("/song/{id}")
    public String getAllSong(@PathVariable String id, Model model){
        Album album = albumsRepositories.getById(Long.parseLong(id));
        model.addAttribute("album", album);
        return "song";
    }
    @PostMapping("/song/addSong")
    public RedirectView addSongToAlbum(String album, String title, int length, int trackNumber) {
        List<Album> songAlbum = albumsRepositories.findByTitle(album);
        Song newSong = new Song(title, length, trackNumber, songAlbum.get(0));
        songRepositories.save(newSong);
        List<Song> song = songRepositories.findByTitleAndAlbum(
                newSong.getTitle(),
                newSong.getAlbum()
        );
        return new RedirectView("/song/" + song.get(0).getAlbum().getId());
    }

}
