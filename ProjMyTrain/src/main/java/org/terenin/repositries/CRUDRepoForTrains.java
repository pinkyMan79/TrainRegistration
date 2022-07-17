package org.terenin.repositries;

import org.terenin.models.ServiceGuy;
import org.terenin.models.Train;

import java.util.List;

public interface CRUDRepoForTrains {

    void create(Train train);

    List<Train> findAll();

    Train findById(Long id);

    void update(Train train);

    void deleteById(Train train);

}
