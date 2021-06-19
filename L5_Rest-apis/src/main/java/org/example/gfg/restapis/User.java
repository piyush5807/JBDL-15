package org.example.gfg.restapis;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    private int id;
    private String name;
    private int age;
    private String country;
    private PhoneImpl phone;

}
