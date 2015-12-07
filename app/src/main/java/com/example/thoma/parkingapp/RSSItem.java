package com.example.thoma.parkingapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by thoma on 11/16/2015.
 */
public class RSSItem {
    private String name = null;
    private String address = null;
    private String contactInfo = null;
    private String longitude = null;
    private String latitude = null;
    private String availableCapacity = null;


    public void setName(String name) {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }

    public void setContactInfo(String contactInfo)
    {
        this.contactInfo = contactInfo;
    }

    public String getContactInfo()
    {
        return contactInfo;
    }

    public void SetLongitude(String longitude)
    {
        this.longitude = longitude;
    }

    public String getLongitude()
    {

        return longitude;
    }

    public void SetLatitude(String latitude)
    {
        this.latitude = latitude;
    }

    public String getLatitude()
    {

        return latitude;
    }

    public void SetCapacity(String availableCapacity)
    {
        this.availableCapacity = availableCapacity;
    }

    public String getAvailableCapacity()
    {

        return longitude;
    }



}
