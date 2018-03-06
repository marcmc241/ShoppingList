package masip.marc.shoppinglist;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import java.util.List;

/**
 * Created by marcmc6 on 06/03/2018.
 */

public class ShoppingListAdapter extends ArrayAdapter<String> {
    public ShoppingListAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //1. crear un nou View si és necessari (no cal si convertView no és null)
        View root = convertView;//si no hi ha element de la llista suficient per omplir la pantalla creat
        if (root == null){
            LayoutInflater inflater = LayoutInflater.from(getContext()); //fora d'activities hem de passar el context
            root = inflater.inflate(R.layout.shopping_item, parent, false);//resource file

        }
        CheckBox checkBox = (CheckBox) root.findViewById(R.id.checkBox);
        String item = getItem(position);
        checkBox.setText(item);

        return root;
    }
}
