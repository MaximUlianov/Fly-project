package com.bsuir.tritpo.fly.models;

public class Currency {
    private String Code;
    private String Symbol;
    private String ThousandsSeparator;
    private String DecimalSeparator;
    private boolean SymbolOnLeft;
    private boolean SpaceBetweenAmountAndSymbol;
    private int RoundingCoefficient;
    private int DecimalDigits;

    public Currency() {
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getThousandsSeparator() {
        return ThousandsSeparator;
    }

    public void setThousandsSeparator(String thousandsSeparator) {
        ThousandsSeparator = thousandsSeparator;
    }

    public String getDecimalSeparator() {
        return DecimalSeparator;
    }

    public void setDecimalSeparator(String decimalSeparator) {
        DecimalSeparator = decimalSeparator;
    }

    public boolean isSymbolOnLeft() {
        return SymbolOnLeft;
    }

    public void setSymbolOnLeft(boolean symbolOnLeft) {
        SymbolOnLeft = symbolOnLeft;
    }

    public boolean isSpaceBetweenAmountAndSymbol() {
        return SpaceBetweenAmountAndSymbol;
    }

    public void setSpaceBetweenAmountAndSymbol(boolean spaceBetweenAmountAndSymbol) {
        SpaceBetweenAmountAndSymbol = spaceBetweenAmountAndSymbol;
    }

    public int getRoundingCoefficient() {
        return RoundingCoefficient;
    }

    public void setRoundingCoefficient(int roundingCoefficient) {
        RoundingCoefficient = roundingCoefficient;
    }

    public int getDecimalDigits() {
        return DecimalDigits;
    }

    public void setDecimalDigits(int decimalDigits) {
        DecimalDigits = decimalDigits;
    }
}
