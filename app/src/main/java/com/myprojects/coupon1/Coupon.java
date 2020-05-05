package com.myprojects.coupon1;

import android.graphics.Bitmap;

public class Coupon {


    private String category;
    private Bitmap couponImage;
    private String description;

    public Coupon(String category, Bitmap couponImage, String description) {
        this.category = category;
        this.couponImage = couponImage;
        this.description = description;
    }

    public Coupon() {
        super();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Bitmap getCouponImage() {
        return couponImage;
    }

    public void setCouponImage(Bitmap couponImage) {
        this.couponImage = couponImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "category='" + category + '\'' +
                ", couponImage=" + couponImage +
                ", description='" + description + '\'' +
                '}';
    }
}
