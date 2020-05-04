package com.example.payment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mInputMoney;
    private EditText mInputInfo;
    private CheckBox mBankCardChkBx;
    private CheckBox mMobilePhoneChkBx;
    private CheckBox mCashAddressChkBx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    public void initViews() {
        mInputMoney = findViewById(R.id.inputMoney);
        mInputInfo = findViewById(R.id.inputInfo);
        Button mBtnPay = findViewById(R.id.btnPay);
        mBankCardChkBx = findViewById(R.id.bankCardChkBx);
        mMobilePhoneChkBx = findViewById(R.id.mobilePhoneChkBx);
        mCashAddressChkBx = findViewById(R.id.cashAddressChkBx);
        mBankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mMobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mCashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mBtnPay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mInputMoney.getText().length() == 0
                        || mInputInfo.getText().length() == 0) {
                    Toast.makeText(MainActivity.this,
                            "Заполните форму", Toast.LENGTH_LONG).show();
                } else {
                    StringBuilder outMessage = new StringBuilder();
                    outMessage.append((getString(R.string.inputMoney) + ": "
                            + mInputMoney.getText().toString())).append("\n")
                            .append(getString(R.string.inputInfo) + ": "
                                    + mInputInfo.getText().toString()).append("\n")
                            .append(getString(R.string.bankCardChkBx) + ": "
                                    + mBankCardChkBx.isChecked()).append("\n")
                            .append(getString(R.string.mobilePhoneChkBx) + ": "
                                    + mMobilePhoneChkBx.isChecked()).append("\n")
                            .append(getString(R.string.cashAddressChkBx) + ": "
                                    + mCashAddressChkBx.isChecked()).append("\n");
                    Toast.makeText(MainActivity.this,
                            outMessage.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    CompoundButton.OnCheckedChangeListener checkedChangeListener =
            new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        switch (buttonView.getId()) {
                            case R.id.bankCardChkBx:
                                resetCheckBoxes();
                                mBankCardChkBx.setChecked(true);
                                mInputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                                break;
                            case R.id.mobilePhoneChkBx:
                                resetCheckBoxes();
                                mMobilePhoneChkBx.setChecked(true);
                                mInputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                                break;
                            case R.id.cashAddressChkBx:
                                resetCheckBoxes();
                                mCashAddressChkBx.setChecked(true);
                                mInputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                                break;
                            default:
                                
                        }
                    }
                }
            };

    private void resetCheckBoxes(){
        mBankCardChkBx.setChecked(false);
        mMobilePhoneChkBx.setChecked(false);
        mCashAddressChkBx.setChecked(false);
    }




}
