import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame{

    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            switch (e.getActionCommand()){
                case ("Equal"): {
                    textField1.setText(Logic.deem());
                    // Установить доступность арифметических полей.
                    setAvailabilityOfArithmeticFields(Logic.operationIntroduced);

                    break;
                }
                case("Clean"): {
                    textField1.setText("");
                Logic.cleanAllParametrs();
                    // Установить доступность арифметических полей.
                    setAvailabilityOfArithmeticFields(Logic.operationIntroduced);

                    break;
                }
                case("Div"): {
                    // тип чар - номер знака деления по таблице ASCII.
                    textField1.setText(textField1.getText() + (char)247);
                    Logic.setOperation(e.getActionCommand());
                    // Установить доступность арифметических полей.
                    setAvailabilityOfArithmeticFields(Logic.operationIntroduced);

                    break;
                }
                case("Plus"): {
                    textField1.setText(textField1.getText() + " + ");
                    Logic.setOperation(e.getActionCommand());
                    // Установить доступность арифметических полей.
                    setAvailabilityOfArithmeticFields(Logic.operationIntroduced);

                    break;
                }
                case("Minus"): {
                    textField1.setText(textField1.getText() + " - ");
                    Logic.setOperation(e.getActionCommand());
                    // Установить доступность арифметических полей.
                    setAvailabilityOfArithmeticFields(Logic.operationIntroduced);

                    break;
                }
                case("Multiply"): {
                    textField1.setText(textField1.getText() + " * ");
                    Logic.setOperation(e.getActionCommand());
                    // Установить доступность арифметических полей.
                    setAvailabilityOfArithmeticFields(Logic.operationIntroduced);

                    break;
                }
                case("Degree"): {
                    textField1.setText(textField1.getText() + " ^ ");
                    Logic.setOperation(e.getActionCommand());
                    // Установить доступность арифметических полей.
                    setAvailabilityOfArithmeticFields(Logic.operationIntroduced);

                    break;
                }
                // Остальный значения - только цифры.
                default: {
                    if (Logic.isFullArgument() == true) {
                        JOptionPane.showMessageDialog(rootPanel,
                                "Невозможно ввести более 15 цифр.");
                        return;
                    }

                    textField1.setText(textField1.getText() + e.getActionCommand());
                    Logic.setCurrentArgument(e.getActionCommand());
                    }
            }
        }
    };

    private JPanel rootPanel;
    private JTextField textField1;
    private JButton buttonClean;
    private JButton buttonEqual;
    private JButton buttonMultiply;
    private JButton buttonMinus;
    private JButton buttonPlus;
    private JButton buttonDiv;
    private JButton buttonDegree;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;

    public void setAvailabilityOfArithmeticFields(boolean isOperationIntroduced){
        buttonDiv.setEnabled(!isOperationIntroduced);
        buttonMultiply.setEnabled(!isOperationIntroduced);
        buttonMinus.setEnabled(!isOperationIntroduced);
        buttonPlus.setEnabled(!isOperationIntroduced);
        buttonDegree.setEnabled(!isOperationIntroduced);
    }

    public Window() {
        // Установить операции для кнопок.
        SetActions();

        // Установить панель из формы.
        setContentPane(rootPanel);

        // Операция при закрытии окна.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Расположить по центру экрана.
        setLocationRelativeTo(null);

        // Размер окна.
        setPreferredSize(new Dimension(550, 300));
        // Применить заданные параметры размера окна.
        pack();
        // Установить видимость окна.
        setVisible(true);
    }

    private void SetActions(){
        buttonClean.setActionCommand("Clean");
        buttonClean.addActionListener(al);

        buttonDiv.setActionCommand("Div");
        buttonDiv.addActionListener(al);

        buttonPlus.setActionCommand("Plus");
        buttonPlus.addActionListener(al);

        buttonMinus.setActionCommand("Minus");
        buttonMinus.addActionListener(al);

        buttonMultiply.setActionCommand("Multiply");
        buttonMultiply.addActionListener(al);

        buttonDegree.setActionCommand("Degree");
        buttonDegree.addActionListener(al);

        buttonEqual.setActionCommand("Equal");
        buttonEqual.addActionListener(al);

        button0.setActionCommand("0");
        button0.addActionListener(al);

        button1.setActionCommand("1");
        button1.addActionListener(al);

        button2.setActionCommand("2");
        button2.addActionListener(al);

        button3.setActionCommand("3");
        button3.addActionListener(al);

        button4.setActionCommand("4");
        button4.addActionListener(al);

        button5.setActionCommand("5");
        button5.addActionListener(al);

        button6.setActionCommand("6");
        button6.addActionListener(al);

        button7.setActionCommand("7");
        button7.addActionListener(al);

        button8.setActionCommand("8");
        button8.addActionListener(al);

        button9.setActionCommand("9");
        button9.addActionListener(al);
    }

}
