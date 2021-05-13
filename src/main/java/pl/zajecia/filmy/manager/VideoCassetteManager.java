package pl.zajecia.filmy.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.zajecia.filmy.dao.VideoCssetteRepo;
import pl.zajecia.filmy.dao.entity.VideoCassete;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class VideoCassetteManager {
    private VideoCssetteRepo videoCssetteRepo;

    @Autowired
    public VideoCassetteManager(VideoCssetteRepo videoCssetteRepo){
        this.videoCssetteRepo=videoCssetteRepo;
    }
    public Optional<VideoCassete> findAllById(Long id){
        return videoCssetteRepo.findById(id);
    }
    public Iterable<VideoCassete> findAll(){
        return videoCssetteRepo.findAll();
    }
    public VideoCassete save(VideoCassete videoCassete){
        return videoCssetteRepo.save(videoCassete);
    }
    public void delete(Long id){
        videoCssetteRepo.deleteById(id);
    }
    @EventListener(ApplicationReadyEvent.class)
    public void fillDb(){
        save(new VideoCassete(1L, "Tytul1", LocalDate.of(1999,12,1)));
        save(new VideoCassete(2L, "Tytul2", LocalDate.of(1998,12,1)));
    }
}
