package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PackageHandler {

    public List<Package> createPackageList(List<String> stringList) {
        if (stringList == null || stringList.isEmpty()) {
           throw new BusinessException("Null or empty list of strings provided");
        }
        List<Package> packageList = new ArrayList<>();
        for (String string: stringList) {
            Package aPackage = Package.createPackageFromStringData(string);
            packageList.add(aPackage);
        }
        return packageList;
    }

    public List<Package> getPackagesFromFile() {
        List<String>stringList = new FileHandler().readFile();
        return createPackageList(stringList);
    }

    public List<Package> sortPackagesByDate(List<Package> packageList) {
        return packageList
                .stream()
                .sorted(Comparator.comparing(Package::date).thenComparing(Package::destination))
                .toList();
    }
}
