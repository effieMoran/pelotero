package com.metodologia.sistemas.service.imp;

import com.metodologia.sistemas.entity.Reserva;
import com.metodologia.sistemas.repository.ReservaRepository;
import com.metodologia.sistemas.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImplementation implements ReservaService{

    @Autowired
    ReservaRepository reservaRepository;

    public void save(Reserva reserva) {
        reservaRepository.save(reserva);
    }


    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }
}
