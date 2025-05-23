package br.com.fiap.gyma_api.config;

import br.com.fiap.gyma_api.model.*;
import br.com.fiap.gyma_api.repository.ExerciseRepository;
import br.com.fiap.gyma_api.repository.PlanRepository;
import br.com.fiap.gyma_api.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init(){

        String password = passwordEncoder.encode("12345");

        var joao = User.builder()
                .email("joao@fiap.com.br")
                .password(password)
                .build();

        var saes = User.builder()
                .email("saes@fiap.com.br")
                .password(password)
                .build();

        userRepository.saveAll(List.of(joao, saes));

        Exercise remadaCurvada = Exercise.builder()
                .name("Remada Curvada")
                .muscleGroup("Costas")
                .repetitions(10)
                .series(4)
                .restSec(60)
                .build();

        Exercise supinoReto = Exercise.builder()
                .name("Supino Reto")
                .muscleGroup("Peito")
                .repetitions(12)
                .series(3)
                .restSec(80)
                .build();

        Exercise agachamento = Exercise.builder()
                .name("Agachamento")
                .muscleGroup("Perna")
                .repetitions(15)
                .series(3)
                .restSec(90)
                .build();

        exerciseRepository.saveAll(List.of(remadaCurvada, supinoReto, agachamento));

        Plan planoHipertrofia = Plan.builder()
                .name("Plano Hipertrofia Básico")
                .type("hipertrofia")
                .exercises(List.of(remadaCurvada, supinoReto))
                .user(joao)
                .build();

        Plan planoHipertrofia2 = Plan.builder()
                .name("Plano Hipertrofia Básico 2")
                .type("hipertrofia")
                .exercises(List.of(remadaCurvada, supinoReto))
                .user(joao)
                .build();

        Plan planoEmagrecimento = Plan.builder()
                .name("Plano Emagrecimento Básico")
                .type("hipertrofia")
                .exercises(List.of(agachamento, supinoReto))
                .user(saes)
                .build();

        planRepository.saveAll(List.of(planoHipertrofia, planoEmagrecimento, planoHipertrofia2));
    }
}
