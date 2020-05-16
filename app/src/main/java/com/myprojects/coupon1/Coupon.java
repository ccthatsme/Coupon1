package com.myprojects.coupon1;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class Coupon implements Parcelable {


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

    protected Coupon(Parcel in) {
        category = in.readString();
        couponImage = in.readParcelable(Bitmap.class.getClassLoader());
        description = in.readString();
    }

    public static final Creator<Coupon> CREATOR = new Creator<Coupon>() {
        @Override
        public Coupon createFromParcel(Parcel in) {
            return new Coupon(in);
        }

        @Override
        public Coupon[] newArray(int size) {
            return new Coupon[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(category);
        dest.writeParcelable(couponImage, flags);
        dest.writeString(description);
    }
}
