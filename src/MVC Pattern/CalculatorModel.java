/**
 * 类名：calculatorModel
 * 包名：PACKAGE_NAME
 * 描述： 模型，负责数据和方法的实现
 * 作者: WM
 * 创建日期：2023/12/3
 * 版本号：V1.0
 */
public class CalculatorModel {
    private int calculationResolution;

    public void AddTwoNumber(int firstNumber,int secondNumber){
        this.calculationResolution = firstNumber + secondNumber;
    }

    public int getTheCalculaionSolution(){
        return this.calculationResolution;
    }

}
