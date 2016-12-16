package com.example.prakhar.justjava;

/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int num=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        float price = calcprice();
        CheckBox yo = (CheckBox) findViewById(R.id.check1);
        CheckBox yo1 = (CheckBox) findViewById(R.id.check2);
        EditText yourname = (EditText) findViewById(R.id.name);
        Boolean hello1 = yo1.isChecked();
        if(hello1)
            price = price + 2*num;
        Boolean hello = yo.isChecked();
        if(hello)
            price = price+ 1*num;
        String name1 = yourname.getText().toString();
//        displaymessage(ordersum(price,hello,hello1,name1));
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "order from mycoffee house for " +name1);
        intent.putExtra(Intent.EXTRA_TEXT,ordersum(price,hello,hello1,name1));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
    private float calcprice()
    {
        return num*5;
    }
    private String ordersum(float price,Boolean hello,Boolean hello1,String name1)
    {

        String message = "NAME: "+name1+"\nQUANTITY: "+num+"\nWhipped cream ? "+hello+"\nChocolate ? "+hello1+"\nTOTAL PRICE : $"+price +"\nTHANK YOU !!";
        return message;
    }

    public void increment(View view){
        if(num==50) {
            Toast.makeText(this,"you cannot have more than 50 coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        num=num+1;
        display(num);
    }
    public void decrement(View view){
        if(num<1) {
            Toast.makeText(this,"you cannot have less than 0 coffee",Toast.LENGTH_SHORT).show();
            return;
        }
        num=num-1;
       ;
        display(num);
    }

    /**
     * This method displays the given quantity value on the screen.
     */

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

}