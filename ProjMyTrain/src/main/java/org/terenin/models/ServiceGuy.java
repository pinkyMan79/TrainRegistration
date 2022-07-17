package org.terenin.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
