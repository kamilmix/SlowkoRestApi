package pl.lodz.uni.math.kamilmucha.SlowkoRestApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.lodz.uni.math.kamilmucha.SlowkoRestApi.model.Zestaw;
import pl.lodz.uni.math.kamilmucha.SlowkoRestApi.repository.ZestawRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ZestawController {
    @Autowired
    ZestawRepository zestawRepository;

    @GetMapping("/all")
    public Page<Zestaw> getAllZestaws(Pageable pageable){
        return zestawRepository.findAll(pageable);
    }

    @PostMapping("/zestawy")
    public Zestaw createPost(@Valid @RequestBody Zestaw zestaw) {
        return zestawRepository.save(zestaw);
    }

    @GetMapping("/zestawy")
    public List<Zestaw> getAll() {
        return zestawRepository.findAll();
    }
}
