package com.example.android.bucharestguide;

/**
 * Created by Eugen on 26-Feb-18.
 */

public class Location {
    private String mLocationName;
    private String mLocationShortDescription;
    private int mLocationImageResourceID;
    private String mLocationAddress;
    private String mLocationPhone;

    public Location(String name, String shortDescription, int imageID, String address, String phone){
        this.mLocationName = name;
        this.mLocationShortDescription = shortDescription;
        this.mLocationImageResourceID = imageID;
        this.mLocationAddress = address;
        this.mLocationPhone = phone;
    }

    public String getName(){
        return mLocationName;
    }
    public String getShortDescription(){
        return mLocationShortDescription;
    }
    public int getImageID(){
        return mLocationImageResourceID;
    }
    public String getAddress() { return mLocationAddress; }
    public String getPhone() { return mLocationPhone; }

    public final static String NAME_STRING = "name";
    public final static String ADDRESS_STRING = "address";
    public final static String PHONE_STRING = "phone";
    public final static String SHORT_DESCRIPTION_STRING = "short description";
    public final static String IMAGE_ID_STRING = "image ID";
}
