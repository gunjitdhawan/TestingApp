package in.grappes.sampleapp.Model;

import java.util.List;

/**
 * Created by GunjitDhawan on 3/4/2016.
 */
public class Category {
    String label;
    String imageLink;
    String template;
    List<Item> itemList;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public List<Item> getItem() {
        return itemList;
    }

    public void setItem(List<Item> item) {
        this.itemList = item;
    }
}
