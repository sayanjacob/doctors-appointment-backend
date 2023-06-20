package com.ust.review.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Doctor {


    private Long doctorId;
    private String doctorName;
    private String department;


}
