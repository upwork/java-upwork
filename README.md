JAVA bindings for Upwork API (OAuth1) - DEPRECATED
============

[![License](https://img.shields.io/github/license/upwork/java-upwork)](http://www.apache.org/licenses/LICENSE-2.0.html)
[![GitHub release](https://img.shields.io/github/release/upwork/java-upwork.svg)](https://github.com/upwork/java-upwork/releases)
[![Build Status](https://github.com/upwork/java-upwork/workflows/build/badge.svg)](https://github.com/upwork/java-upwork/actions)

# Introduction
This project provides a set of resources of Upwork API from http://developers.upwork.com
 based on OAuth 1.0a.

# Features
These are the supported API resources:

* My Info
* Custom Payments
* Hiring
* Job and Freelancer Profile
* Search Jobs and Freelancers
* Organization
* Messages
* Time and Financial Reporting
* Metadata
* Snapshot
* Team
* Workd Diary
* Activities

# Support for Maven and others
Maven support is available via Maven Central Repository, e.g.
```
<dependency>
    <groupId>com.Upwork</groupId>
    <artifactId>api</artifactId>
    <version>1.1.0</version> <!-- update the version, the latest one is recommended -->
</dependency>
```

Please, check "Dependency Information" section at [maven page](http://search.maven.org/#artifactdetails%7Ccom.Upwork%7Capi%7C1.0.1%7Cjar) for other systems (like Apache Buildr, Apache Ivy, Gradle, etc)

# License

Copyright 2015 Upwork Corporation. All Rights Reserved.

java-upwork is licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

## SLA
The usage of this API is ruled by the Terms of Use at:

    https://developers.upwork.com/api-tos.html

## Example
See the `example` directory. To quickly run the example from the command line:

    cd example
    make
    make run

Make sure you've added consumer key and secret to the `example/upwork.properties`.
