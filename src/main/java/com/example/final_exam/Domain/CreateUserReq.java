package com.example.final_exam.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateUserReq {
    String firstName;
    String lastName;
    String email;
    String id;
    String password;
}
