package com.example.work2;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_1; // 数字1
    Button btn_2; // 数字2
    Button btn_3; // 数字3
    Button btn_4; // 数字4
    Button btn_5; // 数字5
    Button btn_6; // 数字6
    Button btn_7; // 数字7
    Button btn_8; // 数字8
    Button btn_9; // 数字9
    Button btn_0; // 数字0
    Button add; // +号
    Button sub; // -号
    Button mul; // *号
    Button div; // 除号
    Button dot; // 小数点
    ImageButton equ; // =号
    ImageButton backspace; // 退格符号
    Button percentSign; // %
    Button ac; //清除
    TextView result; // 显示结果
    TextView record; // 显示记录

    ArrayList<String> operatorStack = new ArrayList<>();
    ArrayList<Double> operandStack = new ArrayList<>();
    ArrayList<String> operatorList = new ArrayList<>();
    int previousOperatorSubscript = 0;
    int nextOperatorSubscript = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operatorList.add("+");
        operatorList.add("-");
        operatorList.add("×");
        operatorList.add("÷");

        // 获取页面上的控件
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_0 = findViewById(R.id.btn_0);
        add = findViewById(R.id.btn_add);
        sub = findViewById(R.id.btn_sub);
        mul = findViewById(R.id.btn_mul);
        div = findViewById(R.id.btn_div);
        equ = findViewById(R.id.btn_equ);
        dot = findViewById(R.id.btn_dot);
        ac = findViewById(R.id.btn_clear);
        percentSign = findViewById(R.id.btn_percentSign);
        backspace = findViewById(R.id.btn_delete);
        record = findViewById(R.id.et_record);
        result = findViewById(R.id.et_result);

        // 按钮的单击事件
        btn_1.setOnClickListener(new Click());
        btn_2.setOnClickListener(new Click());
        btn_3.setOnClickListener(new Click());
        btn_4.setOnClickListener(new Click());
        btn_5.setOnClickListener(new Click());
        btn_6.setOnClickListener(new Click());
        btn_7.setOnClickListener(new Click());
        btn_8.setOnClickListener(new Click());
        btn_9.setOnClickListener(new Click());
        btn_0.setOnClickListener(new Click());
        add.setOnClickListener(new Click());
        sub.setOnClickListener(new Click());
        mul.setOnClickListener(new Click());
        div.setOnClickListener(new Click());
        equ.setOnClickListener(new Click());
        dot.setOnClickListener(new Click());
        ac.setOnClickListener(new Click());
        backspace.setOnClickListener(new Click());
        percentSign.setOnClickListener(new Click());

    }

    // 设置按钮点击后的监听
    class Click implements View.OnClickListener {
        @RequiresApi(api = Build.VERSION_CODES.N)
        @SuppressLint("NonConstantResourceId")
        public void onClick(View v) {
            switch (v.getId()) {                //switch循环获取点击按钮后的值
                case R.id.btn_0:                //获取，0-9、小数点，并在编辑框显示
                    String myString = record.getText().toString();
                    myString += "0";
                    record.setText(myString);
                    break;
                case R.id.btn_1:
                    myString = record.getText().toString();
                    myString += "1";
                    record.setText(myString);
                    break;
                case R.id.btn_2:
                    myString = record.getText().toString();
                    myString += "2";
                    record.setText(myString);
                    break;
                case R.id.btn_3:
                    myString = record.getText().toString();
                    myString += "3";
                    record.setText(myString);
                    break;
                case R.id.btn_4:
                    myString = record.getText().toString();
                    myString += "4";
                    record.setText(myString);
                    break;
                case R.id.btn_5:
                    myString = record.getText().toString();
                    myString += "5";
                    record.setText(myString);
                    break;
                case R.id.btn_6:
                    myString = record.getText().toString();
                    myString += "6";
                    record.setText(myString);
                    break;
                case R.id.btn_7:
                    myString = record.getText().toString();
                    myString += "7";
                    record.setText(myString);
                    break;
                case R.id.btn_8:
                    myString = record.getText().toString();
                    myString += "8";
                    record.setText(myString);
                    break;
                case R.id.btn_9:
                    myString = record.getText().toString();
                    myString += "9";
                    record.setText(myString);
                    break;
                case R.id.btn_dot:
                    myString = record.getText().toString();
                    myString += ".";
                    record.setText(myString);
                    break;
                case R.id.btn_add:             //判断，使用加减乘除的操作符
                    myString = record.getText().toString();
                    myString += "+";
                    record.setText(myString);
                    break;
                case R.id.btn_sub:
                    myString = record.getText().toString();
                    myString += "-";
                    record.setText(myString);
                    break;
                case R.id.btn_mul:
                    myString = record.getText().toString();
                    myString += "×";
                    record.setText(myString);
                    break;
                case R.id.btn_div:
                    myString = record.getText().toString();
                    myString += "÷";
                    record.setText(myString);
                    break;
                case R.id.btn_delete:
                    myString = record.getText().toString();
                    if (myString.length() > 0) {
                        myString = myString.substring(0, myString.length() - 1);
                        record.setText(myString);
                    }
                    break;
                case R.id.btn_clear:                 //清除，将编辑框文本显示为空
                    record.setText(null);
                    result.setText(null);
                    previousOperatorSubscript = 0;
                    nextOperatorSubscript = 0;
                    operandStack.clear();
                    operatorStack.clear();
                    break;
                case R.id.btn_equ:                   //计算，以操作符为判断，选择所需的运算，并将结果输出
                    if ("错误".equals(result.getText().toString())) return;
                    myString = record.getText().toString();
                    if ("".equals(myString)) return;

                    // 遍历运算记录，调整运算优先级，使运算记录中只剩下加减操作
                    for (int i = 0; i < myString.length(); i++) {
                        String operator = String.valueOf(myString.charAt(i));
                        // 如果遍历到运算符
                        if (operatorList.contains(operator)) {

                            // 插入新的操作数
                            nextOperatorSubscript = i;
                            try {
                                operandStack.add(Double.parseDouble(myString.substring(previousOperatorSubscript, nextOperatorSubscript)));
                            } catch (Exception e) {
                                result.setText("错误");
                                return;
                            }
                            previousOperatorSubscript = nextOperatorSubscript + 1;

                            // 如果运算符栈中没有运算符
                            if (operatorStack.size() == 0) {
                                operatorStack.add(operator);
                            } else {
                                // 找出上一个运算符
                                String pre_operator = operatorStack.get(operatorStack.size() - 1);

                                if ("×".equals(pre_operator)) {
                                    // 移除上一个运算符
                                    operatorStack.remove(operatorStack.size() - 1);
                                    Double num1 = operandStack.get(operandStack.size() - 2);
                                    Double num2 = operandStack.get(operandStack.size() - 1);
                                    operandStack.remove(operandStack.size() - 1);
                                    operandStack.remove(operandStack.size() - 1);
                                    operandStack.add(num1 * num2);
                                } else if ("÷".equals(pre_operator)) {
                                    // 移除上一个运算符
                                    operatorStack.remove(operatorStack.size() - 1);
                                    Double num1 = operandStack.get(operandStack.size() - 2);
                                    Double num2 = operandStack.get(operandStack.size() - 1);
                                    operandStack.remove(operandStack.size() - 1);
                                    operandStack.remove(operandStack.size() - 1);
                                    operandStack.add(num1 / num2);
                                }
                                // 插入新的运算符
                                operatorStack.add(operator);
                            }
                        } else if (i == record.length() - 1) {
                            // 如果遍历到末尾，添加最后一个操作数
                            try {
                                operandStack.add(Double.parseDouble(myString.substring(previousOperatorSubscript, record.length())));
                            } catch (Exception e) {
                                result.setText("错误");
                                return;
                            }
                            // 如果上一个操作数是乘法或除法，则进行运算
                            if (operatorStack.size() > 0) {
                                String pre_operator = operatorStack.get(operatorStack.size() - 1);
                                if ("×".equals(pre_operator)) {
                                    // 移除上一个运算符
                                    operatorStack.remove(operatorStack.size() - 1);
                                    Double num1 = operandStack.get(operandStack.size() - 2);
                                    Double num2 = operandStack.get(operandStack.size() - 1);
                                    operandStack.remove(operandStack.size() - 1);
                                    operandStack.remove(operandStack.size() - 1);
                                    operandStack.add(num1 * num2);
                                } else if ("÷".equals(pre_operator)) {
                                    // 移除上一个运算符
                                    operatorStack.remove(operatorStack.size() - 1);
                                    Double num1 = operandStack.get(operandStack.size() - 2);
                                    Double num2 = operandStack.get(operandStack.size() - 1);
                                    operandStack.remove(operandStack.size() - 1);
                                    operandStack.remove(operandStack.size() - 1);
                                    operandStack.add(num1 / num2);
                                }
                            }
                        }
                    }

                    // 判断两个栈是否合法
                    if (operandStack.size() != operatorStack.size() + 1) {
                        result.setText("错误");
                        return;
                    }

                    // 完成剩余栈中的运算
                    for (int i = 0; i < operatorStack.size(); i++) {
                        String operator = operatorStack.get(i);
                        if ("+".equals(operator)) {
                            Double num1 = operandStack.get(0);
                            Double num2 = operandStack.get(1);
                            operandStack.remove(0);
                            operandStack.remove(0);
                            operandStack.add(num1 + num2);
                        } else if ("-".equals(operator)) {
                            Double num1 = operandStack.get(0);
                            Double num2 = operandStack.get(1);
                            operandStack.remove(0);
                            operandStack.remove(0);
                            operandStack.add(0, num1 - num2);
                        } else if ("×".equals(operator)) {
                            Double num1 = operandStack.get(0);
                            Double num2 = operandStack.get(1);
                            operandStack.remove(0);
                            operandStack.remove(0);
                            operandStack.add(0, num1 * num2);
                        } else if ("÷".equals(operator)) {
                            Double num1 = operandStack.get(0);
                            Double num2 = operandStack.get(1);
                            operandStack.remove(0);
                            operandStack.remove(0);
                            operandStack.add(0, num1 / num2);
                        }
                    }
                    result.setText(String.valueOf(operandStack.get(0)));    //将结果完整输出
                    record.setText(String.valueOf(operandStack.get(0)));
                    previousOperatorSubscript = 0;
                    nextOperatorSubscript = 0;
                    operandStack.clear();
                    operatorStack.clear();
                    break;
                default:
                    break;
            }
        }
    }
}