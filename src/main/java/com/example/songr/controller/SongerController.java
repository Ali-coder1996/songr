package com.example.songr.controller;

import com.example.songr.model.Album;
import com.example.songr.repositories.AlbumsRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongerController {

    @Autowired
    AlbumsRepositories albumsRepositories;

    @GetMapping("/")
    public String HomePage(){
        return "splash";
    }

    @GetMapping("/hello")
    public String helloWorld(@RequestParam String name, Model model){
        model.addAttribute("name",name);
        return "helloWorld";
    }

    @PostMapping("/hello")
    public String postWorld(@RequestParam String name, Model model){
        model.addAttribute("name",name);
        return "helloWorld";
    }
    @GetMapping("/capitalize/{word}")
    public String capitalizeWord(@PathVariable String word, Model model){
        model.addAttribute("word",word.toUpperCase());
        return "capitalize";
    }

    @GetMapping("/albums")
    public String albums(Model model){
        model.addAttribute("albums" ,albumsRepositories.findAll());
        return "albums";
    }

    @PostMapping("/addAlbums")
    public RedirectView addAlbums(Album album){
        albumsRepositories.save(album);
        return new RedirectView("/albums");
    }
}
