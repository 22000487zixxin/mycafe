package com.example.mycafe;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText e1, e2, e3;
    CheckBox ch1;
    TextView t1, t2, t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My Cafe");
        init();
    }

    void init(){
        e1 = findViewById(R.id.input1);
        e2 = findViewById(R.id.input2);
        e3 = findViewById(R.id.input3);
        ch1 = findViewById(R.id.checkBox);
        b1 = findViewById(R.id.button);
        t1 = findViewById(R.id.count);
        t2 = findViewById(R.id.discount);
        t3 = findViewById(R.id.cost);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String americano = e1.getText().toString();
                String latte = e2.getText().toString();
                String moca = e3.getText().toString();

                int americanoCount,latteCount,mocaCount;

                if(americano.getBytes().length==0) americanoCount = 0;
                else americanoCount =Integer.parseInt(americano);

                if(latte.getBytes().length==0) latteCount = 0;
                else latteCount = Integer.parseInt(latte);

                if(moca.getBytes().length==0) mocaCount = 0;
                else mocaCount = Integer.parseInt(moca);

                int count = americanoCount + latteCount + mocaCount;

                double result;
                double discount = 0;

                if(ch1.isChecked() == true){
                    result = (americanoCount * 1000)+(latteCount * 1500)+(mocaCount* 1700);
                    discount = result*0.1;
                    result = result*0.9;
                }else result = (americanoCount * 1000)+(latteCount * 1500)+(mocaCount* 1700);

                t1.setText(String.valueOf("주문개수 : "+count+"개"));
                t2.setText(String.valueOf("할인금액 : "+(int)discount+"원"));
                t3.setText(String.valueOf("결제금액 : "+(int)result+"원"));
            }
        });
    }
}