package org.terenin.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceGuy {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String typeOfWorking;
    private String accessToken;


}
