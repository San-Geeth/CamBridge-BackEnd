package com.example.cambridge.entity.classes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author sangeethnawa
 * @createdOn 2/20/2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignStudentsRequest {
    private List<Integer> studentList;
}
