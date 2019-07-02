package madproject.collegesystem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

        public class AverageCalculator extends AppCompatActivity {

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_average_calculator);

                Button reset=(Button)findViewById(R.id.reset);
                reset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText e1=(EditText)findViewById(R.id.txt1);
                        EditText e2=(EditText)findViewById(R.id.txt2);
                        EditText e3=(EditText)findViewById(R.id.txt3);
                        EditText e4=(EditText)findViewById(R.id.txt);
                        EditText e5=(EditText)findViewById(R.id.txt5);
                        EditText e6=(EditText)findViewById(R.id.txt6);


                        EditText e7=(EditText)findViewById(R.id.txt7);
                        EditText e8=(EditText)findViewById(R.id.txt8);
                        EditText e9=(EditText)findViewById(R.id.txt9);

                        Button b1=(Button)findViewById(R.id.btn1);


                        e1.setText("");
                        e2.setText("");
                        e3.setText("");
                        e4.setText("");
                        e5.setText("");
                        e6.setText("");
                        e7.setText("");
                        e8.setText("");
                        e9.setText("");
                        b1.setText("Calculate Average Marks");

                    }
                });

            }


            public void onButtonClick(View v)
            {
                EditText e1=(EditText)findViewById(R.id.txt1);
                EditText e2=(EditText)findViewById(R.id.txt2);
                EditText e3=(EditText)findViewById(R.id.txt3);
                EditText e4=(EditText)findViewById(R.id.txt);
                EditText e5=(EditText)findViewById(R.id.txt5);
                EditText e6=(EditText)findViewById(R.id.txt6);
                EditText e7=(EditText)findViewById(R.id.txt7);
                EditText e8=(EditText)findViewById(R.id.txt8);
                EditText e9=(EditText)findViewById(R.id.txt9);

                Button b1=(Button)findViewById(R.id.btn1);

                Double num1=Double.parseDouble(e1.getText().toString());
                Double num2=Double.parseDouble(e2.getText().toString());
                Double num3=Double.parseDouble(e3.getText().toString());
                Double num4=Double.parseDouble(e4.getText().toString());
                Double num5=Double.parseDouble(e5.getText().toString());
                Double num6=Double.parseDouble(e6.getText().toString());
                Double num7=Double.parseDouble(e7.getText().toString());
                Double num8=Double.parseDouble(e8.getText().toString());
                Double num9=Double.parseDouble(e9.getText().toString());


                double sum=(num1+num2+num3+num4+num5+num6+num7+num8+num9)/9;

                b1.setText(Double.toString(sum));

            }


        }
