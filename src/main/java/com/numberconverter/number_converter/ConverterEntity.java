package com.numberconverter.number_converter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class ConverterEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private Integer input;
    private String result;
    private String conversionType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setInput(Integer input) {
        this.input = input;
    }

    public void setOutput(String result) {
        this.result = result;
    }

    public void setConversionType(String conversionType) {
        this.conversionType = conversionType;
    }

    public Integer getInput() {
        return input;
    }

    public String getOutput() {
        return result;
    }

    public String getConversionType() {
        return conversionType;
    }
}
