package pl.lodz.uni.math.kamilmucha.SlowkoRestApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.lodz.uni.math.kamilmucha.SlowkoRestApi.exception.ResourceNotFoundException;
import pl.lodz.uni.math.kamilmucha.SlowkoRestApi.model.Slowko;
import pl.lodz.uni.math.kamilmucha.SlowkoRestApi.repository.SlowkoRepository;
import pl.lodz.uni.math.kamilmucha.SlowkoRestApi.repository.ZestawRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SlowkoController {
    @Autowired
    SlowkoRepository slowkoRepository;

    @Autowired
    ZestawRepository zestawRepository;

    @GetMapping("/all/{zestawId}")
    public Page<Slowko> getAllSlowkaByZestawId(@PathVariable(value = "zestawId") Long zestawId,
                                               Pageable pageable) {
        return slowkoRepository.findByZestawId(zestawId, pageable);
    }

    @GetMapping("/zestawy/{zestawId}")
    public  Iterable<Slowko> findAllByZestawId(@PathVariable(value = "zestawId") Long zestawId){
        return slowkoRepository.findAllByZestawId(zestawId);
    }

   // @PostMapping("/zestawy/{zestawId}")
    public Slowko createSlowko(@PathVariable (value = "zestawId") Long zestawId,
                                 @Valid @RequestBody Slowko slowko) {
        return zestawRepository.findById(zestawId).map(zestaw -> {
            slowko.setZestaw(zestaw);
            return slowkoRepository.save(slowko);
        }).orElseThrow(() -> new ResourceNotFoundException("ZestawId " + zestawId + " not found"));
    }

    @PostMapping("/zestawy/{zestawId}")
    public List<Slowko> createSlowkas(@PathVariable (value = "zestawId") Long zestawId,
                                      @Valid @RequestBody List<Slowko> slowkas) {
        List<Slowko> response = new ArrayList<>();
        return zestawRepository.findById(zestawId).map(zestaw -> {
            for(Slowko slowko : slowkas){
                slowko.setZestaw(zestaw);
                slowkoRepository.save(slowko);
                response.add(slowko);
            }
            return response;
        }).orElseThrow(() -> new ResourceNotFoundException("ZestawId " + zestawId + " not found"));
    }
}
