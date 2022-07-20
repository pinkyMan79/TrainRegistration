package org.terenin.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;



}
