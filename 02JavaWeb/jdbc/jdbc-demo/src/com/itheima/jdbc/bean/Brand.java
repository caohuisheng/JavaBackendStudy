package com.itheima.jdbc.bean;

public class Brand {
    private String brandName;
    private String companyName;
    private int ordered;
    private String description;
    private int status;

    public Brand(String brandName, String companyName, int ordered, String description, int status) {
        this.brandName = brandName;
        this.companyName = companyName;
        this.ordered = ordered;
        this.description = description;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
