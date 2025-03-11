package org.example;

import java.time.LocalDate;

public record Package(String destination, Integer distance, Integer price, LocalDate date) {
    static public Package createPackageFromStringData(String data) {
        if (data == null) {
            throw new BusinessException("Null data for package creation");
        }
        String[] splitString = data.split(",");
        if (splitString.length != 4) {
            throw new BusinessException("Invalid string for creating the package:" + data);
        }
        return new Package(splitString[0],
                Integer.parseInt(splitString[1]),
                Integer.parseInt(splitString[2]),
                LocalDate.parse(splitString[3])
        );
    }
};
