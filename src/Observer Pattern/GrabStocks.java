import Observer.StockObserver;
import Subject.StockGrabber;

/**
 * 类名：${NAME}
 * 包名：
 * 描述：实现了当改变stockGrabber的数据的同时，改变观察者observer的数据
 * 作者: WM
 * 创建日期：${DATE}
 * 版本号：V1.0
 */
public class GrabStocks {
    public static void main(String[] args) {
        StockGrabber stockGrabber = new StockGrabber();
        StockObserver observer1 = new StockObserver(stockGrabber);
        stockGrabber.setIBMPrice(197.00);
        stockGrabber.setAaplPrice(677.00);
        stockGrabber.setGoogPrice(800.00);

        StockObserver observer2 = new StockObserver(stockGrabber);
        stockGrabber.setIBMPrice(190.00);

        stockGrabber.setIBMPrice(197.00);
        stockGrabber.setAaplPrice(677.60);
        stockGrabber.setGoogPrice(676.40);

        //使用多线程
        Runnable getIBM = new GetTheStock(stockGrabber, 2, "IBM", 197.00);
        Runnable getAAPL = new GetTheStock(stockGrabber, 2, "AAPL", 677.60);
        Runnable getGOOG = new GetTheStock(stockGrabber, 2, "GOOG", 676.40);

        //运行线程的run方法
        new Thread(getIBM).start();

        new Thread(getAAPL).start();

        new Thread(getGOOG).start();




    }
}