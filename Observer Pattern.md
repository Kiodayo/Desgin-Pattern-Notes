# Observer Pattern

## 主要是Push Vs Poll, 常用于networking,  web server 
---
### 情景一——Client 想随时知道 Server 内的数据是否改变
1. 第一种情况，所有的Client都一起访问Server，询问数据是否改变，这是Poll
2. 第二种情况，一旦Server的数据改变，Server告诉所有Client，这是Push

Client 就是 Observer(观察者), Server 就是 Subject/Observable(被观察者)


## 模式思想


