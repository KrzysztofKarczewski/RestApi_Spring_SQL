package pl.karczewski.videoapp;


import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassetts")                                                   //HOST/PORT/api/cassetts
public class VideoCassetteApi {

    private List<VideoCassette> videoCassettes;                                    //keep cassetes in simple List

    public VideoCassetteApi()   {                                                  //initilaize list in constructor
        videoCassettes = new ArrayList<>();
        videoCassettes.add(new VideoCassette(1L,"Godzilla", LocalDate.of(1993,12,1)));
        videoCassettes.add(new VideoCassette(2L,"Pulp Fiction", LocalDate.of(1990,2,3)));
    }

    // GET DATA

    @GetMapping("/all")                                                                    //method returning all elements
    public List<VideoCassette> getAll() {
        return videoCassettes;
    }

    @GetMapping
    public VideoCassette getById(@RequestParam int index) {                          //reference by index param
        Optional<VideoCassette> first =  videoCassettes.stream().
                filter(element -> element.getId() == index).findFirst();                   //using lambda
        return  first.get ();
    }

    // POST DATA

    @PostMapping                                                                           //
    public boolean addVideo(@RequestBody VideoCassette videoCassette) {                   //web method just made body :)
        return videoCassettes.add(videoCassette);
    }

    // OVERWRITE DATA

    @PutMapping
    public boolean updateVideo(@RequestBody VideoCassette videoCassette) {                   //web method just made body :)
        return videoCassettes.add(videoCassette);
    }

    // DELETING DATA

    @DeleteMapping
    public boolean deleteVideo(@RequestParam int index) {                   //web method just made body :)
        return videoCassettes.removeIf(element -> element.getId() == index);
    }

}
