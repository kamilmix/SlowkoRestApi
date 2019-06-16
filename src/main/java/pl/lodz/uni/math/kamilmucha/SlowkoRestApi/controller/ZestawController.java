package pl.lodz.uni.math.kamilmucha.SlowkoRestApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.lodz.uni.math.kamilmucha.SlowkoRestApi.model.Slowko;
import pl.lodz.uni.math.kamilmucha.SlowkoRestApi.model.Zestaw;
import pl.lodz.uni.math.kamilmucha.SlowkoRestApi.repository.SlowkoRepository;
import pl.lodz.uni.math.kamilmucha.SlowkoRestApi.repository.ZestawRepository;
import pl.lodz.uni.math.kamilmucha.SlowkoRestApi.wrapper.ZestawWrapper;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ZestawController {
    @Autowired
    ZestawRepository zestawRepository;

    @Autowired
    SlowkoRepository slowkoRepository;

    @GetMapping("/all")
    public Page<Zestaw> getAllZestaws(Pageable pageable){
        return zestawRepository.findAll(pageable);
    }

    @GetMapping("/zestawy")
    public List<Zestaw> getAll() {
        return zestawRepository.findAll();
    }

    @PostMapping("/zestaw")
     public Zestaw createSingleZestaw(@Valid @RequestBody Zestaw zestaw) {
        return zestawRepository.save(zestaw);
    }

    @PostMapping("/zestawy")
    public Zestaw createZestaw(@Valid @RequestBody ZestawWrapper zestawWrapper) {
        Zestaw nowyZestaw =  zestawRepository.save(zestawWrapper.getZestaw());
        for (Slowko slowko :zestawWrapper.getSlowka()){
            slowko.setZestaw(nowyZestaw);
            slowkoRepository.save(slowko);
        }
        return nowyZestaw;
    }
}
