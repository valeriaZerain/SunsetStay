package com.sunsetstay.services;

import com.sunsetstay.dto.ClientDto;
import com.sunsetstay.entities.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client createClient(Client client);
    ClientDto getClientByCi(int ci);

    List<ClientDto> list();
}
