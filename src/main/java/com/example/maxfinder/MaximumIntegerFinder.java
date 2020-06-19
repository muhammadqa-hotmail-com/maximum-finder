package com.example.maxfinder;

import com.example.maxfinder.utils.ArgumentChecker;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
/*
 Program expects the following two parameters passed as args array:
 args[0] - text file path (file contains list of integers - each value is expected to be on a new line)
 args[1] - number of partitions for text file path

 Pre conditions:
 1: Program assumes that text file contains only integers. If this assumption
    is not correct then appropriate checks need to be added to discard non-integer
    values
 */
public class MaximumIntegerFinder
{
    private static final Logger logger = LogManager.getLogger(MaximumIntegerFinder.class);

    public static void main( String[] args )
    {
        ArgumentChecker.checkUsage(args);

        logger.info( "Processing started" );

        //Extract arguments
        String filePath = args[0];//File containing list of integers
        int numberOfPartitions = Integer.parseInt(args[1]);//Number of partitions

        //Create spark context with default config
        SparkConf conf = new SparkConf();
        JavaSparkContext sc = new JavaSparkContext(conf);

        //Find maximum integer
        Integer maxValue = findMax(sc, filePath, numberOfPartitions);
        logger.info( "Found max value=" + maxValue);
        logger.info( "Processing completed" );

    }
    /*
    Finds maximum integer value in given file
     */
    private static int findMax(JavaSparkContext sc, String filePath, int numberOfPartitions) {
        JavaRDD<String> lines = sc.textFile(filePath, numberOfPartitions);
        Integer maxValue = lines.map(line -> Integer.parseInt(line)).reduce((v1, v2) -> Math.max(v1, v2));
        return maxValue;
    }

}
