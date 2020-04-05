package functional.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pet {
    private PetSpecies petSpecies;
    private String petName;

}
