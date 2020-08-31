//thaneshravindran
package com.example.scientificcalculator;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvInfo;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPoint, btnDel, btnClr, btnAdd, btnSub, btnMul, btnDiv, btnEquals, btnPercent,
            btnExp, btnLog, btnSqr, btnAbs, btnFlr, btnSin, btnCos, btnTan, btnSrqRoot, btnCube, btnCubeRoot;
    private double valueOne, valueTwo;
    private int secNumIndex = 0;
    private String element;
    private char currentOp;
    private boolean dotOp = false;
    private boolean isOpPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnPoint = findViewById(R.id.btnPoint);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnDel = findViewById(R.id.btnDel);
        btnClr = findViewById(R.id.btnClr);
        btnEquals = findViewById(R.id.btnEquals);
        btnExp = findViewById(R.id.btnExp);
        btnLog = findViewById(R.id.btnLog);
        btnSqr = findViewById(R.id.btnSqr);
        btnAbs = findViewById(R.id.btnAbs);
        btnFlr = findViewById(R.id.btnFlr);
        btnSin = findViewById(R.id.btnSin);
        btnCos = findViewById(R.id.btnCos);
        btnTan = findViewById(R.id.btnTan);
        btnSrqRoot = findViewById(R.id.btnSqrRoot);
        btnPercent = findViewById(R.id.btnPercent);
        btnCube = findViewById(R.id.btnCube);
        btnCubeRoot = findViewById(R.id.btnCubeRoot);
        tvInfo = findViewById(R.id.tvInfo);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInfo.append("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInfo.append("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInfo.append("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInfo.append("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInfo.append("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInfo.append("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInfo.append("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInfo.append("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInfo.append("8");

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInfo.append("9");
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opPressed('+');
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opPressed('-');
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opPressed('*');
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opPressed('/');
            }
        });
        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOpPressed){
                    String screenContent = tvInfo.getText().toString();
                    char lastChar = screenContent.charAt(screenContent.length() - 1);
                    if(lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/'){
                        return;
                    }
                }
                String screenContent = tvInfo.getText().toString();
                String secondNumStr = screenContent.substring(secNumIndex);
                valueTwo = Double.parseDouble ( secondNumStr );
                if(currentOp == '+'){
                    valueTwo += valueOne;
                }else if(currentOp == '-'){
                    valueTwo = valueOne - valueTwo;
                }else if(currentOp == '*'){
                    valueTwo *= valueOne;
                }else if(currentOp == '/'){
                    if(valueTwo != 0){
                        valueTwo = valueOne / valueTwo;
                    }
                }
                String results = String.valueOf(valueTwo);
                if(results.endsWith(".0")){
                    results = results.substring(0, results.length() - 2);
                }
                tvInfo.setText(results);
                isOpPressed = false;
            }
        });
        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvInfo.setText(null);
            }
        });
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                element = tvInfo.getText().toString();
                int elementLength = element.length();
                if (elementLength > 0) {
                    element = element.substring(0, elementLength - 1);
                    tvInfo.setText(element);
                }
            }
        });
        btnPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!dotOp) {
                    String screenContent = tvInfo.getText().toString();
                    final int screenContentLength = screenContent.length();
                    if(screenContentLength < 1){
                        return;
                    }
                    char lastChar = screenContent.charAt(screenContent.length() - 1);
                    if(lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == '/'){
                        return;
                    }
                    tvInfo.append(".");
                    dotOp = true;
                }
            }
        });
        btnSqr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    valueOne = Math.pow(Double.parseDouble(tvInfo.getText().toString()), 2);
                    tvInfo.setText("");
                    tvInfo.append(tvInfo.getText().toString() + valueOne);
                }
                catch (Exception ignored){
                }
            }
        });
        btnCube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    valueOne = Math.pow(Double.parseDouble(tvInfo.getText().toString()), 3);
                    tvInfo.setText("");
                    tvInfo.append(tvInfo.getText().toString() + valueOne);
                }
                catch (Exception ignored){
                }
            }
        });
        btnSrqRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    valueOne = Math.sqrt(Double.parseDouble(tvInfo.getText().toString()));
                    tvInfo.setText("");
                    tvInfo.append(tvInfo.getText().toString() + valueOne);
                }
                catch(Exception ignored){
                }
            }
        });
        btnCubeRoot.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                try {
                    valueOne = Math.cbrt(Double.parseDouble(tvInfo.getText().toString()));
                    tvInfo.setText("");
                    tvInfo.append(tvInfo.getText().toString() + valueOne);
                }
                catch(Exception ignored){
                }
            }
        } );
        btnSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    valueOne = Math.sin(Math.toRadians(Double.parseDouble(tvInfo.getText().toString())));
                    tvInfo.setText("");
                    tvInfo.append(tvInfo.getText().toString() + valueOne);
                }
                catch(Exception ignored){
                }
            }
        });
        btnCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    valueOne = Math.cos(Math.toRadians(Double.parseDouble(tvInfo.getText().toString())));
                    tvInfo.setText("");
                    tvInfo.append(tvInfo.getText().toString() + valueOne);
                }
                catch(Exception ignored){
                }
            }
        });
        btnTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    valueOne = Math.tan(Math.toRadians(Double.parseDouble(tvInfo.getText().toString())));
                    tvInfo.setText("");
                    tvInfo.append(tvInfo.getText().toString() + valueOne);
                }
                catch(Exception ignored){
                }
            }
        });
        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    valueOne = Math.log10(Double.parseDouble(tvInfo.getText().toString()));
                    tvInfo.setText("");
                    tvInfo.append(tvInfo.getText().toString() + valueOne);
                }
                catch(Exception ignored){
                }
            }
        });
        btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = tvInfo.getText().toString();
                secNumIndex = info.length() + 1;
                valueOne = Double.parseDouble(info);
                try{
                    valueTwo = valueOne / 100;
                }
                catch (Exception ignored){
                }
                String results = String.valueOf(valueTwo);
                tvInfo.setText(results);
            }
        });
        btnExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = tvInfo.getText().toString();
                try{
                    valueOne = Math.exp(Double.parseDouble(info));
                    String results1 = String.valueOf(valueOne);
                    tvInfo.setText(results1);
                }
                catch(Exception ignored){
                }
            }
        });
        btnAbs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = tvInfo.getText().toString();
                try{
                    valueOne = Math.abs(Double.parseDouble(info));
                    String results = String.valueOf(valueOne);
                    tvInfo.setText(results);
                }
                catch(Exception ignored){
                }
            }
        });
        btnFlr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = tvInfo.getText().toString();
                try{
                    valueOne = Math.floor(Double.parseDouble(info));
                    String results = String.valueOf(valueOne);
                    tvInfo.setText(results);
                }
                catch(Exception ignored){
                }
            }
        });
    }
    private void opPressed(char operation){
        if(isOpPressed){
            return;
        }
        String screenContent = tvInfo.getText().toString();
        final int screenContentLength = screenContent.length();
        if(screenContentLength < 1){
            return;
        }
        secNumIndex = screenContentLength + 1;
        valueOne = Double.parseDouble(screenContent);
        tvInfo.append(String.valueOf(operation));
        isOpPressed = true;
        dotOp = false;
        currentOp = operation;
    }
}
