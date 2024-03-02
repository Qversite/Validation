package com.example.springvalidation.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonForm {
    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    @NotNull
    @Min(18)
    private Integer age;

    @Override
    public String toString() {
        return "Person(Name: " + this.name + ", Age: " + this.age + ")";
    }
}
