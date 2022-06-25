package com.example.final_exam.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DeletePostReq {
    private String id;
    private String title;
    private int postIdx;
}
