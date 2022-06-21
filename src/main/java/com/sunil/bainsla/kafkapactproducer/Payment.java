package com.sunil.bainsla.kafkapactproducer;

import lombok.Data;

@Data
public class Payment {
    String id;
    String data;
    String paymentDate;
    int amount;
    String name;
    String accountNumber;
}
