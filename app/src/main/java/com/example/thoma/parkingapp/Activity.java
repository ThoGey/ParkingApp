package com.example.thoma.parkingapp;

/**
 * Created by thoma on 11/16/2015.
 */
public class Activity {
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;

    public void addParking(View view)
    {
        String name=Name.getText().toString();
        String mob= .getText().toString();
        String email=EmailAddress.getText().toString();
        userDbHelper=new UserDbHelper(context);
        sqLiteDatabase=userDbHelper.getWritableDatabase();
        userDbHelper.addinnformation(name,mob,email,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Data saved",Toast.LENGTH_LONG).show();
        userDbHelper.close();
    }
}
