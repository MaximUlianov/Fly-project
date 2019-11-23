package com.bsuir.tritpo.fly.models.api_models;

import java.io.Serializable;

public class Carrier implements Serializable {
    private int CarrierId;
    private String Name;

    public Carrier() {
    }

    public int getCarrierId() {
        return CarrierId;
    }

    public void setCarrierId(int carrierId) {
        CarrierId = carrierId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
