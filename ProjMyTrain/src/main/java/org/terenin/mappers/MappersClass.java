package org.terenin.mappers;

import org.terenin.dto.SignUpFormForUser;
import org.terenin.models.Client;

import java.util.function.Function;

public class MappersClass {

    public static Function<SignUpFormForUser, Client> clientFunction = signUpFormForUser -> Client.builder()
            .firstName(signUpFormForUser.getFirstName())
            .lastName(signUpFormForUser.getLastName())
            .email(signUpFormForUser.getEmail())
            .password(signUpFormForUser.getPassword())
            .build();


}
