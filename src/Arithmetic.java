import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by coin on 11/21/16.
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  11/21/2016 09:31
 */
public class Arithmetic {
  //~ Instance fields --------------------------------------------------------------------------------------------------

  /** TODO: DOCUMENT ME! */
  public final int numberOfAnswers = 4;

  private List<Integer> answers;

  private String    correctAnswer;
  private final int numberOfArithmetic = 3; // 可以放在配置文件里面
  private String    title;

  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * correct.
   *
   * @param   chooseAnswer  int
   *
   * @return  Boolean
   */
  public Boolean correct(String chooseAnswer) {
    return correctAnswer.equals(chooseAnswer);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * answers.
   *
   * @return  String[]
   */
  public List<Integer> getAnswers() {
    return answers;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * getter method for correct answer.
   *
   * @return  String
   */
  public String getCorrectAnswer() {
    return correctAnswer;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * produce.
   */
  public void produce() {
    List<Integer> temps = new ArrayList<>();
    answers = new ArrayList<>();

    for (int i = 0; i < numberOfArithmetic; i++) {
      int temp = getRandom(200);
      temps.add(temp);
    }

    StringBuffer sbf    = new StringBuffer("请回答");
    Integer      result = 0;

    Boolean first = Boolean.TRUE;

    for (Integer operand : temps) {
      if (first) {
        sbf.append(operand);
        result = operand;
        first  = Boolean.FALSE;

        continue;
      }

      int operator = getRandom(2);

      if (operator == 0) {
        result = result + operand;
        sbf.append("+");
        sbf.append(operand);

      } else {
        result = result - operand;
        sbf.append("-");
        sbf.append(operand);

      }
    }

    int correctIndex = getRandom(4);
    sbf.append("=?");
    title         = sbf.toString();
    correctAnswer = result.toString();

    for (int i = 0; i < numberOfAnswers; i++) {
      if (i == correctIndex) {
        answers.add(result);
      } else {
        answers.add(getRandom(10000));
      }
    }


  } // end method produce

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * title.
   *
   * @return  String
   */
  public String title() {
    return title;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  private int getRandom(int max) {
    Random random = new Random();

    return random.nextInt(max);
  }
} // end class Arithmetic
