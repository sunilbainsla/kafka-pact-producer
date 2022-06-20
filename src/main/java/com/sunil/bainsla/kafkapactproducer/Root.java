package com.sunil.bainsla.kafkapactproducer;

import java.util.ArrayList;
import java.util.Date;

public class CreditorAccount {
    public String accountName;
    public String identification;
    public String schemeName;
}

public class Data {
    public String eventSource;
    public String eventName;
    public Data data;
    public String result;
    public Date timestamp;
    public Payment payment;
    public Metadata metadata;
}

public class DebtorAccount {
    public String accountName;
    public String identification;
    public String schemeName;
}

public class Error {
    public String code;
    public String description;
}

public class Metadata {
    public String predebited;
}

public class Payment {
    public String id;
    public String processingDate;
    public String currency;
    public String amount;
    public String transactionReferenceNumber;
    public DebtorAccount debtorAccount;
    public CreditorAccount creditorAccount;
    public String schemePaymentType;
    public String schemePaymentSubType;
    public String endToEndReference;
    public String paymentScheme;
    public String fpid;
}

public class Root {
    public String eventSource;
    public String eventName;
    public Data data;
    public String result;
    public ArrayList<Error> errors;
    public Date timestamp;
}

