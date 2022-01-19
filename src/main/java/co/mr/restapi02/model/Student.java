package co.mr.restapi02.model;

import lombok.Data;

@Data
public class Student {
    private int id;
    private int academyId;
    private String name;
    private String tel;
}
