package pl.lodz.uni.math.kamilmucha.SlowkoRestApi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "slowka")
public class Slowko{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 100)
    private String slowko;

    @NotNull
    @Size(max = 100)
    private String tlumaczenie;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "zestaw_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Zestaw zestaw;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSlowko() {
        return slowko;
    }

    public void setSlowko(String slowko) {
        this.slowko = slowko;
    }

    public String getTlumaczenie() {
        return tlumaczenie;
    }

    public void setTlumaczenie(String tlumaczenie) {
        this.tlumaczenie = tlumaczenie;
    }

    public Zestaw getZestaw() {
        return zestaw;
    }

    public void setZestaw(Zestaw zestaw) {
        this.zestaw = zestaw;
    }
}
