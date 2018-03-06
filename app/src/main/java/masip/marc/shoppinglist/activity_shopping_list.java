package masip.marc.shoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class activity_shopping_list extends AppCompatActivity {

    private ListView list;
    private ArrayList<String> items; //model de dades
    private ShoppingListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        //omplim el model de dades
        items = new ArrayList<>();
        items.add("Patates");
        items.add("Paper WC");
        items.add("Ketchup");

        list = (ListView) findViewById(R.id.list);

        adapter = new ShoppingListAdapter(this, R.layout.shopping_item, items);

        list.setAdapter(adapter);
    }
}
