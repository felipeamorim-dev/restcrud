package com.example.restcrud.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class UserCreateRequest implements Serializable {

    @Email
    @NotEmpty
    private String email;

    @NotNull
    private Long roleId;

    @NotEmpty
    private String name;

}
