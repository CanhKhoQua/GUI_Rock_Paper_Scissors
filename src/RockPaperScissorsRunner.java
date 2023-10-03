import javax.swing.*;
import java.awt.*;

public class RockPaperScissorsRunner {
    public static void main(String[] args) {
        RockPaperScissorsFrame frame = new RockPaperScissorsFrame();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize(800,600);
        frame.setLocation(width/4,height/20);

        frame.setTitle("Rock Paper Scissors");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
