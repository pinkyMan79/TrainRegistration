package org.terenin.repositries;

import org.terenin.models.ServiceGuy;
import org.terenin.models.supermodels.ServiceStaff;

import java.util.List;

public interface CRUDRepoForServiceStaff {

    void create(ServiceGuy serviceGuy);

    List<ServiceGuy> findAll();

    ServiceGuy findById(Long id);

    void update(ServiceGuy serviceGuy);

    void deleteById(ServiceGuy serviceGuy);

}
