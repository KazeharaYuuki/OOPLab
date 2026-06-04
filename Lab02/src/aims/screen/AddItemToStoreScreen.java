package aims.screen;

import aims.store.Store;
import java.awt.*;
import javax.swing.*;


public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected JPanel centerPanel;

    public AddItemToStoreScreen(Store store, String title) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createMenuBar(), BorderLayout.NORTH);

        centerPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        cp.add(centerPanel, BorderLayout.CENTER);

        JButton btnAdd = new JButton("Add Item");
        btnAdd.addActionListener(e -> btnAddPressed());
        cp.add(btnAdd, BorderLayout.SOUTH);

        setTitle(title);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));
        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    protected JTextField addFormField(String labelText) {
        centerPanel.add(new JLabel(labelText));
        JTextField textField = new JTextField();
        centerPanel.add(textField);
        return textField;
    }

    protected abstract void btnAddPressed();
}