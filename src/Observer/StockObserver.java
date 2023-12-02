package Observer;

import Subject.Subject;

/**
 * 类名：StockObserver
 * 包名：Observer
 * 描述：
 * 作者: WM
 * 创建日期：2023/12/2
 * 版本号：V1.0
 */
public class StockObserver implements Observer{
    private double ibmPrice;
    private double aaplPrice;
    private double googPrice;

    private static int observerIDTracker = 0;
    private int observerID;
    private Subject stockGrabber;
    public StockObserver(Subject stockGrabber){
        this.stockGrabber = stockGrabber;
        this.observerID = ++observerIDTracker;
        System.out.println("New Observer " + this.observerID);
        stockGrabber.register(this);
    }
    @Override
    public void Update(double ibmPrice, double aaplPrice, double googPrice) {
        this.ibmPrice = ibmPrice;
        this.aaplPrice = aaplPrice;
        this.googPrice = googPrice;

        printThePrices();
    }

    public void printThePrices(){
        System.out.println(observerID+"\nIBM: "+ ibmPrice+
                        "\nAAPL: " + aaplPrice +
                        "\nGOOG: " + googPrice + "\n"
                );
    }
}
