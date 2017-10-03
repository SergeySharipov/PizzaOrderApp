package ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.CardInfo;
import ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.CustomerInfo;
import ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.Order;
import ua.dp.sergey.sergeysharipov_mapd711_lab_pizzaonline.R;

public class CustomerInfoActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mName;
    private EditText mAddress;
    private EditText mPostalCode;
    private EditText mTelephoneNumber;
    private EditText mCvv;
    private EditText mCardNum;

    private RadioGroup mCardTypeRadioGroup;
    private RadioButton mCreditRadioBut;

    private Spinner mProvinceSpinner;
    private Spinner mMonthSpinner;
    private Spinner mYearSpinner;

    private boolean mNoError = true;

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
        setContentView(R.layout.activity_customer_info);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mName = (EditText) findViewById(R.id.name);
        mAddress = (EditText) findViewById(R.id.address);
        mPostalCode = (EditText) findViewById(R.id.postal_code);
        mTelephoneNumber = (EditText) findViewById(R.id.telephone_number);
        mCvv = ((EditText) findViewById(R.id.cvv));
        mCardNum = ((EditText) findViewById(R.id.card_num));
        mCardTypeRadioGroup = (RadioGroup) findViewById(R.id.card_type_radio_group);
        mCreditRadioBut = (RadioButton)findViewById(R.id.credit);
        mProvinceSpinner = (Spinner) findViewById(R.id.provinceSpinner);
        mMonthSpinner = (Spinner) findViewById(R.id.monthSpinner);
        mYearSpinner = (Spinner) findViewById(R.id.yearSpinner);

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

    private void checkData(){
        mNoError = true;

        if(TextUtils.isEmpty(mName.getText())) {
            mName.setError("Write name");
            mNoError =false;
        } else if(TextUtils.isEmpty(mAddress.getText())) {
            mAddress.setError("Write address");
            mNoError =false;
        }else if(mPostalCode.getText().length()<6) {
            mPostalCode.setError("Need 6 symbols");
            mNoError =false;
        }else if(TextUtils.isEmpty(mTelephoneNumber.getText())) {
            mTelephoneNumber.setError("Write telephone number");
            mNoError =false;
        }else if(mCardNum.getText().length()<16) {
            mCardNum.setError("Write 16 numbers");
            mNoError =false;
        } else if(mCvv.getText().length()<3) {
            mCvv.setError("Write 3 numbers");
            mNoError =false;
        }else if(mCardTypeRadioGroup.getCheckedRadioButtonId()==-1) {
            mCreditRadioBut.setError("Select card type");
            mNoError =false;
        }
    }

    private void onContinueButClick() {
        checkData();

        final String customerName = mName.getText().toString();

        CustomerInfo customerInfo = new CustomerInfo();

        customerInfo.setName(customerName);
        customerInfo.setAddress(mAddress.getText().toString());
        customerInfo.setPostalCode(mPostalCode.getText().toString());
        customerInfo.setTelephoneNumber(mTelephoneNumber.getText().toString());

        customerInfo.setProvince(mProvinceSpinner.getSelectedItem().toString());

        CardInfo cardInfo = new CardInfo();

        cardInfo.setCvv(mCvv.getText().toString());

        cardInfo.setCardNum(mCardNum.getText().toString());

        cardInfo.setMonth(mMonthSpinner.getSelectedItem().toString());
        cardInfo.setYear(mYearSpinner.getSelectedItem().toString());

        switch (mCardTypeRadioGroup.getCheckedRadioButtonId()) {
            case R.id.debit:
                cardInfo.setCardType(getString(R.string.debit));
                break;
            case R.id.credit:
                cardInfo.setCardType(getString(R.string.credit));
                break;
        }

        if(mNoError) {
            Order.setCustomerName(this, customerName);
            Order.setCustomerInfo(CustomerInfoActivity.this, customerInfo.toString());
            Order.setCardInfo(CustomerInfoActivity.this, cardInfo.toString());

            Intent intent = new Intent(CustomerInfoActivity.this, ConfirmOrderActivity.class);
            startActivity(intent);
        }
    }
}
