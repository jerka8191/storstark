package com.example.enstorstark;

public class PubDetail {

    private String label;
    private String value;

    public PubDetail(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String label() { return label; }
    public String value() { return value; }
}

