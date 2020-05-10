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
        actionBtn();
    }

    public void actionBtn() {
        Button mBtnPay = findViewById(R.id.btnPay);
        mBtnPay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (mInputMoney.getText().length() == 0
                        || mInputInfo.getText().length() == 0) {
                    Toast.makeText(MainActivity.this,
                            "Заполните форму", Toast.LENGTH_LONG).show();
                } else {
                    String outMessage = (getString(R.string.inputMoney) + ": "
                            + mInputMoney.getText().toString()) +
                            "\n" +
                            getString(R.string.inputInfo) + ": "
                            + mInputInfo.getText().toString() +
                            "\n" +
                            getString(R.string.bankCardChkBx) + ": "
                            + mBankCardChkBx.isChecked() +
                            "\n" +
                            getString(R.string.mobilePhoneChkBx) + ": "
                            + mMobilePhoneChkBx.isChecked() +
                            "\n" +
                            getString(R.string.cashAddressChkBx) + ": "
                            + mCashAddressChkBx.isChecked() +
                            "\n";
                    Toast.makeText(MainActivity.this,
                            outMessage, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void initViews() {
        mInputMoney = findViewById(R.id.inputMoney);
        mInputInfo = findViewById(R.id.inputInfo);
        mBankCardChkBx = findViewById(R.id.bankCardChkBx);
        mMobilePhoneChkBx = findViewById(R.id.mobilePhoneChkBx);
        mCashAddressChkBx = findViewById(R.id.cashAddressChkBx);
        mBankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mMobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mCashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);
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
