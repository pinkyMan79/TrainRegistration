package org.terenin.services;

import org.terenin.dto.SignUpFormForUser;
import org.terenin.mappers.MappersClass;
import org.terenin.repositries.CRUDRepoForClientsImpl;

import javax.sql.DataSource;

public class ClientServiceImpl implements ClientService {
    
    private CRUDRepoForClientsImpl clientRepo;

    public ClientServiceImpl(CRUDRepoForClientsImpl clientRepo){

        this.clientRepo = clientRepo;

    }

    @Override
    public void signUp(SignUpFormForUser form) {

        clientRepo.create(MappersClass.clientFunction.apply(form));

    }

    @Override
    public void update(SignUpFormForUser form) {

        clientRepo.update(MappersClass.clientFunction.apply(form));

    }

    @Override
    public void takeOrder() {

    }
}
