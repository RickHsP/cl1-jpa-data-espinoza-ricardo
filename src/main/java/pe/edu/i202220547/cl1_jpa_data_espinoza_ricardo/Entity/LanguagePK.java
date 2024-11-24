package pe.edu.i202220547.cl1_jpa_data_espinoza_ricardo.Entity;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguagePK {
    private String CountryCode;
    private String Language;
}
