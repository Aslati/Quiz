import javax.swing.*;

class SimpleTextWindow extends JFrame {
    SimpleTextWindow(String text, boolean doClose, boolean isJoke){
        JLabel label = new JLabel(text);
        this.add(label);
        if(doClose){
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        }
        if(isJoke){
            JButton button = new JButton("I laughed");
            button.addActionListener(e ->{
                Controller.startGame();
                this.setVisible(false);
            } );
            JPanel panel = new JPanel();
            panel.add(label);
            panel.add(button);
            this.add(panel);
        }
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
