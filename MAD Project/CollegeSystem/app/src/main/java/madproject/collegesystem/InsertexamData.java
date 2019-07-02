package madproject.collegesystem;


import android.database.Cursor;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class InsertexamData extends AppCompatActivity {

    DBhelper db;

    EditText editstuid, editstuname, editmaths, editscience, editenglish, edithistory, editsinhala, editict, editit, editlit, editreligion, editcomm;
    Spinner editstuclass;
    Button btnaddData,btnupdateData;
    Button btnviewall,btndelData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertexam_data);

        db = new DBhelper(this);

        editstuid = (EditText) findViewById(R.id.stuid);
        editstuname = (EditText) findViewById(R.id.StuName);

        editstuclass = (Spinner) findViewById(R.id.stuclass);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(InsertexamData.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.classes));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        editstuclass.setAdapter(myAdapter);


        editmaths = (EditText) findViewById(R.id.mat);
        editscience = (EditText) findViewById(R.id.sci);
        editenglish = (EditText) findViewById(R.id.eng);
        edithistory = (EditText) findViewById(R.id.his);
        editsinhala = (EditText) findViewById(R.id.sin);
        editict = (EditText) findViewById(R.id.ict);
        editlit = (EditText) findViewById(R.id.lit);
        editcomm = (EditText) findViewById(R.id.com);
        editreligion = (EditText) findViewById(R.id.rel);


        btnaddData = (Button) findViewById(R.id.insertbutton);
        btnupdateData=(Button)findViewById(R.id.btnupdate);
        btnviewall = (Button) findViewById(R.id.btnview);
        btndelData=(Button)findViewById(R.id.btndel);



        addData();
        deletedata();
        viewdata();
        updateData();

        Button reset = (Button) findViewById(R.id.button2);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editstuid.setText("");
                editstuname.setText("");
                //editstuclass.setText("");

                editmaths.setText("");
                editscience.setText("");
                editenglish.setText("");
                edithistory.setText("");
                editsinhala.setText("");
                editict.setText("");
                editlit.setText("");
                editcomm.setText("");
                editreligion.setText("");

            }
        });

    }


    public void addData() {


        btnaddData.setOnClickListener(

                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {


                        String e1 = editstuid.getText().toString();
                        String e2 = editstuname.getText().toString();
                        String e3 = String.valueOf(editstuclass.getSelectedItem());

                        String e4 = editscience.getText().toString();
                        String e5 = editmaths.getText().toString();
                        String e6 = editenglish.getText().toString();
                        String e7 = edithistory.getText().toString();
                        String e8 = editlit.getText().toString();
                        String e9 = editcomm.getText().toString();
                        String e10 = editict.getText().toString();
                        String e11 = editreligion.getText().toString();
                        String e12 = editsinhala.getText().toString();


                        if (e1.length() == 0) {

                            Toast.makeText(InsertexamData.this, "Student ID field can not be Empty!!", Toast.LENGTH_LONG).show();


                        } else {


                            boolean isInserted = db.insertdata(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12);

                            if (isInserted) {

                                Toast.makeText(InsertexamData.this, "Data is Inserted!", Toast.LENGTH_LONG).show();
                            } else {

                                Toast.makeText(InsertexamData.this, "Somethin went wrong! Data is not Inserted", Toast.LENGTH_LONG).show();

                            }

                        }

                    }

                });



    }

    public void deletedata() {
        btndelData.setOnClickListener(

                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        String e1 = editstuid.getText().toString();

                        Integer deleteraws = db.deletedata(e1);
                        if(deleteraws>0){

                            Toast.makeText(InsertexamData.this, "Data Deleted Successfully!", Toast.LENGTH_LONG).show();

                        }
                        else{

                            Toast.makeText(InsertexamData.this, "Somethin went wrong! Data is not Deleted", Toast.LENGTH_LONG).show();

                        }

                    }

                }

        );
    }


    public void updateData(){

            btnupdateData.setOnClickListener(

                    new View.OnClickListener() {

                        @Override
                        public void onClick(View view)
                        {
                            String e1 = editstuid.getText().toString();
                            String e2 = editstuname.getText().toString();
                            String e3 = String.valueOf(editstuclass.getSelectedItem());

                            String e4 = editscience.getText().toString();
                            String e5 = editmaths.getText().toString();
                            String e6 = editenglish.getText().toString();
                            String e7 = edithistory.getText().toString();
                            String e8 = editlit.getText().toString();
                            String e9 = editcomm.getText().toString();
                            String e10 = editict.getText().toString();
                            String e11 = editreligion.getText().toString();
                            String e12 = editsinhala.getText().toString();

                            if (e1.length() == 0) {

                                Toast.makeText(InsertexamData.this, "Student ID field can not be Empty!!", Toast.LENGTH_LONG).show();


                            }


                            else {

                                boolean isUpdate = db.updateData(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12);

                                if (isUpdate) {

                                    Toast.makeText(InsertexamData.this, "Data is Updated!", Toast.LENGTH_LONG).show();

                                } else {

                                    Toast.makeText(InsertexamData.this, "Somethin went wrong! Data is not Updated", Toast.LENGTH_LONG).show();


                                }

                            }

                        }

                    }


            );
    }




    public void viewdata() {

        btnviewall.setOnClickListener(

                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Cursor res = db.getAlldata();
                        if (res.getCount() == 0) {
                            ///show...

                            showmessage("Error","Nothing Found!");


                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Student ID:" + res.getString(0) + "\n");
                            buffer.append("Name:" + res.getString(1) + "\n");
                            buffer.append("Class:" + res.getString(2) + "\n");
                            buffer.append("Science:" + res.getString(3) + "\n");
                            buffer.append("Maths:" + res.getString(4) + "\n");
                            buffer.append("English:" + res.getString(5) + "\n");
                            buffer.append("History:" + res.getString(6) + "\n");
                            buffer.append("English.Lit:" + res.getString(7) + "\n");
                            buffer.append("Commerce:" + res.getString(8) + "\n");
                            buffer.append("ICT:" + res.getString(9) + "\n");
                            buffer.append("Religion:" + res.getString(10) + "\n");
                            buffer.append("Sinhala:" + res.getString(11) + "\n\n");


                        }

                            ///show......

                        showmessage("Student Marks Info",buffer.toString());
                    }


                }


        );


    }




    public void showmessage(String title, String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }


}