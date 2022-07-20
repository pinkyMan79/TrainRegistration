package org.terenin.repositries;

import org.terenin.models.Client;

import java.util.List;

public interface CRUDRepoForClients {

    void create(Client client);

    List<Client> findAll();

    Client findById(Long id);

    void update(Client client);

    void deleteById(Long id);

}
