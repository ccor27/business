package com.business.demo.infrastructure.api;


import com.business.demo.aplication.service.ClientService;
import com.business.demo.domain.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }

    @PostMapping("/save")
    public Client save(@RequestBody Client client){
        return clientService.save(client);
    }

    @GetMapping("/get/email/{email}")
    public Optional<Client> findByEmail(@PathVariable("email")String email){
        return clientService.findByEmail(email);
    }
    @GetMapping("/get/id/{id}")
    public Optional<Client> getById(@PathVariable("id")Integer id){
        return clientService.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id")Integer id){
        clientService.deleteClient(id);
    }
    		/*<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>*/
}
