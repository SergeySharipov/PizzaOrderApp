package ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.Order;
import ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.R;

public class FinalActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finall);

        String message1 = getString(R.string.final_message1);
        String message2 = getString(R.string.final_message2);
        message1 = message1.replace(getString(R.string.replace_in_final_mes1), Order.getCustomerName(this));
        message2 = message2.replace(getString(R.string.replace_in_final_mes2), Order.getPizzaType(this));

        ((TextView) findViewById(R.id.text)).setText(message1 + '\n' + message2);

        findViewById(R.id.new_order_but).setOnClickListener(this);

        findViewById(R.id.exit_but).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.new_order_but:
                Intent intent = new Intent(FinalActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                break;
            case R.id.exit_but:
                finish();
                System.exit(0);
                break;
        }
    }
}