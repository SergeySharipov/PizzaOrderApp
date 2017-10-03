package ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline;

import android.content.Context;

/**
 * Created by Sergey-PC on 03.10.2017.
 */

public class Order {

    private static final String PIZZA_TYPE =
            "ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.pizza_type";
    private static final String PIZZA_SIZE =
            "ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.pizza_size";
    private static final String PIZZA_EXTRA_TOPPINGS =
            "ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.pizza_extra_toppings";
    private static final String CUSTOMER_NAME =
            "ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.customer_name";
    private static final String CUSTOMER_INFO =
            "ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.customer_info";
    private static final String CARD_INFO =
            "ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.card_info";

    public static void setPizzaType(Context context, String value) {
        AppSharedPref.put(context, PIZZA_TYPE, value);
    }

    public static void setPizzaSize(Context context, String value) {
        AppSharedPref.put(context, PIZZA_SIZE, value);
    }

    public static void setPizzaExtraToppings(Context context, String value) {
        AppSharedPref.put(context, PIZZA_EXTRA_TOPPINGS, value);
    }

    public static void setCustomerName(Context context, String value) {
        AppSharedPref.put(context, CUSTOMER_NAME, value);
    }

    public static void setCustomerInfo(Context context, String value) {
        AppSharedPref.put(context, CUSTOMER_INFO, value);
    }

    public static void setCardInfo(Context context, String value) {
        AppSharedPref.put(context, CARD_INFO, value);
    }

    public static String getPizzaType(Context context) {
        return AppSharedPref.getString(context, PIZZA_TYPE);
    }

    public static String getPizzaSize(Context context) {
        return AppSharedPref.getString(context, PIZZA_SIZE);
    }

    public static String getPizzaExtraToppings(Context context) {
        return AppSharedPref.getString(context, PIZZA_EXTRA_TOPPINGS);
    }

    public static String getCustomerName(Context context) {
        return AppSharedPref.getString(context, CUSTOMER_NAME);
    }

    public static String getCustomerInfo(Context context) {
        return AppSharedPref.getString(context, CUSTOMER_INFO);
    }

    public static String getCardInfo(Context context) {
        return AppSharedPref.getString(context, CARD_INFO);
    }

    public static String toString(Context context) {
        return "Pizza type: " + getPizzaType(context) + ";\n" +
                "Pizza size: " + getPizzaSize(context) + ";\n" +
                "Extra toppings: " + getPizzaExtraToppings(context) + ";\n\n" +
                getCustomerInfo(context) + '\n' +
                getCardInfo(context) + '\n';
    }
}
