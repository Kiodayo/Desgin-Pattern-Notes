/**
 * 类名：${NAME}
 * 包名：
 * 描述：
 * 作者: WM
 * 创建日期：${DATE}
 * 版本号：V1.0
 */
public class MVCCalculator {
    public static void main(String[] args) {
        CalculatorModel calcModel = new CalculatorModel();
        CalculatorView calcView = new CalculatorView();
        CalculatorController calcController = new CalculatorController(calcModel,calcView);
        //显示视图
        calcView.setVisible(true);
    }
}