package aims.screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import aims.media.Media;
import aims.media.Playable;
import aims.cart.Cart;

public class MediaStore extends JPanel {
    public MediaStore(Media media, Cart cart) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel(media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        container.add(btnAddToCart);
        btnAddToCart.addActionListener(e -> {
            cart.addMedia(media);
            JOptionPane.showMessageDialog(null,
                    "Added " + media.getTitle() + " to cart!",
                    "Cart Update",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            container.add(btnPlay);
            btnPlay.addActionListener(e -> {
                JDialog playDialog = new JDialog((Frame) null, "Playing Media", true);
                playDialog.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

                JLabel label = new JLabel("Currently playing: " + media.getTitle());
                label.setFont(new Font(label.getFont().getName(), Font.BOLD, 14));
                playDialog.add(label);

                JButton btnClose = new JButton("Stop & Close");
                btnClose.addActionListener(evt -> playDialog.dispose());
                playDialog.add(btnClose);

                playDialog.setSize(300, 150);
                playDialog.setLocationRelativeTo(null);
                playDialog.setVisible(true);
            });
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}