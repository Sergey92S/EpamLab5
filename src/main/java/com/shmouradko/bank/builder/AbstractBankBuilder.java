package com.shmouradko.bank.builder;

import com.shmouradko.bank.entity.Bank;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Revotech on 21.11.2016.
 */
public abstract class AbstractBankBuilder {
    static Logger logger = LogManager.getLogger();
    protected List<Bank> bank;

    public AbstractBankBuilder() {
        bank = new ArrayList<>();
    }

    public List<Bank> getBank() {
        return bank;
    }

    abstract public void buildSetBank(String fileName);
}
