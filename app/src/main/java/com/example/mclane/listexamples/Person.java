package com.example.mclane.listexamples;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Created by per6 on 9/27/17.
 */

public class Person implements Parcelable, Comparable<Person>{

    private String name;
    private String desc;
    private int ranking;
    private int imageResourceID;

    public Person(String name, String desc, int imageResourceID, int ranking) {
        this.name = name;
        this.desc = desc;
        this.ranking = ranking;
        this.imageResourceID = imageResourceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public void setImageResourceID(int imageResourceID) {
        this.imageResourceID = imageResourceID;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String toString(){
        return name;
    }

    protected Person(Parcel in) {
        name = in.readString();
        desc = in.readString();
        ranking = in.readInt();
        imageResourceID = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(desc);
        dest.writeInt(ranking);
        dest.writeInt(imageResourceID);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };



    @Override
    public int compareTo(@NonNull Person person) {
        return ranking - person.getRanking();
    }
}