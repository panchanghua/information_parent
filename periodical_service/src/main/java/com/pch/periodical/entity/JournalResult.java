package com.pch.periodical.entity;

import lombok.Data;

import java.util.List;

@Data
public class JournalResult {
    Integer count;
    List<Journal> journals;
}
