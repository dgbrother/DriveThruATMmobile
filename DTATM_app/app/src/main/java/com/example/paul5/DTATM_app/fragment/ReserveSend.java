package com.example.paul5.DTATM_app.fragment;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.paul5.DTATM_app.R;
import com.example.paul5.DTATM_app.SendInfo;

import static android.widget.AdapterView.*;

public class ReserveSend extends Fragment {
    String selected;
    EditText eSendAccount, eSendAmount;

    //송금하기
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_reserve_send, container, false);
        String[] accounts = {"508-11-052127-2", "508-11-123456-7"};

        final Spinner AccountSpinner = (Spinner) v.findViewById(R.id.spinner_account);
        AccountSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                selected = (String)AccountSpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });
        ArrayAdapter<String> spinneradapter = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item);
        spinneradapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        AccountSpinner.setAdapter(spinneradapter);
        spinneradapter.addAll(accounts);

        eSendAccount = v.findViewById(R.id.send_account);
        eSendAmount = v.findViewById(R.id.input_amount);

        return v;
    }

    public SendInfo getSendInfo() {
        final String Info_selected = this.selected;
        final String Info_SendAccount = this.eSendAccount.getText().toString();
        final String Info_SendAmount = this.eSendAmount.getText().toString();

        SendInfo sendInfo = new SendInfo(Info_selected, Info_SendAccount, Info_SendAmount);
        return sendInfo;
    }
}
