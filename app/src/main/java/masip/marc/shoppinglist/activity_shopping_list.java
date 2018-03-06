package masip.marc.shoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class activity_shopping_list extends AppCompatActivity {

    private ListView list;
    private ArrayList<String> items; //model de dades
    private ShoppingListAdapter adapter;
    private EditText new_item;

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
        new_item = (EditText) findViewById(R.id.new_item);//caixa text
        adapter = new ShoppingListAdapter(this, R.layout.shopping_item, items);

        list.setAdapter(adapter);

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int pos, long l) {
                onRemoveItem(pos);
                return true;
            }
        });
    }

    private void onRemoveItem(int pos) {
        items.remove(pos);//eliminem el item de la posició pos
        adapter.notifyDataSetChanged();//notifiquem el canvi
    }

    public void onAddItem(View view) {
        String item = new_item.getText().toString();
        if(!item.isEmpty()){
            items.add(item);
            adapter.notifyDataSetChanged();//li diem a l'adapter que les dades han canviat, que actualitzi la llista
            new_item.setText("");//esborrem el text
            list.smoothScrollToPosition(items.size()-1);//fes scroll fins a l'última posició (nou element)
        }
    }
}
