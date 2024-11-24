package pe.edu.i202220547.cl1_jpa_data_espinoza_ricardo.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "countrylanguage")
@NoArgsConstructor
@AllArgsConstructor

public class CountryLanguage {

    @EmbeddedId
    private LanguagePK languagePK;
    private String IsOfficial;
    private Integer Percentage;


    @ManyToOne
    @JoinColumn(name = "CountryCode")
    @MapsId("CountryCode")
    private Country country;

}
