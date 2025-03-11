package org.example;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PackageHandlerTest {
    @Test
    void givenListOfStringsReturnListOfPackages(){
        List<String> stringList = List.of("Turda,29,130,2017-09-01","Turda,29,149,2017-09-01");
        PackageHandler packageHandler = new PackageHandler();
        List<Package> packageList = packageHandler.createPackageList(stringList);
        assertEquals(2, packageList.size());
    }

    @Test
    void givenListOfStringsReturnListOfCorrectPackages(){
        List<String> stringList = List.of("Turda,29,130,2017-09-01","Cluj,29,149,2017-09-01");
        Package expectedPackage1 = new Package("Turda", 29, 130, LocalDate.parse("2017-09-01"));
        Package expectedPackage2 = new Package("Cluj", 29, 149, LocalDate.parse("2017-09-01"));
        PackageHandler packageHandler = new PackageHandler();
        List<Package> packageList = packageHandler.createPackageList(stringList);
        assertEquals(expectedPackage1, packageList.get(0));
        assertEquals(expectedPackage2, packageList.get(1));
    }

    @Test
    void givenEmptyListOfStringsReturnListOfCorrectPackages(){
        List<String> stringList = new ArrayList<>();
        PackageHandler packageHandler = new PackageHandler();
        Exception exception = assertThrows(BusinessException.class, () -> packageHandler.createPackageList(stringList));
        assertEquals("Null or empty list of strings provided", exception.getMessage());
    }

    @Test
    void givenWrongDataThrowsException(){
        List<String> stringList = null;
        PackageHandler packageHandler = new PackageHandler();
        Exception exception = assertThrows(BusinessException.class, () -> packageHandler.createPackageList(stringList));
        assertEquals("Null or empty list of strings provided", exception.getMessage());
    }

    @Test
    void givenPackageListExpectSortedByDateAndDestination(){
        Package package1 = new Package("Turda", 29, 130, LocalDate.parse("2017-09-01"));
        Package package2 = new Package("Mures", 29, 130, LocalDate.parse("2017-09-01"));
        Package package3 = new Package("Cluj", 29, 130, LocalDate.parse("2017-09-02"));
        List<Package> sortedPackagesList = new PackageHandler().sortPackagesByDate(List.of(package1, package2, package3));
        assertEquals(package2, sortedPackagesList.get(0));
        assertEquals(package1, sortedPackagesList.get(1));
        assertEquals(package3, sortedPackagesList.get(2));
    }

}
