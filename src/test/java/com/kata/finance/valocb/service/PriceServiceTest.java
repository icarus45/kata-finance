package com.kata.finance.valocb.service;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class PriceServiceTest {

    @Test
    void readPricesFile() throws IOException {
        ReadInputFileTest.readProductFile();
    }
}