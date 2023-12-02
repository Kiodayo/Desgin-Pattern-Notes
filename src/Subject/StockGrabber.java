package Subject;

import java.util.ArrayList;
import Observer.Observer;

/**
 * 类名：StockGrabber
 * 包名：Subject
 * 描述：
 * 作者: WM
 * 创建日期：2023/12/2
 * 版本号：V1.0
 */
public class StockGrabber implements Subject{
    private ArrayList<Observer> observers;
    //观察者观察的数据
    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;
    public StockGrabber(){
        observers = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer O) {
        observers.add(O);
    }

    @Override
    public void unregister(Observer O) {
        int observerIndex =observers.indexOf(O);
        System.out.println("Observer"+ (observerIndex + 1) + " deleted");
        observers.remove(observerIndex);
    }


    @Override
    public void notifyOberver() {
        for(Observer observer : observers){
            observer.Update(ibmPrice,aaplPrice,googPrice);
        }
    }

    public void setIBMPrice(double newIBMPrice){
        this.ibmPrice = newIBMPrice;
        notifyOberver();
    }
    public void setAaplPrice(double newAaplerice){
        this.aaplPrice = newAaplerice;
        notifyOberver();
    }
    public void setGoogPrice(double newGoogPrice){
        this.googPrice = newGoogPrice;
        notifyOberver();
    }
}
