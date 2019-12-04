package com.bsuir.tritpo.fly.models;

import java.io.Serializable;
import java.util.List;

public class Babki implements Serializable {
    private List<Currency> currencies;

    public Babki() {
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }
}
