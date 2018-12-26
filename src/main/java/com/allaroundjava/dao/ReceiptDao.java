package com.allaroundjava.dao;

import com.allaroundjava.model.Receipt;

import javax.persistence.EntityManagerFactory;

public class ReceiptDao extends BaseDao<Receipt> {
    ReceiptDao(EntityManagerFactory emf) {
        super(Receipt.class, emf);
    }
}
