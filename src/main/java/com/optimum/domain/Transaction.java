package com.optimum.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by ashishyog on 14-06-2019.
 */
@Document(collection = "transactions")
@Getter
@Setter
public class Transaction {
    private String transactionId;
    private String userName;
    private String paymentMode;
    private Double amount;
}