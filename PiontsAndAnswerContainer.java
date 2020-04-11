import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

class PointsAndAnswerContainer extends JPanel{
    ArrayList<JLabel> array;
    public PointsAndAnswerContainer(){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JLabel answer = new JLabel();
        answer.setPreferredSize(new Dimension(400, 25));
        answer.setMaximumSize(answer.getPreferredSize());
        JLabel points = new JLabel();
        array = new ArrayList<>();
        array.add(answer);
        array.add(points);
        this.add(answer);
        this.add(points);
    }
}
