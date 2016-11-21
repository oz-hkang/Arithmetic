import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  11/21/2016 09:25
 */
public class Main extends JFrame {
  //~ Static fields/initializers ---------------------------------------------------------------------------------------

  private static final long serialVersionUID = 8854703659153206227L;

  //~ Instance fields --------------------------------------------------------------------------------------------------

  private Arithmetic arithmetic = new Arithmetic();

  private JPanel contentPane;

  private int correctCount = 0;

  private ButtonGroup group      = new ButtonGroup();
  private int         questIndex = 0;
  private JLabel      title      = new JLabel();
  private int         wrongCount = 0;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * main.
   *
   * @param  args  String[]
   */
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (Throwable e) {
      e.printStackTrace();
    }

    EventQueue.invokeLater(new Runnable() {
        @Override public void run() {
          try {
            Main frame = new Main();
            frame.initFrame();
            frame.setVisible(true);
            frame.arithmetic();

            Toolkit   kit          = Toolkit.getDefaultToolkit();
            Dimension screenSize   = kit.getScreenSize();
            int       screenWidth  = screenSize.width / 2;
            int       screenHeight = screenSize.height / 2;

            int height = frame.getHeight();

            int width = frame.getWidth();

            frame.setLocation(screenWidth - (width / 2), screenHeight - (height / 2));
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      });
  } // end method main

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * JRadioButtonDemo.
   */
  public void initFrame() {
    setTitle("算术我们最棒");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 250, 200);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);

    contentPane.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    contentPane.add(title);

    for (int i = 0; i < arithmetic.numberOfAnswers; i++) {
      JRadioButton radioButton = new JRadioButton();
      contentPane.add(radioButton);
      group.add(radioButton);
    }


    JButton submit = new JButton("提交");
    JButton exit   = new JButton("退出");

    submit.addActionListener(new ActionListener() {
        @Override public void actionPerformed(ActionEvent e) {
          String selectedAnswer = GroupButtonUtils.getSelectedButtonText(group);

          if (null == selectedAnswer) {
            JOptionPane.showMessageDialog(null, "请选择一个答案", "提示",
              JOptionPane.INFORMATION_MESSAGE);
          } else if (arithmetic.correct(selectedAnswer)) {
            correctCount++;
            JOptionPane.showMessageDialog(null, "回答正确", "提示",
              JOptionPane.INFORMATION_MESSAGE);
            arithmetic();
          } else {
            wrongCount++;
            JOptionPane.showMessageDialog(null, "回答错误", "提示",
              JOptionPane.INFORMATION_MESSAGE);
            arithmetic();
          }

        }
      });
    exit.addActionListener(new ActionListener() {
        @Override public void actionPerformed(ActionEvent e) {
          JOptionPane.showMessageDialog(null,
            "回答总数:" + (correctCount + wrongCount) + "正确数:" + correctCount + "错误数:" + wrongCount, "提示",
            JOptionPane.INFORMATION_MESSAGE);
        }
      });
    contentPane.add(submit);
    contentPane.add(exit);
  } // end method initFrame

  //~ ------------------------------------------------------------------------------------------------------------------

  private void arithmetic() {
    questIndex++;
    arithmetic.produce();
    title.setText(questIndex + "," + arithmetic.title());
    System.out.println("Correct answer is :" + arithmetic.getCorrectAnswer());
    GroupButtonUtils.setButtonText(group, arithmetic.getAnswers());
    group.clearSelection();
  }

} // end class Main
