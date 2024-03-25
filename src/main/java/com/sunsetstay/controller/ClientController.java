package com.sunsetstay.controller;

import com.sunsetstay.dto.ClientDto;
import com.sunsetstay.entities.Client;
import com.sunsetstay.services.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

  private ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @PostMapping("/save")
  public Client saveClient(@RequestBody Client client) {
    return clientService.createClient(client);
  }

  @GetMapping("/{ci}")
  public ClientDto getClientByCi(@PathVariable Integer ci) {
    return clientService.getClientByCi(ci);
  }

  @GetMapping("/list")
  public List<ClientDto> listClient() {
    return clientService.list();
  }
}
