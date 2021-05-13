package pl.zajecia.filmy.api;

import org.springframework.beans.factory.annotation.Autowired;
import pl.zajecia.filmy.dao.entity.VideoCassete;
import org.springframework.web.bind.annotation.*;
import pl.zajecia.filmy.manager.VideoCassetteManager;

import java.util.Optional;


@RestController
@RequestMapping("/api/cassetts")
public class VideoCasseteApi
{
   private VideoCassetteManager videoCassetteManager;

    @Autowired
    public VideoCasseteApi(VideoCassetteManager videoCassete){
        this.videoCassetteManager=videoCassete;
    }
    @GetMapping("/all")
    public Iterable<VideoCassete> getAll(){
        return videoCassetteManager.findAll();
    }
    @GetMapping
    public Optional<VideoCassete> getById(@RequestParam Long index){
        return videoCassetteManager.findAllById(index);
    }
    @PostMapping
    public VideoCassete addVideo(@RequestBody VideoCassete videoCassete){
        return videoCassetteManager.save(videoCassete);
    }
    @PutMapping
    public VideoCassete updateVideo(@RequestBody VideoCassete videoCassete){
        return videoCassetteManager.save(videoCassete);
    }
    @DeleteMapping
    public void deleteVideo(@RequestParam long index){
        videoCassetteManager.delete(index);
    }
}

