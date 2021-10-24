package com.example.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SongerController {

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
        Album[] albums=new Album[3];
        albums[0] = new Album("Folklore", "Taylor Swift", 16, 3809, "https://static.billboard.com/files/2020/12/Taylor-swift-folklore-cover-billboard-1240-1607121703-compressed.jpg");
        albums[1] = new Album("The Album", "Blackpink", 8, 1466, "https://static.billboard.com/files/2020/12/blackpink-the-album-billboard-1240-1607365628-compressed.jpg");
        albums[2] = new Album("Good Souls Better Angels", "Lucinda Williams", 12, 3589, "https://static.billboard.com/files/2020/12/lucinda-williams-good-souls-better-angels-cover-billboard-1240-1607121672-compressed.jpg");
        model.addAttribute("albums", albums);
        return "albums";
    }
    @GetMapping("/")
    public String HomePage(){
        return "splash";
    }
}
