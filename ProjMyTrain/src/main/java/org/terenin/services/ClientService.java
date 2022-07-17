package org.terenin.services;

import org.terenin.dto.SignUpFormForUser;

public interface ClientService {

    void signUp(SignUpFormForUser form);

    void update(SignUpFormForUser form);

    void takeOrder();

}
