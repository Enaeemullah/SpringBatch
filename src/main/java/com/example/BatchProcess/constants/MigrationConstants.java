package com.example.BatchProcess.constants;

import java.sql.Date;
import java.time.LocalDate;

public interface MigrationConstants {

	// MS Sql Connection
    String SERVER_NAME = "MFSYS-DEV-260";
    String DB_NAME = "kcbl_latest";
    String USER = "sa";
    String PASSWORD = "mfsys@123";
    
    
    String MYSQL_SERVER_NAME = "MFSYS-DEV-260";
    String MYSQL_LOAN_DB_NAME = "loan";
    String MYSQL_DEPOSIT_DB_NAME = "deposit";
    String MYSQL_USER = "root";
    String MYSQL_PASSWORD = "root";
    
    String POR_ORGACODE = "0003";
    
    LocalDate MIGRATION_DATE = LocalDate.of(2024, 04, 26);
    
    // URL
    String LEGACY_URL = "/migrate/legacy/kcbl";
    String CIIHIVE_MASTER_CONFIG_URL = "/migrate/ciihive/master/confi/kcbl";
    
    String LEGACY_SIGNATURE_URL = "/migrate/legacy/kcbl";

    
    //DMPro
    String DMPRO_URL = "/migrate/dmpro";

    String MASTER_CFG_DEPOSIT = "/deposit";
    String MASTER_CFG_TDR = "/tdr";
    String MASTER_CFG_LOAN = "/loan";
    String MASTER_CFG_ADDRESS = "/address";
    String MASTER_CFG_CITY = "/city";
    String MASTER_CFG_CSTY = "/csty";
    String MASTER_CFG_GENDER = "/gender";
    String MASTER_CFG_DISTT = "/distt";
    String MASTER_CFG_PROV = "/province";
    String MASTER_CFG_PURP = "/purpose";
    String MASTER_CFG_BRANCH = "/branch";
    String MASTER_CFG_VILLAGE = "/village";
    String MASTER_CFG_LOANCHARGES = "/loancharges";
    String MASTER_CFG_DEPOSITCHARGES = "/depositcharges";
    
    //Customers AND accounts
    String CRM = "/crm";
    String LOAN = "/loan";
    String DEPOSIT = "/deposit";
    String TDR = "/tdr";
    String ADDRESS = "/address";
    String IDEN = "/identifier";
    String GL = "/gl";
    String SIGNATURE = "/signature";
    
    // Chequebooks
    String CHEQUEBOOKS = "/chequebook";
    String USED_CHEQUEBOOK = "/chequebook/usedchequebooks";
    String ISSUED_CHEQUEBOOK = "/chequebook/issuedchequebooks";
    String REGISTER_CHEQUEBOOK = "/chequebook/registerchequebooks";
    String STOPPED_CHEQUEBOOK = "/chequebook/stoppedchequebooks";
    
    
    //Account Balance
    String ACCOUNT_BALANCE = "/deposit/accountbalance";
    
    String RF_PRODUCT = "303";
    
}
