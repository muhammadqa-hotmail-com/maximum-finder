#!/bin/bash
# Adjust SPARK_HOME & PROJECT_HOME according to your environment
SPARK_HOME=~/apps/spark-2.4.6-bin-hadoop2.7
PROJECT_HOME=~/apps/maximum-finder

# The following knobs need to be adjusted when we run on spark cluster
$SPARK_HOME/bin/spark-submit \
--master local[2] \
--driver-memory 2G \
--executor-memory 1G \
--total-executor-cores 2 \
--executor-cores 1 \
--class com.example.maxfinder.MaximumIntegerFinder \
$PROJECT_HOME/target/maximum-finder-1.0-SNAPSHOT-jar-with-dependencies.jar \
$PROJECT_HOME/src/test/resources/sample.txt \
2
