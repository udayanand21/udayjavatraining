-- Fix the employee table to properly support AUTO_INCREMENT for eid
-- Run these commands in your MySQL client (MySQL Workbench, command line, etc.)

USE product;

-- Step 1: Drop the existing employee table
DROP TABLE IF EXISTS employee;

-- Step 2: Create the employee table with proper AUTO_INCREMENT
CREATE TABLE `employee` (
   `eid` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `ename` varchar(20) DEFAULT NULL,
   `salary` decimal(10,0) DEFAULT NULL,
   `email` varchar(50) DEFAULT NULL,
   `mobile` varchar(10) DEFAULT NULL,
   `doj` date DEFAULT NULL,
   `dob` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Step 3: Set the AUTO_INCREMENT to start at 1001
ALTER TABLE employee AUTO_INCREMENT = 1001;

-- Step 4: Verify the table structure is correct
DESCRIBE employee;

-- Step 5: Show the full CREATE TABLE statement to verify
SHOW CREATE TABLE employee;
