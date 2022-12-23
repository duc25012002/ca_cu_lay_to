package com.hdcompany.hocandroid.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView txt_ket_qua, txt_tra_ve;
    MaterialButton btnC, btn_mo_ngoac, btn_dong_ngoac;
    MaterialButton btn_ac, btn_cham;
    MaterialButton btn_chia, btn_nhan, btn_cong, btn_tru, btn_bang;
    MaterialButton btn_khong, btn_mot, btn_hai, btn_ba, btn_bon, btn_nam, btn_sau, btn_bay, btn_tam, btn_chin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //...
        anhXa();
        //...
    }

    public void anhXa() {
        txt_ket_qua = (TextView) findViewById(R.id.txt_ket_qua);
        txt_tra_ve = (TextView) findViewById(R.id.txt_tra_ve);
        //...
        anhXaButton(btnC, R.id.btnC);
        anhXaButton(btn_mo_ngoac, R.id.btn_mo_ngoac);
        anhXaButton(btn_dong_ngoac, R.id.btn_dong_ngoac);
        anhXaButton(btn_ac, R.id.btn_ac);
        anhXaButton(btn_cham, R.id.btn_cham);
        anhXaButton(btn_chia, R.id.btn_chia);
        anhXaButton(btn_nhan, R.id.btn_nhan);
        anhXaButton(btn_cong, R.id.btn_cong);
        anhXaButton(btn_tru, R.id.btn_tru);
        anhXaButton(btn_bang, R.id.btn_bang);
        anhXaButton(btn_khong, R.id.btn_khong);
        anhXaButton(btn_mot, R.id.btn_mot);
        anhXaButton(btn_hai, R.id.btn_hai);
        anhXaButton(btn_ba, R.id.btn_ba);
        anhXaButton(btn_bon, R.id.btn_bon);
        anhXaButton(btn_nam, R.id.btn_nam);
        anhXaButton(btn_sau, R.id.btn_sau);
        anhXaButton(btn_bay, R.id.btn_bay);
        anhXaButton(btn_tam, R.id.btn_tam);
        anhXaButton(btn_chin, R.id.btn_chin);
        //...
    }

    public void anhXaButton(MaterialButton btn, int id) {
        btn = (MaterialButton) findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //...
        MaterialButton button = (MaterialButton) v;
        String buttonText = button.getText().toString();
        String duLieu = txt_tra_ve.getText().toString();
        //...
        if (buttonText.equalsIgnoreCase("AC")) {

            txt_ket_qua.setText("0");//result TV
            txt_tra_ve.setText("");
            return;
        }
        if (buttonText.equalsIgnoreCase("=")) {
            txt_ket_qua.setText(txt_ket_qua.getText());
            return;
        }
        if (buttonText.equalsIgnoreCase("C")) {
            duLieu = duLieu.substring(0, duLieu.length() - 1);

        } else {
            duLieu = duLieu + buttonText;
        }
        //...
        txt_tra_ve.setText(duLieu);
        //...
        String finalResult = getResult(duLieu);

        if (!finalResult.equals("Error")) {
            txt_ket_qua.setText(finalResult);
        }
    }

    String getResult(String data) {
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initStandardObjects();
            String finalResult = context.evaluateString(scriptable, data, "Javascript", 1, null).toString();
            //...
            if (finalResult.endsWith(".0")) {
                finalResult = finalResult.replace(".0", "");
            }
            return finalResult;
        } catch (Exception e) {
            return "Error";
        }
    }


}