package org.terenin.services;

import org.terenin.dto.SignUpFormForUser;
import org.terenin.mappers.MappersClass;
import org.terenin.repositries.CRUDRepoForClientsImpl;

<<<<<<< HEAD
public class ClientServiceImpl implements ClientService {

    private CRUDRepoForClientsImpl repoForClients;

    public ClientServiceImpl(CRUDRepoForClientsImpl repoForClients){

        this.repoForClients = repoForClients;
=======
import javax.sql.DataSource;

public class ClientServiceImpl implements ClientService {

    private CRUDRepoForClientsImpl clientRepo;

    public ClientServiceImpl(CRUDRepoForClientsImpl clientRepo){

        this.clientRepo = clientRepo;
>>>>>>> 882246b9ee04612a496161e3e55616e7031a4db1

    }

    @Override
    public void signUp(SignUpFormForUser form) {

<<<<<<< HEAD
        repoForClients.create(MappersClass.clientFunction.apply(form));
=======
        clientRepo.create(MappersClass.clientFunction.apply(form));
>>>>>>> 882246b9ee04612a496161e3e55616e7031a4db1

    }

    @Override
    public void update(SignUpFormForUser form) {

<<<<<<< HEAD
        repoForClients.update(MappersClass.clientFunction.apply(form));
=======
        clientRepo.update(MappersClass.clientFunction.apply(form));
>>>>>>> 882246b9ee04612a496161e3e55616e7031a4db1

    }

    @Override
    public void takeOrder() {

    }
}
