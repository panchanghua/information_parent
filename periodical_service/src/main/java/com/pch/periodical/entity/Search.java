package com.pch.periodical.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Search {
    private static final long serialVersionUID = -12836623932093698L;
    String name;
    String editor;
    String time;
    String sponsor;
    String administer;
    Boolean subscribe;
}
