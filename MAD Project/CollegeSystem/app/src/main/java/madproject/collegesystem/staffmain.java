package madproject.collegesystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class staffmain extends AppCompatActivity {


    private static Button btnsubmit;
    private static Button btnsubmit1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staffmain);

        OnClickButtonListener();
        OnClickButtonListener1();


    }



    public void OnClickButtonListener() {

        btnsubmit = (Button) findViewById(R.id.leave);
        btnsubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(staffmain.this,leaveapplication.class);
                        startActivity(intent);

                    }


                });


    }


    public void OnClickButtonListener1() {

        btnsubmit1 = (Button) findViewById(R.id.staffregi);
        btnsubmit1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(staffmain.this,staffregistration.class);
                        startActivity(intent);

                    }


                });


    }














}
