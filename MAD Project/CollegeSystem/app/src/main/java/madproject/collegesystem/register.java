package madproject.collegesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    DBhelper db;

    EditText adname, adpass;
    Button btnaddAdmin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DBhelper(this);

        adname = (EditText) findViewById(R.id.u);
        adpass = (EditText) findViewById(R.id.p);

        btnaddAdmin = (Button) findViewById(R.id.regibtn);

        addAdminData();

    }

    public void addAdminData() {


        btnaddAdmin.setOnClickListener(

                new View.OnClickListener()
                {

                    @Override
                    public void onClick(View view) {


                        String ad = adname.getText().toString();
                        String ps = adpass.getText().toString();

                        boolean isInserted = db.insertdatalogin(ad,ps);

                        if (isInserted) {

                            Toast.makeText(register.this, "You are registered successfully!", Toast.LENGTH_LONG).show();
                        } else {

                            Toast.makeText(register.this, "Somethin went wrong! please try again", Toast.LENGTH_LONG).show();

                        }



                    }


                }

             );


                 }












}
