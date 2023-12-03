import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * 类名：calculatorView
 * 包名：PACKAGE_NAME
 * 描述： 作为View，实现用户交互时，用户所看到的画面，隐藏了内部的实现
 * 作者: WM
 * 创建日期：2023/12/3
 * 版本号：V1.0
 */
public class CalculatorView extends JFrame {
    //宽10px
    private JTextField firstNumber = new JTextField(10);
    private JLabel additionLabel = new JLabel("+");
    private JTextField secondNumber = new JTextField(10);
    private JButton calculatorButton = new JButton("Calculate");
    private JTextField calculationResolution = new JTextField(10);

    public CalculatorView() {
        //Sets up the view and adds the components
        JPanel calcPanel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);

        calcPanel.add(firstNumber);
        calcPanel.add(additionLabel);
        calcPanel.add(secondNumber);
        calcPanel.add(calculatorButton);
        calcPanel.add(calculationResolution);

        this.add(calcPanel);
    }

    public int getFirstNumber(){
        return Integer.parseInt(firstNumber.getText());
    }
    public int getSecondNumber(){
        return Integer.parseInt(secondNumber.getText());
    }
    public int getCalculationSolution(){
        return Integer.parseInt(calculationResolution.getText());
    }

    public void setCalculationResolution(int solution){
        calculationResolution.setText(Integer.toString(solution));
    }

    //监听事件
    void addCalculateListener(ActionListener listenerForCalcButton){
        calculatorButton.addActionListener(listenerForCalcButton);
    }
    void displayErrorMessage(String errorMessage){
        JOptionPane.showMessageDialog(this,errorMessage);
    }
}