package ru.ezhov.jpa.domain;

import org.junit.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.*;

public class OrderTest {

    private static final Logger LOG = LoggerFactory.getLogger(OrderTest.class.getName());

    private static EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        entityManagerFactory =
                Persistence.createEntityManagerFactory("ru.ezhov.jpa.test");
    }

    @Before
    public void setBeforeUp() throws Exception {
        entityManager = entityManagerFactory.createEntityManager();
    }

    @After
    public void setUpAfter() throws Exception {
        entityManager.close();
    }

    @AfterClass
    public static void setUpAfterClass() throws Exception {
        entityManagerFactory.close();
    }

    @Test
    public void selectAll() throws Exception {
        List<Order> orderList =
                entityManager.createQuery("SELECT o FROM Order o").getResultList();
        LOG.info(orderList.toString());
        assertFalse(orderList.isEmpty());
    }

}