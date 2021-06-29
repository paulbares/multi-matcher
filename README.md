# Fork

This fork uses maven instead of grade and has all dependencies up-to-date (as of today; 2021-06-29).

To compile:
```
mvn clean install
```
This creates a jar located at `benchmarks/target/benchmarks-jmh.jar` to be launched to run the JMH benchmarks.
```
java -jar benchmarks/target/benchmarks-jmh.jar
```
To run a single benchmark:
```
java -jar benchmarks/target/benchmarks-jmh.jar LogicalAggregationBenchmark
```

## Dependencies

```
[INFO] ------------------< me.paulbares:multi-matcher-root >-------------------
[INFO] Building multi-matcher-root 1.0.0-SNAPSHOT                         [1/3]
[INFO] --------------------------------[ pom ]---------------------------------
[INFO]
[INFO] --- maven-dependency-plugin:2.8:tree (default-cli) @ multi-matcher-root ---
[INFO] me.paulbares:multi-matcher-root:pom:1.0.0-SNAPSHOT
[INFO]
[INFO] ------------------< me.paulbares:multi-matcher-core >-------------------
[INFO] Building multi-matcher-core 1.0.0-SNAPSHOT                         [2/3]
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-dependency-plugin:2.8:tree (default-cli) @ multi-matcher-core ---
[INFO] me.paulbares:multi-matcher-core:jar:1.0.0-SNAPSHOT
[INFO] +- org.roaringbitmap:RoaringBitmap:jar:0.9.15:compile
[INFO] |  \- org.roaringbitmap:shims:jar:0.9.15:runtime
[INFO] +- it.unimi.dsi:fastutil:jar:8.5.4:compile
[INFO] |  \- it.unimi.dsi:fastutil-extra:jar:8.5.4:compile
[INFO] |     \- it.unimi.dsi:fastutil-core:jar:8.5.4:compile
[INFO] +- com.fasterxml.jackson.core:jackson-databind:jar:2.12.3:compile
[INFO] |  +- com.fasterxml.jackson.core:jackson-annotations:jar:2.12.3:compile
[INFO] |  \- com.fasterxml.jackson.core:jackson-core:jar:2.12.3:compile
[INFO] +- com.google.guava:guava:jar:30.1.1-jre:test
[INFO] |  +- com.google.guava:failureaccess:jar:1.0.1:test
[INFO] |  +- com.google.guava:listenablefuture:jar:9999.0-empty-to-avoid-conflict-with-guava:test
[INFO] |  +- com.google.code.findbugs:jsr305:jar:3.0.2:test
[INFO] |  +- org.checkerframework:checker-qual:jar:3.8.0:test
[INFO] |  +- com.google.errorprone:error_prone_annotations:jar:2.5.1:test
[INFO] |  \- com.google.j2objc:j2objc-annotations:jar:1.3:test
[INFO] +- com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:jar:2.12.3:test
[INFO] |  \- org.yaml:snakeyaml:jar:1.27:test
[INFO] \- org.junit.jupiter:junit-jupiter:jar:5.7.2:test
[INFO]    +- org.junit.jupiter:junit-jupiter-api:jar:5.7.2:test
[INFO]    |  +- org.apiguardian:apiguardian-api:jar:1.1.0:test
[INFO]    |  +- org.opentest4j:opentest4j:jar:1.2.0:test
[INFO]    |  \- org.junit.platform:junit-platform-commons:jar:1.7.2:test
[INFO]    +- org.junit.jupiter:junit-jupiter-params:jar:5.7.2:test
[INFO]    \- org.junit.jupiter:junit-jupiter-engine:jar:5.7.2:test
[INFO]       \- org.junit.platform:junit-platform-engine:jar:1.7.2:test
[INFO]
[INFO] ----------------------< me.paulbares:benchmarks >-----------------------
[INFO] Building benchmarks 1.0.0-SNAPSHOT                                 [3/3]
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-dependency-plugin:2.8:tree (default-cli) @ benchmarks ---
[INFO] me.paulbares:benchmarks:jar:1.0.0-SNAPSHOT
[INFO] +- me.paulbares:multi-matcher-core:jar:1.0.0-SNAPSHOT:compile
[INFO] |  +- org.roaringbitmap:RoaringBitmap:jar:0.9.15:compile
[INFO] |  |  \- org.roaringbitmap:shims:jar:0.9.15:runtime
[INFO] |  +- it.unimi.dsi:fastutil:jar:8.5.4:compile
[INFO] |  |  \- it.unimi.dsi:fastutil-extra:jar:8.5.4:compile
[INFO] |  |     \- it.unimi.dsi:fastutil-core:jar:8.5.4:compile
[INFO] |  \- com.fasterxml.jackson.core:jackson-databind:jar:2.12.3:compile
[INFO] |     +- com.fasterxml.jackson.core:jackson-annotations:jar:2.12.3:compile
[INFO] |     \- com.fasterxml.jackson.core:jackson-core:jar:2.12.3:compile
[INFO] +- org.openjdk.jmh:jmh-core:jar:1.32:compile
[INFO] |  +- net.sf.jopt-simple:jopt-simple:jar:4.6:compile
[INFO] |  \- org.apache.commons:commons-math3:jar:3.2:compile
[INFO] +- org.openjdk.jmh:jmh-generator-annprocess:jar:1.32:provided
[INFO] \- org.openjdk.jol:jol-core:jar:0.16:compile
[INFO] ------------------------------------------------------------------------
```

