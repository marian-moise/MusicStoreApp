package com.project.music_store.dto;

import javax.persistence.Column;
import java.math.BigDecimal;

public class InstrumentDTO {


    private String name;
    private BigDecimal unitPrice;
    private String concurrency;
    private String imageUrl;

    public InstrumentDTO() {
    }

    public InstrumentDTO(String name, BigDecimal unitPrice, String concurrency, String imageUrl) {

        this.name = name;
        this.unitPrice = unitPrice;
        this.concurrency = concurrency;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getConcurrency() {
        return concurrency;
    }

    public void setConcurrency(String concurrency) {
        this.concurrency = concurrency;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
