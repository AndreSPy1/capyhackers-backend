package com.nisum.capyhackers.services;

import com.nisum.capyhackers.Repositories.SintomaRepository;
import com.nisum.capyhackers.dtos.SintomaDTO;
import com.nisum.capyhackers.models.Sintoma;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SintomaServiceImpl implements ISintomaService {

    @Autowired
    SintomaRepository repository;

    ModelMapper mapper = new ModelMapper();
    @Override
    public List<SintomaDTO> obtenerSintomas() {
        List<Integer> randoms = obtenerRandoms();
        List<SintomaDTO> sintomaDTOS = new ArrayList<>();
        List<Sintoma> sintomas = repository.findAll();

        for (Integer random: randoms) {
            Sintoma sintoma = sintomas.stream().filter(sintomaBuscar -> Objects.equals(sintomaBuscar.getIdSintoma(), random)).findFirst().get();
            sintomaDTOS.add(mapper.map(sintoma, SintomaDTO.class));
        }
        return sintomaDTOS;
    }

    private List<Integer> obtenerRandoms(){
        List<Integer> numbers = new ArrayList<>();
        int random;
        boolean validacion;
        for(int i=0; i<19; i++){
            random = (int) ((Math.random() * 67) + 1);
            if(numbers.size() == 0) {
                numbers.add(random);
            }

            if(numbers.size() > 0){
                int finalRandom = random;
                validacion = numbers.stream().anyMatch(n -> n == finalRandom);
                if(validacion){
                    i = i - 1;
                }else{
                    numbers.add(random);
                }
            }
        }

        return numbers;
    }
}
