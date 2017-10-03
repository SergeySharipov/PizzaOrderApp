package ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.activity;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.AppSharedPref;
import ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.Order;
import ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_types_of_pizza, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String typeOfPizza="";

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.meat_supreme:
                typeOfPizza = "Meat supreme";
                break;
            case R.id.super_hawaiian:
                typeOfPizza = "Super hawaiian";
                break;
            case R.id.veggie:
                typeOfPizza = "Veggie";
                break;
            case R.id.mediterranean:
                typeOfPizza = "Mediterranean";
                break;
            case R.id.cheddar_supreme:
                typeOfPizza = "Cheddar supreme";
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        Order.setPizzaType(this,typeOfPizza);

        Intent intent = new Intent(MainActivity.this, SizesOfPizzaActivity.class);
        startActivity(intent);
        return true;
    }
}