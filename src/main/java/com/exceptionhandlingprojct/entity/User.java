package com.exceptionhandlingprojct.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@Table(name = "user_tb")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_tb_seq_gen")
    @SequenceGenerator(sequenceName = "user_tb_seq_gen", name = "user_tb_seq", allocationSize = 1)
    private Long id;

    @NotBlank(message = "Entr the name ")
    private String name;

    @NotBlank(message = "enter the address")
    @Size(min = 3, max = 20, message = "Street address must be between 3 and 50 characters")
    private String address;
}
