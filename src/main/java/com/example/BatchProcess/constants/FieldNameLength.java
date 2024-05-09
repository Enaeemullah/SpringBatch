package com.example.BatchProcess.constants;


public interface FieldNameLength {

	String CODE_1 = "VARCHAR(1)";
	String CODE_2 = "VARCHAR(2)";
	String CODE_3 = "VARCHAR(3)";
	String CODE_4 = "VARCHAR(4)";
	String CODE_5 = "VARCHAR(5)";
	String CODE_6 = "VARCHAR(6)";
	String CODE_7 = "VARCHAR(7)";
	String CODE_10 = "VARCHAR(10)";
	String CODE_12 = "VARCHAR(12)";
	String CODE_20 = "VARCHAR(20)";
	String CODE_IBAN = "VARCHAR(24)";
	String CODE_30 = "VARCHAR(30)";
	String CODE_50 = "VARCHAR(50)";
	String CODE_100 = "VARCHAR(100)";
	String CODE_150 = "VARCHAR(150)";
	String CODE_200 = "VARCHAR(200)";
	String CODE_500 = "VARCHAR(500)";
	
	String DESCRIPTION_LONG = "VARCHAR(40)";
	String DESCRIPTION_SHORT = "VARCHAR(20)";
	String BOOLEAN_BIT = "TINYINT(1)";
	String AMOUNT_REAL = "DECIMAL(20,6)";
	String AMOUNT_INT = "DECIMAL(20,0)";
	String RATE = "DECIMAL(3,2)";
	String DECIMAL = "DECIMAL(7,0)";


	// for Binary data
	String SIGNATURE_LENGTH = "LONGBLOB";
	
	String DATE = "DATE";
	String DATETIME = "DATETIME";
	String TIMESTAMP = "TIMESTAMP";
	String TIMESTAMP_NULLABLE = "TIMESTAMP NULL";
	String PASSWORD = "VARCHAR(50)";

	String BIGINT = "BIGINT";
	String INT = "INT";
	String RATE_REAL = "DECIMAL(20,10)";
	String XML = "TEXT";
	String TEXT = "TEXT";
	String DAYS = INT;
	String TINYINT = "TINYINT";

	String FISCALYEAR = "INT(4)";

}
