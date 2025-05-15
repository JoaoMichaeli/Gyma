package br.com.fiap.gyma_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    private String name;

    @NotEmpty(message = "O grupo muscular não pode estar vazio")
    @ElementCollection
    private List<MuscleGroup> muscleGroup;

    @Min(value = 1, message = "O número de repetições deve ser pelo menos 1")
    private int repetitions;

    @Min(value = 1, message = "O número de séries deve ser pelo menos 1")
    private int series;

    @Min(value = 1, message = "O tempo de descanso deve ser pelo menos 1 segundo")
    private int restSec;

}
