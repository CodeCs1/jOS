#!/bin/sh
javac Jos.java
if [ ! -f test.class ]; then
    javac test.java
fi
java Jos test.class