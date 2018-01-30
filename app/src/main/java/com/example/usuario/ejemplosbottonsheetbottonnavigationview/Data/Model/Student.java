package com.example.usuario.ejemplosbottonsheetbottonnavigationview.Data.Model;


import android.os.Parcel;
import android.os.Parcelable;

public class Student implements Parcelable {


    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    private  String name;
    private  String phone;
    private  String photoUrl;

    public Student(String name, String phone, String photoUrl) {
        this.name = name;
        this.phone = phone;
        this.photoUrl = photoUrl;
    }



    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(this.name);
        dest.writeString(this.phone);
        dest.writeString(this.photoUrl);
    }

    @SuppressWarnings("WeakerAccess")
    protected Student(Parcel in) {

        this.name = in.readString();
        this.phone = in.readString();
        this.photoUrl = in.readString();
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Student> CREATOR = new Parcelable.Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}