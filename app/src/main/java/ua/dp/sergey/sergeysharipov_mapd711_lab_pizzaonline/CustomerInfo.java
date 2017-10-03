package ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline;

/**
 * Created by Sergey-PC on 02.10.2017.
 */

public class CustomerInfo {
    private String mName, mAddress, mPostalCode, mTelephoneNumber, mProvince;

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public String getPostalCode() {
        return mPostalCode;
    }

    public void setPostalCode(String postalCode) {
        mPostalCode = postalCode;
    }

    public String getTelephoneNumber() {
        return mTelephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        mTelephoneNumber = telephoneNumber;
    }

    public String getProvince() {
        return mProvince;
    }

    public void setProvince(String province) {
        mProvince = province;
    }

    @Override
    public String toString() {
        return  "Name: " + mName + ";\n" +
                "Province: " + mProvince+ ";\n" +
                "Address: " + mAddress +";\n" +
                "Postal code: " + mPostalCode +";\n" +
                "Telephone number: " + mTelephoneNumber +";\n";
    }
}
