package madproject.collegesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ExamorAverage extends AppCompatActivity {

    private static Button btnexaminsert1;
    private static Button btngpa1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examor_average);

        OnClickButtonListenermarkinsert();
        OnClickButtonListenercalcgpa();





    }

    public void OnClickButtonListenermarkinsert() {

        btnexaminsert1 = (Button) findViewById(R.id.btnexaminsert);
        btnexaminsert1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(ExamorAverage.this,InsertexamData.class);
                        startActivity(intent);

                    }


                });


    }


    public void OnClickButtonListenercalcgpa() {

        btngpa1 = (Button) findViewById(R.id.btngpa);
        btngpa1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(ExamorAverage.this,AverageCalculator.class);
                        startActivity(intent);

                    }


                });


    }



}
