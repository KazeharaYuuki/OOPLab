package aims.screen;

import aims.media.DigitalVideoDisc;
import aims.store.Store;
import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfTitle, tfCategory, tfDirector, tfLength, tfCost;

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD to Store");

        tfTitle = addFormField("Title:");
        tfCategory = addFormField("Category:");
        tfDirector = addFormField("Director:");
        tfLength = addFormField("Length:");
        tfCost = addFormField("Cost ($):");

        setVisible(true);
    }

    @Override
    protected void btnAddPressed() {
        try {
            String title = tfTitle.getText();
            String category = tfCategory.getText();
            String director = tfDirector.getText();
            int length = Integer.parseInt(tfLength.getText());
            float cost = Float.parseFloat(tfCost.getText());

            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            store.addMedia(dvd);

            JOptionPane.showMessageDialog(this, "DVD added successfully!");
            this.dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Length and Cost must be numbers!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}