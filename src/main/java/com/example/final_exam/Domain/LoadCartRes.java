package com.example.final_exam.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoadCartRes {
    String name;
    String price;
}
