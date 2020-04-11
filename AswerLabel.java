import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

class AnswerLabel extends JLabel {

    AnswerLabel(){
        //JLabel label = new JLabel();
        this.setForeground(Color.LIGHT_GRAY);
        this.setBorder(new CompoundBorder( // sets two borders
                BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE), // outer border
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        this.setPreferredSize(new Dimension(400, 25));
        this.setMaximumSize(this.getPreferredSize());
    }
}
