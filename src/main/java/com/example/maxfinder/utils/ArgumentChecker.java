package com.example.maxfinder.utils;

import com.example.maxfinder.MaximumIntegerFinder;

public class ArgumentChecker {
    /*
    Makes sure that we have correct number of arguments
     */
    public static void checkUsage(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: " + MaximumIntegerFinder.class.getSimpleName()
                    + " <text file path> <number of partitions>");
            System.exit(1);
        }
    }

}
