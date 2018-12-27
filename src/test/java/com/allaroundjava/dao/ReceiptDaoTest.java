package com.allaroundjava.dao;

import com.allaroundjava.model.LineItem;
import com.allaroundjava.model.Receipt;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ReceiptDaoTest {
    private EntityManagerFactory emf;
    private Dao<Receipt> receiptDao;

    public ReceiptDaoTest() {
        this.emf = Persistence.createEntityManagerFactory("hibernateLogging");
        receiptDao = new ReceiptDao(emf);
    }

    @Test
    public void whenPersist_thenNoException() {
        LineItem strawberries = LineItem.getBuilder()
                .withItemName("strawberries")
                .withPrice(BigDecimal.TEN)
                .withQuantity(3)
                .build();
        LineItem yoghurt = LineItem.getBuilder()
                .withItemName("yoghurt")
                .withPrice(BigDecimal.ONE)
                .withQuantity(2)
                .build();

        Set<LineItem> lineItemsSet = new HashSet<>();
        lineItemsSet.add(strawberries);
        lineItemsSet.add(yoghurt);
        Receipt receipt = Receipt.newInstance(LocalDateTime.now(), lineItemsSet);
        receiptDao.persist(receipt);
    }

}