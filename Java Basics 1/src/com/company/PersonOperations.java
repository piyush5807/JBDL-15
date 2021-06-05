package com.company;

public interface PersonOperations {


    int incrementAge();

    int decrementAge();

    default int multipleAgeByFactor2(int age){
        return age * 2;
    }
}

// 1. Abstract class vs Interfaces
// 2. Final keyword
// 3. Streams, Lambdas and FI
// 4. Exception Handling

