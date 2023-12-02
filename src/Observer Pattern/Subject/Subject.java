package Subject;
import Observer.Observer;

/**
 * 类名：Subject
 * 包名：Subject
 * 描述：
 * 作者: WM
 * 创建日期：2023/12/2
 * 版本号：V1.0
 */
public interface Subject {
    public void register(Observer O);
    public void unregister(Observer O);
    public void notifyOberver();

}
