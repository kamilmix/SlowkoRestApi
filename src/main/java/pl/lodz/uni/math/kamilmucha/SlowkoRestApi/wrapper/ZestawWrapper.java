package pl.lodz.uni.math.kamilmucha.SlowkoRestApi.wrapper;

import pl.lodz.uni.math.kamilmucha.SlowkoRestApi.model.Slowko;
import pl.lodz.uni.math.kamilmucha.SlowkoRestApi.model.Zestaw;

import java.util.List;

public class ZestawWrapper {
    private Zestaw zestaw;
    private List<Slowko> slowka;


    public List<Slowko> getSlowka() {
        return slowka;
    }

    public void setSlowka(List<Slowko> slowka) {
        this.slowka = slowka;
    }

    public Zestaw getZestaw() {
        return zestaw;
    }

    public void setZestaw(Zestaw zestaw) {
        this.zestaw = zestaw;
    }
}
