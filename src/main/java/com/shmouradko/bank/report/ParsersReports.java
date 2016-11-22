package com.shmouradko.bank.report;

import com.shmouradko.bank.entity.Bank;
import com.shmouradko.bank.entity.BankDeposit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Created by Revotech on 21.11.2016.
 */
public class ParsersReports {
    static Logger logger = LogManager.getLogger();

    public static void report(String typeOfParser, List<Bank> bank) {
        logger.info("**********************" + typeOfParser
                + "-parsing, building set of objects Bank"
                + "**************************\n");
        for (Bank currentBank : bank) {
            logger.info(currentBank.toString());
            logger.info("Depositor's name:");
            logger.info(currentBank.depositor.toString());
            logger.info("Bank deposit information:");
            for (BankDeposit currentBankDeposit : currentBank.bankDepositList) {
                logger.info(currentBankDeposit.toString());
            }
        }
    }

}
