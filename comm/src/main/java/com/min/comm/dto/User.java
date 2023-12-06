package com.min.comm.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * 用户Dto
 */
@AllArgsConstructor //全参构造
public class User {
    private String name;
    private int age;
}