# multi-matcher
[![Build Status](https://travis-ci.org/richardstartin/multi-matcher.svg?branch=master)](https://travis-ci.org/richardstartin/multi-matcher)
[![Coverage Status](https://coveralls.io/repos/github/richardstartin/bitrules/badge.svg?branch=master)](https://coveralls.io/github/richardstartin/multi-matcher?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/uk.co.openkappa/bitrules/badge.svg)](https://maven-badges.herokuapp.com/maven-central/uk.co.openkappa/bitrules)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Javadoc](https://javadoc-badge.appspot.com/uk.co.openkappa/multi-matcher.svg?label=javadoc)](http://www.javadoc.io/doc/uk.co.openkappa/multi-matcher)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/richardstartin/multi-matcher.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/richardstartin/multi-matcher/alerts/)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/richardstartin/multi-matcher.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/richardstartin/multi-matcher/context:java)

I have often needed to implement tedious classification logic in data processing projects. The requirements are often ambiguous to the extent that it would be difficult to implement them even in SQL, with aspects such as fallback and overlap. This logic often ends up expressed as large blocks of nested if statements which are hard to read or modify and perform poorly. This small project aims to make such classification logic easier, and improve performance too. 

# usage

Build a generic classification engine
```java
    Classifier<Product, String> classifier = Classifier.<String, Product, String>builder(
                Schema.<String, Product, String>create()
                        .withAttribute("productType", Product::getProductType)
                        .withAttribute("issueDate", Product::getIssueDate, Comparator.naturalOrder().reversed())
                        .withAttribute("productName", Product::getProductName)
                        .withAttribute("availability", Product::getAvailability)
                        .withAttribute("discountedPrice", value -> 0.2 * value.getPrice())
                ).build(Arrays.asList(
                    MatchingConstraint.<String, String>named("rule1") 
                            .eq("productType", "silk")
                            .startsWith("productName", "luxury")
                            .gt("discountedPrice", 1000)
                            .priority(0)
                            .classification("EXPENSIVE_LUXURY_PRODUCTS")
                            .build(),
                    MatchingConstraint.<String, String>named("rule2")
                            .eq("productType", "caviar")
                            .gt("discountedPrice", 100)
                            .priority(1)
                            .classification("EXPENSIVE_LUXURY_PRODUCTS")
                            .build(),
                    MatchingConstraint.<String, String>anonymous()
                            .eq("productName", "baked beans")
                            .priority(2)
                            .classification("CHEAP_FOOD")
                            .build()
                )
            );
```

Classify

```java
  Product p = getProduct();
  String classification = classifier.classification(p).orElse("UNCLASSIFIED");
```
