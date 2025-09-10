package com.example.mycollections.controllers;

import com.example.mycollections.models.Album;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final List<Album> albums = new ArrayList<>() {{
        add(new Album("Mr. RockSteady", "Ken Boothe", 1968, 12));
        add(new Album("Legalize It", "Peter Tosh", 1976, 9));
        add(new Album("Catch A Fire", "Bob Marley & The Wailers", 1973, 9));
    }};

    @GetMapping("/json")
    public List<Album> getAlbumsJson() {
        return albums;
    }

    @GetMapping("/html")
    public String getAlbumsHtml() {
        String albumList = "<ul>";
        for (Album album : albums) {
            albumList += "<li>" + album + "</li>";
        }
        albumList += "</ul>";
        return """
                <html>
                    <body>
                        <h1>Albums</h1>
                        <ul>
                """

                + albumList  +
                """
                        </ul>
                    </body>
                """;
    }

}
