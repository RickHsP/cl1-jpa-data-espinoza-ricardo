package pe.edu.i202220547.cl1_jpa_data_espinoza_ricardo.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "country")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Country {

    @Id
    private String Code;
    private String Name;
    private String Continent;
    private String Region;
    private Integer SurfaceArea;
    private Integer IndepYear;
    private Integer Population;
    private Integer LifeExpectancy;
    private Integer GNP;
    private Integer GNPOld;
    private String LocalName;
    private String GovernmentForm;
    private String HeadOfState;
    private Integer Capital;
    private String Code2;

    @OneToMany(mappedBy = "country")
    @ToString.Exclude
    private List<City> city;

    @OneToMany(mappedBy = "country")
    private List<CountryLanguage> countryLanguages;
}
