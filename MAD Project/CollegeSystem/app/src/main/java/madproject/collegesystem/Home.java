package madproject.collegesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    private static Button btnstudent;
    private static Button btnstaff;
    private static Button btnexam;
    private static Button btnlab;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        OnClickButtonListenerstudent();
        OnClickButtonListenerstaff();
        OnClickButtonListenerexam();
        OnClickButtonListenerlab();

    }

    public void OnClickButtonListenerstudent()
    {

        btnstudent = (Button) findViewById(R.id.student);
        btnstudent.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(Home.this,StudentUI.class);
                        startActivity(intent);

                    }


                });


    }


    public void OnClickButtonListenerstaff()
    {

        btnstaff = (Button) findViewById(R.id.teacher);
        btnstaff.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(Home.this,staffmain.class);
                        startActivity(intent);

                    }


                });


    }


    public void OnClickButtonListenerexam()
    {

        btnexam = (Button) findViewById(R.id.exam);
        btnexam.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(Home.this,ExamorAverage.class);
                        startActivity(intent);

                    }


                });


    }

    public void OnClickButtonListenerlab()
    {

        btnlab = (Button) findViewById(R.id.lab);
        btnlab.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(Home.this,LabUI.class);
                        startActivity(intent);

                    }


                });


    }



}
