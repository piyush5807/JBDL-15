package org.example.gfg.restapis;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneImpl implements Phone{

    private int number;
    private String countryCode;
}
