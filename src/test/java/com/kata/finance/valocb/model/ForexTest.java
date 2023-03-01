package com.kata.finance.valocb.model;

import com.kata.finance.valocb.service.ReadInputFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForexTest {
    Forex forex;

    @BeforeEach
    public void init() {
         forex = new Forex();
         forex.setOtherForex("EUR");
         forex.setEurForex("USD");
         forex.setParity(2);
    }

    @Test
    void getEurForex() {
        assertNotNull(forex);
        assertEquals("EUR",forex.getEurForex());
    }

    @Test
    void getOtherForex() {
        assertNotNull(forex);
        assertEquals("USD",forex.getOtherForex());
    }

    @Test
    void getParity() {
        assertNotNull(forex);
        assertEquals(2,forex.getParity());
    }

}