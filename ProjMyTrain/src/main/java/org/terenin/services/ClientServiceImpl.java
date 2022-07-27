package org.terenin.services;

import org.terenin.dto.SignUpFormForUser;
import org.terenin.mappers.MappersClass;
import org.terenin.repositries.CRUDRepoForClientsImpl;

public class ClientServiceImpl implements ClientService {

    private CRUDRepoForClientsImpl repoForClients;

    public ClientServiceImpl(CRUDRepoForClientsImpl repoForClients){

        this.repoForClients = repoForClients;

    }

    @Override
    public void signUp(SignUpFormForUser form) {

        repoForClients.create(MappersClass.clientFunction.apply(form));

    }

    @Override
    public void update(SignUpFormForUser form) {

        repoForClients.update(MappersClass.clientFunction.apply(form));

    }

    @Override
    public void takeOrder() {

    }
}
