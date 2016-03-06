package in.grappes.sampleapp.Activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import in.grappes.sampleapp.Adapters.VerticalFeedAdapter;
import in.grappes.sampleapp.Model.Category;
import in.grappes.sampleapp.Model.Item;
import in.grappes.sampleapp.R;

public class MainActivity extends AppCompatActivity {

    RecyclerView feedRecycler;
    VerticalFeedAdapter feedAdapter;

    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeRecyclerView();
        showList();

    }


    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("f_two.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }



    public void showList() {
        try {

            showProgressDialog();
            JSONArray categoryArray = new JSONArray(loadJSONFromAsset());
            List<Category> categoryList = new ArrayList<>();
            for(int i=0;i<categoryArray.length();i++)
            {
                Category obj = new Category();
                List<Item> itemList = new ArrayList<>();
                obj.setLabel(categoryArray.getJSONObject(i).getString("label"));
                obj.setTemplate(categoryArray.getJSONObject(i).getString("template"));
                for(int j=0;j<categoryArray.getJSONObject(i).getJSONArray("items").length();j++)
                {
                    Item item = new Item();
                    item.setItemLabel(categoryArray.getJSONObject(i).getJSONArray("items").getJSONObject(j).getString("label"));
                    item.setItemImageLink(categoryArray.getJSONObject(i).getJSONArray("items").getJSONObject(j).getString("image"));
                    itemList.add(item);
                }
                obj.setItem(itemList);
                categoryList.add(obj);
            }
            setAdapterToList(categoryList);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.dismiss();
                    }
                });

            }
        },2000);

    }

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("loading...");
        progressDialog.show();
    }

    private void setAdapterToList(List<Category> categoryList) {
        feedAdapter = new VerticalFeedAdapter(categoryList, MainActivity.this);
        feedRecycler.setAdapter(feedAdapter);
    }


    private void initializeRecyclerView() {
        feedRecycler = (RecyclerView) findViewById(R.id.feedRecyclerView);
        feedRecycler.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        feedRecycler.setLayoutManager(layoutManager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

}
