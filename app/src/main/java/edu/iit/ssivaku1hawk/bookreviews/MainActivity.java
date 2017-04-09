package edu.iit.ssivaku1hawk.bookreviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ArrayList<String> list1 = new ArrayList<String>();
    SqlHelper db = new SqlHelper(this);

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_spinner_dropdown_item);
        Log.i("Name:Satish Sivakumar","CWID : A20351121");


        /** CRUD Operations **/
        // add Books

//        db.addBook(new Book("Professional Android 4 Application Development", "Reto Meier"));
//        db.addBook(new Book("Beginning Android 4 Application Development", "Wei-Meng Lee"));
//        db.addBook(new Book("Programming Android", "Wallace Jackson"));
//        db.addBook(new Book("Hello, Android", "Wallace Jackson"));

        // get all books
        List<Book> list = db.getAllBooks();

        // update one book
        //int j = db.updateBook(list.get(3),"Hello Android","Ben Jackson");

        // delete one book
        //db.deleteBook(list.get(0));

        // get all books
        db.getAllBooks();
        ListView listContent = (ListView) findViewById(R.id.list);
        List<Book> books = new ArrayList<Book>();
        books=db.getAllBooks();

//        //get data from the table by the ListAdapter
//        ListAdapter customAdapter = new ListAdapter(this, R.layout.itemlistrow,  books);
//        listContent.setAdapter(customAdapter);


        Spinner spinner = (Spinner) findViewById(R.id.spinner1);
        list1.add("Select Analytics...");
        list1.add("Get Highest Rated Title(s)");
        list1.add("Get Lowest Rated Title(s)");
        list1.add("Get Record Count");
        list1.add("Retrieve Title(s) with Android 4");

        // Create the ArrayAdapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this
                ,android.R.layout.simple_spinner_dropdown_item,list1);
        arrayAdapter.setDropDownViewResource(R.layout.spinner_dropdown_list);
        // Set the Adapter
        spinner.setAdapter(arrayAdapter);

        // Set the ClickListener for Spinner
        spinner.setOnItemSelectedListener(new  AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> arg0,
                                       View arg1, int position, long arg3) {
                // TODO Auto-generated method stub

                if(position==1) {
                    // String rating=db.getHighestRating(1);
                    String title=db.getHighestTitle();


                    Toast.makeText(MainActivity.this, "You Selected : "
                            + list1.get(position) + " Level  " + title, Toast.LENGTH_LONG).show();
                }
                if(position==2) {
                    //String rating=db.getLowestRating();
                    String title=db.getLowestTitle();
                    Toast.makeText(MainActivity.this, "You Selected : "
                                + list1.get(position) + " Level  " + title, Toast.LENGTH_LONG).show();
                }
                if(position==3)
                {
                    int count=db.getIds();
                    Toast.makeText(MainActivity.this, "You Selected : "
                            + list1.get(position) + " Level  " + count, Toast.LENGTH_LONG).show();
                }
                if(position==4)
                {
                    String title3=db.getSpecificTitle();
                    Toast.makeText(MainActivity.this,"You Selected : "
                            + list1.get(position) +" Level  " +title3, Toast.LENGTH_LONG).show();
                }


            }
            // If no option selected
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }

        });


    }
}