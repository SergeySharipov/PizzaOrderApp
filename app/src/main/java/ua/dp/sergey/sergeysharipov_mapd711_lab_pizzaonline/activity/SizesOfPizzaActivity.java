package ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.Order;
import ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.R;

public class SizesOfPizzaActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sizes_of_pizza);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        final RadioGroup pizzaSizeRadioGroup = (RadioGroup) findViewById(R.id.pizza_size_radio_group);

        findViewById(R.id.continue_but).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pizzaSize = "";
                switch (pizzaSizeRadioGroup.getCheckedRadioButtonId()) {
                    case R.id.small:
                        pizzaSize = getString(R.string.small);
                        break;
                    case R.id.medium:
                        pizzaSize = getString(R.string.medium);
                        break;
                    case R.id.large:
                        pizzaSize = getString(R.string.large);
                        break;
                    case R.id.extra_large:
                        pizzaSize = getString(R.string.extra_large);
                        break;
                }

                if (pizzaSize.length() > 1) {
                    Order.setPizzaSize(SizesOfPizzaActivity.this, pizzaSize);

                    Intent intent = new Intent(SizesOfPizzaActivity.this, ExtraToppingsActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(SizesOfPizzaActivity.this, "Select size", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}