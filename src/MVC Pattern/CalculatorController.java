import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 类名：calculatorController
 * 包名：PACKAGE_NAME
 * 描述：控制器，协调model和view
 * 作者: WM
 * 创建日期：2023/12/3
 * 版本号：V1.0
 */
public class CalculatorController {
    private CalculatorModel calcModel;
    private CalculatorView calcView;

    public CalculatorController(CalculatorModel theModel,CalculatorView theView){
        this.calcModel = theModel;
        this.calcView = theView;

        this.calcView.addCalculateListener(new CalculateListener());
    }

    class CalculateListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int firstNumber , secondNumber = 0;

            try{
                firstNumber = calcView.getFirstNumber();
                secondNumber = calcView.getSecondNumber();

                calcModel.AddTwoNumber(firstNumber,secondNumber);
                calcView.setCalculationResolution(calcModel.getTheCalculaionSolution());
            }
            catch (NumberFormatException ex){
                System.out.println(ex);
                calcView.displayErrorMessage("You need to enter 2 Integers");
            }
        }
    }

}
