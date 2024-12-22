@echo off
javac .\Jos.java
if not exist "test.class" (
    javac .\test.java
)
java Jos test.class