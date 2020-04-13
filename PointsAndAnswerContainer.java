import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.ArrayList;

class PointsAndAnswerContainer extends JPanel{
    ArrayList<JLabel> array;
    public PointsAndAnswerContainer(){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.GRAY);
        this.setPreferredSize(new Dimension(570, 30));
        this.setMaximumSize(this.getPreferredSize());
        this.setMinimumSize(this.getMaximumSize());
        JLabel answer = new JLabel();
        answer.setFont(new Font("Impact", Font.PLAIN, 20));
        answer.setBorder(new EmptyBorder(10,10,10,10));
        JLabel points = new JLabel();
        points.setFont(new Font("Impact", Font.PLAIN, 20));
        points.setBorder(new EmptyBorder(10,10,10,10));
        //points.setHorizontalAlignment(SwingConstants.RIGHT);
        array = new ArrayList<>();
        array.add(answer);
        array.add(points);
        this.add(answer, BorderLayout.WEST);
        this.add(points, BorderLayout.EAST);
    }
}
