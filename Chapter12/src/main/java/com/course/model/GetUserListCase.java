package com.course.model;

import lombok.Data;

import java.security.Policy;

@Data
public class GetUserListCase {
    private String userName;
    private String age;
    private String sex;
    private String expected;
}
