package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PackageTest {
    @Test
    void givenSomeDataReturnAPackage(){
        String data = "Apahida,15,100,2017-09-01";
        Package aPackage = Package.createPackageFromStringData(data);
        assertEquals("Apahida", aPackage.destination());
    }

    @Test
    void givenSomeDataReturnAPackageWithDistance(){
        String data = "Apahida,15,100,2017-09-01";
        Package aPackage = Package.createPackageFromStringData(data);
        assertEquals(15, aPackage.distance());
    }

    @Test
    void givenSomeDataReturnAPackageWithPrice(){
        String data = "Apahida,15,100,2017-09-01";
        Package aPackage = Package.createPackageFromStringData(data);
        assertEquals(100, aPackage.price());
    }

    @Test
    void givenSomeDataReturnAPackageDate(){
        String data = "Apahida,15,100,2017-09-01";
        Package aPackage = Package.createPackageFromStringData(data);
        assertEquals("2017-09-01", aPackage.date().toString());
    }

    @Test
    void givenWrongDataExceptionThrown(){
        String data = "dsad";
        Exception exception = assertThrows(BusinessException.class, () -> Package.createPackageFromStringData(data));
        assertEquals("Invalid string for creating the package:"+data, exception.getMessage());
    }

    @Test
    void givenNullDataReturnExceptionThrown(){
        String data = null;
        Exception exception = assertThrows(BusinessException.class, () -> Package.createPackageFromStringData(data));
        assertEquals("Null data for package creation", exception.getMessage());
    }

}
