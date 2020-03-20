package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import android.os.Bundle;
import android.widget.Button;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.Scope;

enum State
{
    BEGIN,
    EQUAL,
    DOESNTMATTER
}
enum Operation
{
    PLUS,
    MINUS,
    DIVIDE,
    MULTIPLY,
    POW,
    PERCENT,
    SQRT,
    UNDEFINED,
    SIN,
    COS,
    TAN,
    COT,
    SQR,
    FACTORIAL,
    LN,
    LOG
}

public class MainActivity extends AppCompatActivity {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDot,
            btnEqual, btnPlus, btnMinus, btnMultiply, btnDivision, btnClear, btnPercent, btnPow, btnRoot,
            btnSin, btnCos, btnTan, btnCot, btnLn, btnLog, btnFactorial, btnSqr, btnE, btnPI;

    TextView tvInput;
    double valueOne=0;
    double valueTwo=valueOne;
    boolean dotted = false;
    State state = State.BEGIN;
    Operation operation = Operation.UNDEFINED;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("temp", tvInput.getText().toString());

        outState.putDouble("valueOne", valueOne);
        outState.putDouble("valueTwo", valueTwo);
        outState.putSerializable("state", state);
        outState.putSerializable("operation", operation);
        outState.putBoolean("dotted", dotted);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivision = findViewById(R.id.btnDivision);
        btnClear = findViewById(R.id.btnClear);
        btnPercent = findViewById(R.id.btnPercent);
        btnPow = findViewById(R.id.btnPow);
        btnRoot = findViewById(R.id.btnRoot);
        btnDot = findViewById(R.id.btnDot);
        btnEqual = findViewById(R.id.btnEqual);

        tvInput = findViewById(R.id.tvInput);

        btnSin = findViewById(R.id.btnSin);
        btnCos = findViewById(R.id.btnCos);
        btnTan = findViewById(R.id.btnTan);
        btnCot = findViewById(R.id.btnCot);

        btnLn = findViewById(R.id.btnLn);
        btnLog = findViewById(R.id.btnLog);
        btnFactorial = findViewById(R.id.btnFactorial);
        btnSqr = findViewById(R.id.btnSqr);
        btnE = findViewById(R.id.btnE);
        btnPI = findViewById(R.id.btnPI);

        if(savedInstanceState!=null){
            super.onRestoreInstanceState(savedInstanceState);

            valueOne = savedInstanceState.getDouble("valueOne");
            valueTwo = savedInstanceState.getDouble("valueTwo");
            dotted = savedInstanceState.getBoolean("dotted");
            operation = (Operation)savedInstanceState.getSerializable("operation");
            state = (State)savedInstanceState.getSerializable("state");
            tvInput.setText(savedInstanceState.getString("temp"));
        }

