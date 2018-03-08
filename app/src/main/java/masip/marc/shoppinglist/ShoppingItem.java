package masip.marc.shoppinglist;

/**
 * Created by marcmc6 on 08/03/2018.
 */

public class ShoppingItem {
    private boolean checked;//si esta marcat o no l'element
    private String text;

    public ShoppingItem(String text) {//opció code->generate->constructor
        this.text = text;
        this.checked = false;//si només passa l'string per defecte false
    }

    public ShoppingItem(boolean checked, String text) {
        this.checked = checked;
        this.text = text;
    }

    public boolean isChecked() {//opció code->generate->getter and setter
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void toggleChecked() {
        this.checked = !this.checked;
    }
}
