-- Create database if it doesn't exist
CREATE DATABASE IF NOT EXISTS bank;

-- Use the bank database
USE bank;

-- Create employee table if it doesn't exist
CREATE TABLE IF NOT EXISTS employee (
    empid BIGINT PRIMARY KEY,
    ename VARCHAR(100) NOT NULL,
    salary DOUBLE NOT NULL
);
