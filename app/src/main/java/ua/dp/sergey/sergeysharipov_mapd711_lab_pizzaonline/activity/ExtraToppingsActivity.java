package ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.Order;
import ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.R;

public class ExtraToppingsActivity extends AppCompatActivity implements View.OnClickListener {

    ListView mExtraTopListView;
    String[] mStrExtraToppings;
    SparseBooleanArray sparseBooleanArray;

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
        setContentView(R.layout.activity_extra_toppings);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mStrExtraToppings = getResources().getStringArray(R.array.extra_toppings);

        mExtraTopListView = (ListView) findViewById(R.id.extra_top_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (ExtraToppingsActivity.this,
                        android.R.layout.simple_list_item_multiple_choice,
                        android.R.id.text1, mStrExtraToppings);

        mExtraTopListView.setAdapter(adapter);

        findViewById(R.id.continue_but).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.continue_but:
                onContinueButClick();
                break;
        }
    }

    private void onContinueButClick() {
        sparseBooleanArray = mExtraTopListView.getCheckedItemPositions();

        String ValueHolder = "";

        int i = 0;

        while (i < sparseBooleanArray.size()) {
            if (sparseBooleanArray.valueAt(i)) {
                if (i < sparseBooleanArray.size() - 1)
                    ValueHolder += mStrExtraToppings[i] + ", ";
                else ValueHolder += mStrExtraToppings[i];
            }
            i++;
        }

        Order.setPizzaExtraToppings(this, ValueHolder);

        Intent intent = new Intent(ExtraToppingsActivity.this, CustomerInfoActivity.class);
        startActivity(intent);
    }
}

