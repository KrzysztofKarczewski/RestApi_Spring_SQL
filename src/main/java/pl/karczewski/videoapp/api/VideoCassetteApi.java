package pl.karczewski.videoapp.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.karczewski.videoapp.dao.entity.VideoCassette;
import pl.karczewski.videoapp.manager.VideoCassetteManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassetts")                                                   //HOST/PORT/api/cassetts
public class VideoCassetteApi {

    private VideoCassetteManager videoCassettes;

    @Autowired
    public VideoCassetteApi(VideoCassetteManager videoCassettes) {
        this.videoCassettes = videoCassettes;
    }

    // GET DATA

    @GetMapping("/all")                                                                    //method returning all elements
    public Iterable<VideoCassette> getAll() {
        return videoCassettes.findAll();
    }

    @GetMapping
    public Optional<VideoCassette> getById(@RequestParam Long index) {                          //reference by index param
        return videoCassettes.findById(index);
    }

    // POST DATA

    @PostMapping                                                                           //
    public VideoCassette addVideo(@RequestBody VideoCassette videoCassette) {                   //web method just made body :)
        return videoCassettes.save(videoCassette);
    }

    // OVERWRITE DATA

    @PutMapping
    public VideoCassette updateVideo(@RequestBody VideoCassette videoCassette) {                   //web method just made body :)
        return videoCassettes.save(videoCassette);
    }

    // DELETING DATA

    @DeleteMapping
    public void deleteVideo(@RequestParam Long index) {                   //web method just made body :)
        videoCassettes.deleteById(index);
    }

}
