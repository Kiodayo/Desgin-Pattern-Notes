# Signleton

1. 确保一个类只有一个实例
2. 提供一个访问它的全局访问点

# 为什么要有单例模式

当我们的系统中某个对象只需要一个实例的情况，例如:操作系统中只能有一个任务管理器,操作文件时,同一时间内只允许一个实例对其操作.

又比如浏览器的渲染进程中，只有一个渲染主线程,负责解析HTML、CSS、JS以及刷新页面等。

# C# 单例模式的实现--一私一公

> 菜鸟：怎样确保一个类只有一个实例了？
>
> 老鸟：那就让我帮你分析下，你创建类的实例会想到用什么方式来创建的呢？
>
> 新手：用new关键字啊，只要new下就创建了该类的一个实例了，之后就可以使用该类的一些属性和实例方法了
>
> 老鸟：那你想过为什么可以使用new关键字来创建类的实例吗？
>
> 菜鸟：这个还有条件的吗？........., 哦，我想起来了，如果类定义私有的构造函数就不能在外界通过new创建实例了（注：有些初学者就会问，有时候我并没有在类中定义构造函数为什么也可以使用new来创建对象，那是因为编译器在背后做了手脚了，当编译器看到我们类中没有定义构造函数，此时编译器会帮我们生成一个公有的无参构造函数）
>
> 老鸟：不错，回答的很对，这样你的疑惑就得到解答了啊
>
> 菜鸟：那我要在哪里创建类的实例了？
>
> 老鸟：你傻啊，当然是在类里面创建了（注：这样定义私有构造函数就是上面的一个思考过程的，要创建实例，自然就要有一个变量来保存该实例把，所以就有了私有变量的声明, **但是实现中是定义静态私有变量,朋友们有没有想过——这里为什么定义为静态的呢?对于这个疑问的解释为：每个线程都有自己的线程栈，定义为静态主要是为了在多线程确保类有一个实例** ）
>
> 菜鸟：哦，现在完全明白了，但是我还有另一个疑问——现在类实例创建在类内部，那外界如何获得该的一个实例来使用它了？
>
> 老鸟：这个，你可以定义一个公有方法或者属性来把该类的实例公开出去了（注：这样就有了公有方法的定义了，该方法就是提供方法问类的全局访问点）

```csharp


/// <summary>
    /// 单例模式的实现
    /// </summary>
    public class Singleton
    {
        // 定义一个静态变量来保存类的实例
        private static Singleton _instance;

        // 定义私有构造函数，使外界不能创建该类实例
        private Singleton()
        {
        }

        /// <summary>
        /// 定义公有方法提供一个全局访问点,同时你也可以定义公有属性来提供全局访问点
        /// </summary>
        /// <returns></returns>
        public static Singleton GetInstance()
        {
            // 如果类的实例不存在则创建，否则直接返回
            if (uniqueInstance == null)
            {
                uniqueInstance = new Singleton();
            }
            return uniqueInstance;
        }
        public static Singleton Instance
        {
            get
            {
                if(_instance == null) _instance = new Singleton();
                return _instance;
            }
        }

    }
```

### 多线程单例的实现
当2个线程同时运行Instance时，此时两个线程判断(uniqueInstance ==null)这个条件时都返回真，此时两个线程就都会创建Singleton的实例，
```csharp


/// <summary>
    /// 单例模式的实现
    /// </summary>
    public class Singleton
    {
        // 定义一个静态变量来保存类的实例
        private static Singleton _instance;

        //定义一个标识确保线程同步
        private static readonly object locker = new object();

        // 定义私有构造函数，使外界不能创建该类实例
        private Singleton()
        {
        }

        /// <summary>
        /// 定义公有方法提供一个全局访问点,同时你也可以定义公有属性来提供全局访问点
        /// </summary>
        /// <returns></returns>
        // public static Singleton GetInstance()
        // {
        //     // 如果类的实例不存在则创建，否则直接返回
        //     if (_instance == null)
        //     {
        //         _instance = new Singleton();
        //     }
        //     return _instance;
        // }

        public static Singleton Instance
        {
            get
            {
                // 当第一个线程运行到这里时，此时会对locker对象 "加锁"，
                // 当第二个线程运行该方法时，首先检测到locker对象为"加锁"状态，该线程就会挂起等待第一个线程解锁
                // lock语句运行完之后（即线程运行完之后）会对该对象"解锁"
                // 双重锁定只需要一句判断就可以了
                if(_instance == null) 
                {
                    lock(locker)
                    {
                        if(_instance == null) _instance = new Singleton();
                    }
                    
                }
                return _instance;
            }
        }

    }
```