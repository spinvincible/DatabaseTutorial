package com.example.saurabhpandey.databasetutorial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class DatabseTest2 extends ActionBarActivity {
    EditText usernamePrint, passwordPrint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_databse_test2);

        usernamePrint = (EditText) findViewById(R.id.editTextUsernamePrint);
        passwordPrint = (EditText) findViewById(R.id.editTextPasswordPrint);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_databse_test2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void homeScreen(View view) {

        Intent intent = new Intent(DatabseTest2.this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Taking you to HomeScreen", Toast.LENGTH_LONG).show();
    }

    public void showData(View view) {

FileInputStream fileInputStream = null;
        try {
            fileInputStream = openFileInput("SaurabhDatabase.txt");
            StringBuffer stringBuffer = new StringBuffer();
            int read = -1;
            while ((read = fileInputStream.read()) != -1) {
                stringBuffer.append((char) read);
            }

            String username = stringBuffer.substring(0, stringBuffer.indexOf("  "));
            String password = stringBuffer.substring(stringBuffer.indexOf("  ") + 1);
            usernamePrint.setText(username);
            passwordPrint.setText(password);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