        View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id=v.getId();
                switch(id) {
                    case R.id.btn0:
                        if (tvInput.getText().toString().equals("Infinity") || tvInput.getText().toString().equals("0") || tvInput.getText().toString().equals("Error!")) {
                            tvInput.setText("");
                        }
                        if ((state != state.BEGIN) && (state != state.EQUAL)) {
                            state = state.BEGIN;
                            tvInput.setText("");
                        }
                        if(tvInput.getText().toString().length()==0 && dotted)
                            tvInput.setText("0");
                        else
                            tvInput.append("0");
                        break;
                    case R.id.btn1: {
                        if (tvInput.getText().toString().equals("0") || tvInput.getText().toString().equals("Error!") || tvInput.getText().toString().equals("Infinity")) {
                            tvInput.setText("");
                        }
                        if (state != state.BEGIN && state != state.EQUAL) {
                            state = state.BEGIN;
                            tvInput.setText("");
                        }
                        tvInput.append("1");
                        break;
                    }
                    case R.id.btn2: {
                        if (tvInput.getText().toString().equals("0") || tvInput.getText().toString().equals("Error!") || tvInput.getText().toString().equals("Infinity")) {
                            tvInput.setText("");
                        }
                        if (state != state.BEGIN && state != state.EQUAL) {
                            state = state.BEGIN;
                            tvInput.setText("");
                        }
                        tvInput.append("2");
                        break;
                    }
                    case R.id.btn3: {
                        if (tvInput.getText().toString().equals("0") || tvInput.getText().toString().equals("Error!") || tvInput.getText().toString().equals("Infinity")) {
                            tvInput.setText("");
                        }
                        if (state != state.BEGIN && state != state.EQUAL) {
                            state = state.BEGIN;
                            tvInput.setText("");
                        }
                        tvInput.append("3");
                        break;
                    }
                    case R.id.btn4: {
                        if (tvInput.getText().toString().equals("0") || tvInput.getText().toString().equals("Error!") || tvInput.getText().toString().equals("Infinity")) {
                            tvInput.setText("");
                        }
                        if (state != state.BEGIN && state != state.EQUAL) {
                            state = state.BEGIN;
                            tvInput.setText("");
                        }
                        tvInput.append("4");
                        break;
                    }
                    case R.id.btn5:{
                        if (tvInput.getText().toString().equals("0") || tvInput.getText().toString().equals("Error!") || tvInput.getText().toString().equals("Infinity")) {
                            tvInput.setText("");
                        }
                        if (state != state.BEGIN && state != state.EQUAL) {
                            state = state.BEGIN;
                            tvInput.setText("");
                        }
                        tvInput.append("5");
                        break;
                    }
                    case R.id.btn6: {
                        if (tvInput.getText().toString().equals("0") || tvInput.getText().toString().equals("Error!") || tvInput.getText().toString().equals("Infinity")) {
                            tvInput.setText("");
                        }
                        if (state != state.BEGIN && state != state.EQUAL) {
                            state = state.BEGIN;
                            tvInput.setText("");
                        }
                        tvInput.append("6");
                        break;
                    }
                    case R.id.btn7: {
                        if (tvInput.getText().toString().equals("0") || tvInput.getText().toString().equals("Error!") || tvInput.getText().toString().equals("Infinity")) {
                            tvInput.setText("");
                        }
                        if (state != state.BEGIN && state != state.EQUAL) {
                            state = state.BEGIN;
                            tvInput.setText("");
                        }
                        tvInput.append("7");
                        break;
                    }
                    case R.id.btn8: {
                        if (tvInput.getText().toString().equals("0") || tvInput.getText().toString().equals("Error!") || tvInput.getText().toString().equals("Infinity")) {
                            tvInput.setText("");
                        }
                        if (state != state.BEGIN && state != state.EQUAL) {
                            state = state.BEGIN;
                            tvInput.setText("");
                        }
                        tvInput.append("8");
                        break;
                    }
                    case R.id.btn9: {
                        if (tvInput.getText().toString().equals("0") || tvInput.getText().toString().equals("Error!") || tvInput.getText().toString().equals("Infinity")) {
                            tvInput.setText("");
                        }
                        if (state != state.BEGIN && state != state.EQUAL) {
                            state = state.BEGIN;
                            tvInput.setText("");
                        }
                        tvInput.append("9");
                        break;
                    }
                    case R.id.btnDot: {
                        if (tvInput.getText().toString().equals("Error!") || tvInput.getText().toString().equals("Infinity")) {
                            tvInput.setText("");
                        }
                        if (tvInput.getText().toString().contains(".")) {
                            dotted = true;
                        }
                    if (!dotted)
                        tvInput.append(".");

                    dotted = true;
                    break;
                }
                    case R.id.btnPlus: {
                        state = state.DOESNTMATTER;
                        operation = operation.PLUS;
                        if (tvInput.getText().toString().equals("Infinity")) {
                            tvInput.setText("");
                        }
                        try {
                            valueOne = Double.parseDouble(tvInput.getText().toString());
                        } catch (NumberFormatException e) {
                            tvInput.setText("Error!");
                        }
                        if (tvInput.getText().toString().equals("Error!")) {
                            tvInput.setText("Error!");
                            valueOne = 0;
                            valueTwo = valueOne;
                            state = state.BEGIN;
                            operation = operation.UNDEFINED;
                            dotted = false;
                        }
                        dotted = false;
                        break;
                    }
                    case R.id.btnMinus: {
                        state = state.DOESNTMATTER;
                        operation = operation.MINUS;
                        if (tvInput.getText().toString().equals("Infinity")) {
                            tvInput.setText("");
                        }
                        try {
                            valueOne = Double.parseDouble(tvInput.getText().toString());
                        } catch (NumberFormatException e) {
                            tvInput.setText("Error!");
                        }
                        if (tvInput.getText().toString().equals("Error!")) {
                            tvInput.setText("Error!");
                            valueOne = 0;
                            valueTwo = valueOne;
                            state = state.BEGIN;
                            operation = operation.UNDEFINED;
                            dotted=false;
                        }
                        dotted = false;
                        break;
                    }
                    case R.id.btnMultiply: {
                        state = state.DOESNTMATTER;
                        operation = operation.MULTIPLY;
                        if (tvInput.getText().toString().equals("Infinity")) {
                            tvInput.setText("");
                        }
                        try {
                            valueOne = Double.parseDouble(tvInput.getText().toString());
                        } catch (NumberFormatException e) {
                            tvInput.setText("Error!");
                        }
                        if (tvInput.getText().toString().equals("Error!")) {
                            tvInput.setText("Error!");
                            valueOne = 0;
                            valueTwo = valueOne;
                            state = state.BEGIN;
                            operation = operation.UNDEFINED;
                            dotted=false;
                        }
                        dotted = false;
                        break;
                    }
                    case R.id.btnDivision: {
                        state = state.DOESNTMATTER;
                        operation = operation.DIVIDE;
                        if (tvInput.getText().toString().equals("Infinity")) {
                            tvInput.setText("");
                        }
                        try {
                            valueOne = Double.parseDouble(tvInput.getText().toString());
                        } catch (NumberFormatException e) {
                            tvInput.setText("Error!");
                        }if (tvInput.getText().toString().equals("Error!")) {
                            tvInput.setText("Error!");
                            valueOne = 0;
                            valueTwo = valueOne;
                            state = state.BEGIN;
                            operation = operation.UNDEFINED;
                            dotted=false;
                        }
                        dotted = false;
                        break;
                    }
                    case R.id.btnPow: {
                        state = state.DOESNTMATTER;
                        operation = operation.POW;
                        if (tvInput.getText().toString().equals("Infinity")) {
                            tvInput.setText("");
                        }
                        try {
                            valueOne = Double.parseDouble(tvInput.getText().toString());
                        } catch (NumberFormatException e) {
                            tvInput.setText("Error!");
                        }if (tvInput.getText().toString().equals("Error!")) {
                            tvInput.setText("Error!");
                            valueOne = 0;
                            valueTwo = valueOne;
                            state = state.BEGIN;
                            operation = operation.UNDEFINED;
                            dotted = false;
                        }
                        dotted = false;
                        break;
                    }
                    case R.id.btnPercent:{
                        state = state.DOESNTMATTER;
                        operation = operation.PERCENT;
                        if(tvInput.getText().toString().equals("Infinity")){
                            tvInput.setText("0");
                        }
                        try{
                            valueOne = Double.parseDouble(tvInput.getText().toString());
                        }catch (NumberFormatException e){
                            tvInput.setText("Error!");
                        }if (tvInput.getText().toString().equals("Error!")) {
                            tvInput.setText("Error!");
                            valueOne = 0;
                            valueTwo = valueOne;
                            state = state.BEGIN;
                            operation = operation.UNDEFINED;
                            dotted = false;
                        }else {
                            tvInput.setText(Double.toString(valueOne * 0.01));
                            dotted = false;
                        }
                        break;
                    }
                    case R.id.btnRoot:{
                        state = state.DOESNTMATTER;
                        operation = operation.SQRT;
                        if(tvInput.getText().toString().equals("Infinity")){
                            tvInput.setText("0");
                        }
                        try{
                            valueOne = Double.parseDouble(tvInput.getText().toString());
                        }catch (NumberFormatException e){
                            tvInput.setText("Error!");
                        }
                        if (tvInput.getText().toString().equals("Error!")) {
                            tvInput.setText("Error!");
                            valueOne = 0;
                            valueTwo = valueOne;
                            state = state.BEGIN;
                            operation = operation.UNDEFINED;
                            dotted = false;
                        }else {
                            tvInput.setText(Double.toString(Math.sqrt(valueOne)));
                            dotted = false;
                        }
                        break;
                    }
                    case R.id.btnSin:{
                        state=state.DOESNTMATTER;
                        operation=operation.SIN;
                        if(tvInput.getText().toString().equals("Error!") || tvInput.getText().toString().equals("Infinity")){
                            tvInput.setText("");
                        }
                        try {
                            valueOne = Double.parseDouble(tvInput.getText().toString());
                        }
                        catch(NumberFormatException e)
                        {
                            tvInput.setText("Error!");
                        }
                        dotted=false;
                        tvInput.setText(Double.toString(Math.sin(Math.toRadians(valueOne))));
                        break;
                    }case R.id.btnCos:{
                        state=state.DOESNTMATTER;
                        operation=operation.COS;
                        if(tvInput.getText().toString().equals("Error!") || tvInput.getText().toString().equals("Infinity")){
                            tvInput.setText("");
                        }
                        try {
                            valueOne = Double.parseDouble(tvInput.getText().toString());
                        }
                        catch(NumberFormatException e)
                        {
                            tvInput.setText("Error!");
                        }
                        dotted=false;
                        tvInput.setText(Double.toString(Math.cos(Math.toRadians(valueOne))));
                        break;
                    }case R.id.btnTan:{
                        state=state.DOESNTMATTER;
                        operation=operation.TAN;
                        if(tvInput.getText().toString().equals("Error!") || tvInput.getText().toString().equals("Infinity")){
                            tvInput.setText("");
                        }
                        try {
                            valueOne = Double.parseDouble(tvInput.getText().toString());
                        }
                        catch(NumberFormatException e)
                        {
                            tvInput.setText("Error!");
                        }
                        dotted=false;
                        tvInput.setText(Double.toString(Math.tan(Math.toRadians(valueOne))));
                        break;
                    }case R.id.btnCot:{
                        state=state.DOESNTMATTER;
                        operation=operation.COT;
                        if(tvInput.getText().toString().equals("Error!") || tvInput.getText().toString().equals("Infinity")){
                            tvInput.setText("");
                        }
                        try {
                            valueOne = Double.parseDouble(tvInput.getText().toString());
                        }
                        catch(NumberFormatException e)
                        {
                            tvInput.setText("Error!");
                        }
                        dotted=false;
                        tvInput.setText(Double.toString(1/(Math.tan(Math.toRadians(valueOne)))));
                        break;
                    }case R.id.btnE:{
                        state=state.DOESNTMATTER;
                        operation=operation.UNDEFINED;
                        if(tvInput.getText().toString().equals("Error!") || tvInput.getText().toString().equals("Infinity")){
                            tvInput.setText("");
                        }
                        dotted=false;
                        tvInput.setText(Double.toString(Math.E));
                        break;
                    }case R.id.btnPI:{
                        state=state.DOESNTMATTER;
                        operation=operation.UNDEFINED;
                        if(tvInput.getText().toString().equals("Error!") || tvInput.getText().toString().equals("Infinity")){
                            tvInput.setText("");
                        }
                        dotted=false;
                        tvInput.setText(Double.toString(Math.PI));
                        break;
                    }case R.id.btnSqr:{
                        state = state.DOESNTMATTER;
                        operation = operation.SQR;
                        if(tvInput.getText().toString().equals("Infinity")){
                            tvInput.setText("0");
                        }
                        try{
                            valueOne = Double.parseDouble(tvInput.getText().toString());
                        }catch (NumberFormatException e){
                            tvInput.setText("Error!");
                        }
                        if (tvInput.getText().toString().equals("Error!")) {
                            tvInput.setText("Error!");
                            valueOne = 0;
                            valueTwo = valueOne;
                            state = state.BEGIN;
                            operation = operation.UNDEFINED;
                            dotted = false;
                        }else {
                            tvInput.setText(Double.toString(valueOne * valueOne));
                            dotted = false;
                        }
                        break;
                    }case R.id.btnLn:{
                        state = state.DOESNTMATTER;
                        operation = operation.LN;
                        if(tvInput.getText().toString().equals("Infinity")){
                            tvInput.setText("0");
                        }
                        try{
                            valueOne = Double.parseDouble(tvInput.getText().toString());
                        }catch (NumberFormatException e){
                            tvInput.setText("Error!");
                        }
                        if (tvInput.getText().toString().equals("Error!")) {
                            tvInput.setText("Error!");
                            valueOne = 0;
                            valueTwo = valueOne;
                            state = state.BEGIN;
                            operation = operation.UNDEFINED;
                            dotted = false;
                        }else if(valueOne==0) {
                            tvInput.setText("Error!");
                        }else if(valueOne==2.71828182845904) {
                            tvInput.setText("1");
                        }else{
                            tvInput.setText(Double.toString(Math.log(valueOne)));
                            dotted = false;
                        }
                        break;
                    }case R.id.btnLog:{
                        state = state.DOESNTMATTER;
                        operation = operation.LOG;
                        if(tvInput.getText().toString().equals("Infinity")){
                            tvInput.setText("0");
                        }
                        try{
                            valueOne = Double.parseDouble(tvInput.getText().toString());
                        }catch (NumberFormatException e){
                            tvInput.setText("Error!");
                        }
                        if (tvInput.getText().toString().equals("Error!")) {
                            tvInput.setText("Error!");
                            valueOne = 0;
                            valueTwo = valueOne;
                            state = state.BEGIN;
                            operation = operation.UNDEFINED;
                            dotted = false;
                        }else if(valueOne==0) {
                            tvInput.setText("Error!");
                        }else{
                            tvInput.setText(Double.toString(Math.log10(valueOne)));
                            dotted = false;
                        }
                        break;
                    }case R.id.btnFactorial:{
                        state = state.DOESNTMATTER;
                        operation = operation.FACTORIAL;
                        if(tvInput.getText().toString().equals("Infinity")){
                            tvInput.setText("0");
                        }
                        try{
                            valueOne = Double.parseDouble(tvInput.getText().toString());
                        }catch (NumberFormatException e){
                            tvInput.setText("Error!");
                        }
                        if (tvInput.getText().toString().equals("Error!")) {
                            tvInput.setText("Error!");
                            valueOne = 0;
                            valueTwo = valueOne;
                            state = state.BEGIN;
                            operation = operation.UNDEFINED;
                            dotted = false;
                        }
                        else{
                            long ans = 1;
                            for (long i = 1; i <= valueOne; i++){
                                ans = ans*i;
                            }
                            tvInput.setText(Double.toString(ans));
                            dotted = false;
                        }
                        break;
                    }
                }
            }
        };

        btn0.setOnClickListener(calculatorListener);
        btn1.setOnClickListener(calculatorListener);
        btn2.setOnClickListener(calculatorListener);
        btn3.setOnClickListener(calculatorListener);
        btn4.setOnClickListener(calculatorListener);
        btn5.setOnClickListener(calculatorListener);
        btn6.setOnClickListener(calculatorListener);
        btn7.setOnClickListener(calculatorListener);
        btn8.setOnClickListener(calculatorListener);
        btn9.setOnClickListener(calculatorListener);
        btnDot.setOnClickListener(calculatorListener);
        btnMultiply.setOnClickListener(calculatorListener);
        btnDivision.setOnClickListener(calculatorListener);
        btnPlus.setOnClickListener(calculatorListener);
        btnMinus.setOnClickListener(calculatorListener);
        btnPow.setOnClickListener(calculatorListener);
        btnPercent.setOnClickListener(calculatorListener);
        btnRoot.setOnClickListener(calculatorListener);
        btnEqual.setOnClickListener(calculatorListener);

        btnSin.setOnClickListener(calculatorListener);
        btnCos.setOnClickListener(calculatorListener);
        btnTan.setOnClickListener(calculatorListener);
        btnCot.setOnClickListener(calculatorListener);
        btnLn.setOnClickListener(calculatorListener);
        btnLog.setOnClickListener(calculatorListener);
        btnFactorial.setOnClickListener(calculatorListener);
        btnSqr.setOnClickListener(calculatorListener);
        btnE.setOnClickListener(calculatorListener);
        btnPI.setOnClickListener(calculatorListener);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvInput.getText().toString().equals("Error!")){
                    tvInput.setText("");
                }
                if(tvInput.getText().toString().length()==0)
                {
                    //nothing happens
                }
                else if(tvInput.getText().length() == 1) {
                    tvInput.setText("");
                } else { //if text length > 1
                    try {
                        tvInput.setText(tvInput.getText().toString().substring(0, tvInput.getText().toString().length() - 1));
                        valueOne = Double.parseDouble(tvInput.getText().toString());
                    }
                    catch(NumberFormatException e)
                    {
                        tvInput.setText("");
                    }
                }

                if(tvInput.getText().toString().contains("."))
                {
                    dotted=true;
                }
                else dotted=false;
            }
        });
        btnClear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(tvInput.getText().toString().equals("Error!") || tvInput.getText().toString().equals("Infinity")){
                    tvInput.setText("");
                }
                if(tvInput.getText().toString().length()==0)
                {
                    return true;
                }
                    tvInput.setText("");
                    valueOne = 0;
                    valueTwo = valueOne;
                    state = state.BEGIN;
                    operation = operation.UNDEFINED;
                    dotted=false;
                return true;
            }
        });
        btnMinus.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(tvInput.getText().toString().equals("Infinity")){
                    tvInput.setText("");
                }
                if(tvInput.getText().toString().length()==0)
                {
                    return true;
                }
                try {
                    valueOne = Double.parseDouble(tvInput.getText().toString());
                } catch (NumberFormatException e) {
                    tvInput.setText("Error!");
                }
                if (tvInput.getText().toString().equals("Error!")) {
                    tvInput.setText("Error!");
                    valueOne = 0;
                    valueTwo = valueOne;
                    state = state.BEGIN;
                    operation = operation.UNDEFINED;
                    dotted=false;
                }else {
                    tvInput.setText(Double.toString(valueOne * (-1)));
                    valueOne = valueOne * (-1);
                    dotted = false;
                }
                return true;
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(tvInput.getText().toString().equals("Error!")){
                    tvInput.setText("");
                }
                try {
                    valueTwo = Double.parseDouble(tvInput.getText().toString());
                }
                catch(NumberFormatException e)
                {
                    tvInput.setText("Error!");
                }
                if (operation==operation.PLUS)
                    if(tvInput.getText().toString().equals(("Error!"))){
                        tvInput.setText("Error!");
                        return;
                    }else
                    tvInput.setText(Double.toString(valueOne+valueTwo));
                else if(operation==operation.MINUS)
                    if(tvInput.getText().toString().equals(("Error!"))){
                        tvInput.setText("Error!");
                        return;
                    }else
                    tvInput.setText(Double.toString(valueOne-valueTwo));
                else if(operation==operation.MULTIPLY)
                    if(tvInput.getText().toString().equals(("Error!"))){
                        tvInput.setText("Error!");
                        return;
                    }else
                    tvInput.setText(Double.toString(valueOne*valueTwo));
                else if(operation==operation.DIVIDE)
                    if(tvInput.getText().toString().equals(("Error!"))){
                        tvInput.setText("Error!");
                        return;
                    }else
                    if(valueTwo==0){
                        tvInput.setText("Error!");
                    }
                    else tvInput.setText(Double.toString(valueOne/valueTwo));
                else if(operation==operation.POW)
                    if(tvInput.getText().toString().equals(("Error!"))){
                        tvInput.setText("Error!");
                        return;
                    }else
                    tvInput.setText(Double.toString(Math.pow(valueOne,valueTwo)));
//                else if(operation==operation.PERCENT)
//                    tvInput.setText(Double.toString(valueOne*0.01));
//                else if(operation==operation.SQRT)
//                    tvInput.setText(Double.toString(Math.sqrt(valueOne)));
                else  tvInput.setText("Error!");
                state=state.EQUAL;
            }
        });
    }
}