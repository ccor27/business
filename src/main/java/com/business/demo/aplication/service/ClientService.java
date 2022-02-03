package com.business.demo.aplication.service;

import com.business.demo.domain.model.Client;
import com.business.demo.aplication.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client save(Client client){

        Client c = clientRepository.save(client);
        if(c==null){
            throw new IllegalStateException("error in save client");
        }
        return c;
    }

    public List<Client> getAll(){
        return clientRepository.findAll();
    }

    public Optional<Client> findById(Integer id){
        if(!clientRepository.findById(id).isPresent()){
            throw new IllegalStateException("client with id: "+id+" no exist");
        }
        return clientRepository.findById(id);
    }

    public void deleteClient(Integer id){

     if(!findById(id).isPresent()){
         throw new IllegalStateException("client with "+id+" not exist");
     }
        Client c = findById(id).get();
        clientRepository.delete(c);
    }

    public Optional<Client> findByEmail(String email){
        if(!clientRepository.findByEmail(email).isPresent()){
            throw new IllegalStateException("client with email: "+email+" no exist");
        }
        return clientRepository.findByEmail(email);
    }
}
