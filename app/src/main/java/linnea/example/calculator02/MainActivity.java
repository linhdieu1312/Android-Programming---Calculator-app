package linnea.example.calculator02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //khai báo biến
    // in lên màn hình hiển thị
    private String number = null;
    int num1 = 0, num2 = 0;
    String status = null;
    boolean operator = false;


    private TextView textView;
    private Button buttonDiv, buttonCE, buttonC, buttonBS, buttonMultiple, buttonMinus, buttonAdd, buttonEqual, buttonDot;
    private Button button7, button8, button9, button4, button5, button6, button3, button2, button1, button0, buttonMix;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 = this.findViewById(R.id.button0);
        button1 = this.findViewById(R.id.button1);
        button2 = this.findViewById(R.id.button2);
        button3 = this.findViewById(R.id.button3);
        button4 = this.findViewById(R.id.button4);
        button5 = this.findViewById(R.id.button5);
        button6 = this.findViewById(R.id.button6);
        button7 = this.findViewById(R.id.button7);
        button8 = this.findViewById(R.id.button8);
        button9 = this.findViewById(R.id.button9);

        buttonAdd = this.findViewById(R.id.buttonAdd);
        buttonMinus = this.findViewById(R.id.buttonMinus);
        buttonMultiple = this.findViewById(R.id.buttonMultiple);
        buttonDiv = this.findViewById(R.id.buttonDiv);

        buttonCE = this.findViewById(R.id.buttonCE);
        buttonC = this.findViewById(R.id.buttonC);
        buttonBS = this.findViewById(R.id.buttonBS);
        buttonEqual = this.findViewById(R.id.buttonEqual);
        buttonDot = this.findViewById(R.id.buttonDot);
        buttonMix = this.findViewById(R.id.buttonMix);
        textView = this.findViewById(R.id.textView);

        button0.setOnClickListener(view->numberClick("0"));
        button1.setOnClickListener(view->numberClick("1"));
        button2.setOnClickListener(view->numberClick("2"));
        button3.setOnClickListener(view->numberClick("3"));
        button4.setOnClickListener(view->numberClick("4"));
        button5.setOnClickListener(view->numberClick("5"));
        button6.setOnClickListener(view->numberClick("6"));
        button7.setOnClickListener(view->numberClick("7"));
        button8.setOnClickListener(view->numberClick("8"));
        button9.setOnClickListener(view->numberClick("9"));


        buttonAdd.setOnClickListener(view -> {
            if (operator) {
                if (status == "Multiple") {
                    Multiple();
                } else {
                    if (status == "Div") {
                        Div();
                    } else {
                        if (status == "Minus") {
                            Minus();
                        } else {
                            Plus();
                        }
                    }
                }
            }
            operator = false;
            number = null;
            status = "Plus";
        });

        buttonMinus.setOnClickListener(view -> {
            if (operator) {
                if (status == "Multiple") {
                    Multiple();
                } else {
                    if (status == "Div") {
                        Div();
                    } else {
                        if (status == "Plus") {
                            Plus();
                        } else {
                            Minus();
                        }
                    }
                }
            }
            operator = false;
            number = null;
            status = "Minus";
        });

        buttonMultiple.setOnClickListener(view -> {
            if (operator) {
                if (status == "Minus") {
                    Minus();
                } else {
                    if (status == "Div") {
                        Div();
                    } else {
                        if (status == "Plus") {
                            Plus();
                        } else {
                            Multiple();
                        }
                    }
                }
            }
            operator = false;
            number = null;
            status = "Multiple";
        });

        buttonDiv.setOnClickListener(view -> {
            if (operator) {
                if (status == "Multiple") {
                    Multiple();
                } else {
                    if (status == "Minus") {
                        Minus();
                    } else {
                        if (status == "Plus") {
                            Plus();
                        } else {
                            Div();
                        }
                    }
                }
            }
            operator = false;
            number = null;
            status = "Div";
        });

        buttonEqual.setOnClickListener(view -> {
            if (operator) {
                if (status == "Multiple") {
                    Multiple();
                } else {
                    if (status == "Minus") {
                        Minus();
                    } else {
                        if (status == "Plus") {
                            Plus();
                        } else {
                            if (status == "Div") {
                                Div();
                            } else {
                                num1 = Integer.parseInt(textView.getText().toString());
                            }
                        }
                    }
                }
            }
            operator = false;
        });
    }

    public void numberClick (String view) {
        if (number == null) {
            number = view;
        } else {
            number = number + view;
        }

        textView.setText(number);
        operator = true;
    }

    public void Plus() {
        num2 = Integer.parseInt(textView.getText().toString());
        num1 = num1 + num2;
        textView.setText("" + num1);
    }

    public void Minus() {
        if (num1 == 0) {
            num1 = Integer.parseInt(textView.getText().toString());
        } else {
            num2 = Integer.parseInt(textView.getText().toString());
            num1 = num1 - num2;
        }
        textView.setText("" + num1);
    }

    public void Multiple() {
        if (num1 == 0) {
            num1 = Integer.parseInt(textView.getText().toString());
        } else {
            num2 = Integer.parseInt(textView.getText().toString());
            num1 = num2 * num1;
        }
        textView.setText("" + num1);
    }

    public void Div() {
        if (num1 == 0) {
            num1 = Integer.parseInt(textView.getText().toString());
        } else {
            num2 = Integer.parseInt(textView.getText().toString());
            num1 = num1 / num2;
        }
        textView.setText("" + num1);
    }


}