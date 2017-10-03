package ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline;

/**
 * Created by Sergey-PC on 03.10.2017.
 */

public class CardInfo {
    private String mCvv, mMonth, mYear, mCardType, cardNum;

    public String getCvv() {
        return mCvv;
    }

    public void setCvv(String cvv) {
        mCvv = cvv;
    }

    public String getMonth() {
        return mMonth;
    }

    public void setMonth(String month) {
        mMonth = month;
    }

    public String getYear() {
        return mYear;
    }

    public void setYear(String year) {
        mYear = year;
    }

    public String getCardType() {
        return mCardType;
    }

    public void setCardType(String cardType) {
        mCardType = cardType;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @Override
    public String toString() {
        return "Card type: " + mCardType + ";\n" +
                "Expiration date: " + "\n" +
                "  Month: " + mMonth + ";\n" +
                "  Year: " + mYear + ";\n" +
                "CVV: " + mCvv + ";\n" +
                "Card numbers: " + cardNum +";\n";
    }
}

