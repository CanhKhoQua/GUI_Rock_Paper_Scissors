import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RockPaperScissorsFrame extends JFrame {
    JPanel mainPnl;
    JPanel displayPnl;
    JTextArea textArea;
    JScrollPane scroller;
    JPanel statPnl;
    JTextField pWinCountTF;
    JTextField cWinCountTF;
    JTextField tieCountTF;
    JLabel pWinLbl;
    JLabel cWinLbl;
    JLabel tieLbl;
    JPanel actionPnl;
    JButton rockBtn;
    JButton paperBtn;
    JButton scissorsBtn;
    JButton quitBtn;
    int playerWinCount = 0;
    int comWinCount = 0;
    int tieCount = 0;
    public RockPaperScissorsFrame()
    {
        //Setting Layout
        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());

        createDisplayPanel();
        createStatPanel();
        createActionPanel();

        mainPnl.add(statPnl, BorderLayout.NORTH);
        mainPnl.add(displayPnl, BorderLayout.CENTER);
        mainPnl.add(actionPnl, BorderLayout.SOUTH);

        add(mainPnl);
        pack();
    }
    private void createDisplayPanel()
    {
        displayPnl = new JPanel();
        textArea = new JTextArea(15,50);
        textArea.setFont(new Font("Serif",Font.PLAIN,14));
        textArea.setEditable(false);

        scroller = new JScrollPane(textArea);
        displayPnl.add(scroller);
    }
    private void createStatPanel()
    {
        statPnl = new JPanel();
        statPnl.setLayout(new GridLayout(3,2));
        statPnl.setLayout(new FlowLayout(FlowLayout.CENTER));

        pWinLbl = new JLabel("Player won: ");
        pWinCountTF = new JTextField();
        pWinCountTF.setText(String.valueOf(playerWinCount));
        pWinCountTF.setEditable(false);

        cWinLbl = new JLabel("Com won: ");
        cWinCountTF = new JTextField();
        cWinCountTF.setText(String.valueOf(comWinCount));
        cWinCountTF.setEditable(false);


        tieLbl = new JLabel("Tie: ");
        tieCountTF = new JTextField();
        tieCountTF.setText(String.valueOf(tieCount));
        tieCountTF.setEditable(false);

        //Since using GridLayout, we must add labels and text fields in order.
        statPnl.add(pWinLbl);
        statPnl.add(pWinCountTF);

        statPnl.add(cWinLbl);
        statPnl.add(cWinCountTF);

        statPnl.add(tieLbl);
        statPnl.add(tieCountTF);
    }
    private void createActionPanel()
    {
        actionPnl = new JPanel();
        actionPnl.setLayout(new GridLayout(1,4));
        //Adding images to buttons (making it fit inside buttons)
        ImageIcon rock = new ImageIcon("src/rock.png");
        Image rockImg = rock.getImage().getScaledInstance(100,100,Image.SCALE_AREA_AVERAGING);
        rock = new ImageIcon(rockImg);

        ImageIcon paper = new ImageIcon("src/paper.png");
        Image paperImg = paper.getImage().getScaledInstance(100,100,Image.SCALE_AREA_AVERAGING);
        paper = new ImageIcon(paperImg);

        ImageIcon scissors = new ImageIcon("src/scissors.png");
        Image scissorsImg = scissors.getImage().getScaledInstance(100,100,Image.SCALE_AREA_AVERAGING);
        scissors = new ImageIcon(scissorsImg);

        rockBtn = new JButton();
        paperBtn = new JButton();
        scissorsBtn = new JButton();
        quitBtn = new JButton("Exit");
        rockBtn.setIcon(rock);
        paperBtn.setIcon(paper);
        scissorsBtn.setIcon(scissors);

        rockBtn.addActionListener(e -> {
            Random rand = new Random();
            int com = rand.nextInt(3)+1;
            //1: Rock
            //2: Paper
            //3: Scissors
            if (com==1)
            {
                tieCount++;
                tieCountTF.setText(String.valueOf(tieCount));
                textArea.append("It's a tie, the computer chose Rock! \n");
            }else if (com==2)
            {
                comWinCount++;
                cWinCountTF.setText(String.valueOf(comWinCount));
                textArea.append("Paper covers Rock, the computer wins! \n");
            }else
            {
                playerWinCount++;
                pWinCountTF.setText(String.valueOf(playerWinCount));
                textArea.append("Rock breaks Scissors, you win! \n");
            }

        });
        paperBtn.addActionListener(e -> {
            Random rand = new Random();
            int com = rand.nextInt(3)+1;
            //1: Rock
            //2: Paper
            //3: Scissors
            if (com==1)
            {
                playerWinCount++;
                pWinCountTF.setText(String.valueOf(playerWinCount));
                textArea.append("Paper covers Rock, you win! \n");
            }else if (com==2)
            {
                tieCount++;
                tieCountTF.setText(String.valueOf(tieCount));
                textArea.append("It's a tie, the computer chose Paper! \n");
            }else
            {
                comWinCount++;
                cWinCountTF.setText(String.valueOf(comWinCount));
                textArea.append("Rock breaks Scissors, the computer wins! \n");
            }
        });
        scissorsBtn.addActionListener(e -> {
            Random rand = new Random();
            int com = rand.nextInt(3)+1;
            //1: Rock
            //2: Paper
            //3: Scissors
            if (com==1)
            {
                comWinCount++;
                cWinCountTF.setText(String.valueOf(comWinCount));
                textArea.append("Rock breaks Scissors, the computer wins! \n");
            }else if (com==2)
            {
                playerWinCount++;
                pWinCountTF.setText(String.valueOf(playerWinCount));
                textArea.append("Scissors cut Paper, you win! \n");
            }else
            {
                tieCount++;
                tieCountTF.setText(String.valueOf(tieCount));
                textArea.append("It's a tie, the computer chose Scissors! \n");
            }
        });

        quitBtn.addActionListener(e ->
                {
                    System.exit(0);
                }
                );

        actionPnl.add(rockBtn);
        actionPnl.add(paperBtn);
        actionPnl.add(scissorsBtn);
        actionPnl.add(quitBtn);
    }
}
