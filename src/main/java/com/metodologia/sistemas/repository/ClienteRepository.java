package com.metodologia.sistemas.repository;

import com.metodologia.sistemas.entity.Cliente;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ClienteRepository {

    private Map<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();

    @PostConstruct
    public void setup(){
        clientes.put(1, new Cliente("Effie","Moran"));
        clientes.put(2, new Cliente("Miguel","Vargas"));
        clientes.put(3, new Cliente("Agustin","Olivello"));
    }

    public List<Cliente> findAll(){
        return new ArrayList<Cliente>(clientes.values());
    }

    public Cliente find(int id){
        return clientes.get(id);
    }

    public void update(int id, Cliente cliente){
        clientes.put(id, cliente);
    }

    public void delete(int id){
        clientes.remove(id);
    }

    public void save(Cliente cliente){clientes.put(cliente.getId(),cliente);
    }
}
