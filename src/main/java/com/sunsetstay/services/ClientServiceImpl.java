package com.sunsetstay.services;

import com.sunsetstay.dto.ClientDto;
import com.sunsetstay.entities.Client;
import com.sunsetstay.mapper.ClientMapper;
import com.sunsetstay.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
  private ClientRepository clientRepository;

  private ClientMapper clientMapper;

  public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
    this.clientRepository = clientRepository;
    this.clientMapper = clientMapper;
  }

  @Override
  public Client createClient(Client client) {
    clientRepository.save(client);
    return client;
  }

  @Override
  public ClientDto getClientByCi(int ci) {
    Client client = clientRepository.getClientByCi(ci).get();
    return clientMapper.toDto(client);
  }

  @Override
  public List<ClientDto> list() {
    List<Client> clientList = clientRepository.findAll();
    List<ClientDto> clientDtoList =
        clientList.stream().map(client -> clientMapper.toDto(client)).collect(Collectors.toList());
    return clientDtoList;
  }
}
