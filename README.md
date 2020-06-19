# Sample Spark Program To Find Maximum Number From Integer Array 
## Introduction
Finds maximum integer value from file containing list of integers
## Details
 Program expects the following two parameters being passed as args array:
- args[0] - text file path (file contains list of integers - each value is expected to be on a new line)
- args[1] - number of partitions for text file path

### Pre conditions:
 - Current implementation assumes that text file contains only integers. If this assumption
    is not correct then appropriate checks need to be added to discard non-integer
    values
### Post conditions:
 - Look for "Found max value" in logs to determine max value   

## Build & Run
### Build
```mvn clean install```
### Run
```sh scripts/spark_submit.sh```


