# Strategy Pattern

## 核心思想：使用组合而不是继承

1. 算法封装
2. 算法独立于用户

## 防止子类之间的代码重复
如基类Animal 的子类 Cat 和Dog , 这两个类都会继承Animal 的Eat()方法, 但是这两个子类的Eat() 方法 很大概率是一样,比如都是

    food--;
    happiness++; 
这种情况, 两个类的Eat()方法就是简单的复制粘贴, 这对程序设计很不好.
---
现在可以创建一个IEatBehavior接口, 把不同的Eat() 算法 交给实现这个接口的类(也可以叫IEatBehavior接口的实例).比如EatSlowly类,EatFast类.<br/>
这样Cat和Dog类就不需要各自在自己的类中，去重写父类的Eat()方法，只需要调用接口的实例就可以调用Eat()方法.

## 现在停止继承，使用Strategy Pattern 写一段代码

    public class Client{
        IBehavior iB;
        //构造函数,获取特定的Behavior
        public Client(IBehavior concreteIB){
            this.iB = concreteIbA;
        }

        public void execute(){
            iB.run();
        }
        
    }

    public interface IBehavior{
        public void run();
    }

    public class concreteIbA implements IBehavior{
        public void run(){
            //执行特定功能A
        }
        
    }

    public class concreteIbB implements IBehavior{
        public void run(){
            //执行特定功能B
        }
        
    }
