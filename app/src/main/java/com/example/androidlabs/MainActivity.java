package com.example.androidlabs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.os.Bundle;
import android.widget.TextView;

import com.example.androidlabs.R;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public static final String ITEM_NAME = "NAME";
    public static final String ITEM_HEIGHT = "HEIGHT";
    public static final String ITEM_MASS = "MASS";
    private int position;
    private LinearLayout parent;
    ArrayAdapter<String> theAdapter;

    ArrayList<String> source = new ArrayList<>(Arrays.asList("One", "Two", "Three", "Four"));

   // ArrayList<String> source = new ArrayList<>(Arrays.asList(ITEM_NAME, ITEM_HEIGHT, ITEM_MASS));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyHTTPRequest req = new MyHTTPRequest();
        req.execute("http://swapi.dev/api/people/?format=json");


        ListView lvStarWars = (ListView) findViewById(R.id.lvStarWars);

//        boolean isTablet = findViewById(R.id.fragmentLocation) != null; //check if the FrameLayout is loaded

        theAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, source);
        lvStarWars.setAdapter(theAdapter);


    }




    private class MyHTTPRequest extends AsyncTask<String,Integer,String>
    {
      // public String doInBackground(String ... args)
    //  public String[] doInBackground(String ITEM_NAME,String ITEM_HEIGHT, String ITEM_MASS )
        {
           // while



            publishProgress(25);
            publishProgress(50);
            publishProgress(75);
          //  return "DONE";

           //  return result;
        }

        public void onProgressUpdate(Integer ... args)
        {

        }

        @Override
        protected String doInBackground(String... strings) {

            String[] result = new String[]{ITEM_NAME,ITEM_HEIGHT,ITEM_MASS};

            return null;
        }

        public void onPostExecute(String fromDoInBackground) {
            //super.onPostExecute(fromDoInBackground);

            Log.i("HTTP",fromDoInBackground);
        }

    }

    protected class runListView extends BaseAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ListView myList = findViewById(R.id.lvStarWars);

            LayoutInflater inflater = getLayoutInflater();

            // make a new row:
            View newView = inflater.inflate(R.layout.fragment_details, parent, false);

            TextView tView = newView.findViewById(R.id.tvNameFillMe);
            tView.setText( getItem(position).toString() );

            return newView;
           // return view;
        }
    }


}