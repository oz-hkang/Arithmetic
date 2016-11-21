import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;


/**
 * TODO: DOCUMENT ME!
 *
 * @author   <a href="mailto:hao.kang@ozstrategy.com">Hao Kang</a>
 * @version  11/21/2016 11:10
 */
public class GroupButtonUtils {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * getter method for selected button text.
   *
   * @param   buttonGroup  ButtonGroup
   *
   * @return  String
   */
  public static String getSelectedButtonText(ButtonGroup buttonGroup) {
    for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
      AbstractButton button = buttons.nextElement();

      if (button.isSelected()) {
        return button.getText();
      }
    }

    return null;
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * setter method for button text.
   *
   * @param  buttonGroup  ButtonGroup
   * @param  texts        List
   */
  public static void setButtonText(ButtonGroup buttonGroup, List<Integer> texts) {
    int index = 0;

    for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
      AbstractButton button = buttons.nextElement();
      button.setText(texts.get(index).toString());
      index++;
    }
  }
} // end class GroupButtonUtils
