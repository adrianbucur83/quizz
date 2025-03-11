package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PackageHandler packageHandler = new PackageHandler();
        System.out.println(packageHandler.getPackagesFromFile());
    }
}
