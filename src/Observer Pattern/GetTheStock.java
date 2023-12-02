import Subject.StockGrabber;
import Subject.Subject;

import java.text.DecimalFormat;

/**
 * 类名：GetTheStock
 * 包名：PACKAGE_NAME
 * 描述：用多线程来实现Observer Pattern
 * 作者: WM
 * 创建日期：2023/12/2
 * 版本号：V1.0
 */
public class GetTheStock implements Runnable {
    private int startTime;
    private String stock;
    private double price;
    private Subject stockGrabber;

    public GetTheStock(Subject stockGrabber, int newStartTime, String newStock,
                       double newPrice) {
        this.stockGrabber = stockGrabber;
        this.startTime = newStartTime;
        this.stock = newStock;
        this.price = newPrice;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 20; ++i) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            //创造一个随机的浮点数，来作为股票上下浮动的数字
            double randNum = (Math.random() * (.06)) - .03;
            DecimalFormat df = new DecimalFormat("#.##");
            //改变价格
            price = Double.valueOf(df.format((price + randNum)));
            if (stock == "IBM") ((StockGrabber) stockGrabber).setIBMPrice(price);

            if (stock == "AAPL") ((StockGrabber) stockGrabber).setAaplPrice(price);

            if (stock == "GOOG") ((StockGrabber) stockGrabber).setGoogPrice(price);
            System.out.println(stock + ": " + df.format((price + randNum)) +
                    " " + df.format(randNum));
            System.out.println();

        }
    }
}
