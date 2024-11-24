package pe.edu.i202220547.cl1_jpa_data_espinoza_ricardo.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "city")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class City {

    @Id
    private Integer ID;
    private String Name;
    private String CountryCode;
    private String District;
    private Integer Population;

    @ManyToOne
    @JoinColumn(name = "CountryCode")
    private Country country;
}
