# Composite Pattern

## 将对象组合成树状结构以表示“整体-部分”的层次关系

## 结构
1. Component :这是组合中对象声明接口，在适当情况下，实现所有类共有的接口默认行为,用于访问和管理 Component 子部件, Component 可以是抽象类或者接口
2. Leaf : 在组合中表示叶子节点，叶子节点没有子节点
3. Composite :非叶子节点， 用于存储子部件， 在 Component 接口中实现 子部件的相关操作，比如增加(add), 删除

## 特点
1. 简化客户端操作。客户端只需要面对一致的对象而不用考虑整体部分或者节点叶子的问题
2. 具有较强的扩展性。当我们要更改组合对象时，我们只需要调整内部的层次关系，客户端不用做出任何改动.
3. 方便创建出复杂的层次结构。客户端不用理会组合里面的组成细节，容易添加节点或者叶子从而创建出复杂的树形结构
4. 需要**遍历**组织机构，或者处理的对象具有树形结构时, 非常适合使用组合模式.
5. 要求较高的抽象性，如果节点和叶子有很多差异性的话，比如很多方法和属性都不一样，不适合使用组合模式

## 举例

 Unity界面的父节点子节点整体部分的层次结构<br/>
 假如有一个Boss 类，一个 精英怪 类，一个 小兵 类。一个Boss管理多个精英怪，一个精英怪管理多个小兵.<br/>
 现在创建一个顶级抽象类 VillainComponent 类，，让Boss，精英怪，小兵类都继承这个VilainComponent类.<br/>
 这个类有个虚函数beRage() ，效果是让自己加攻击力和手下的单位愤怒,Boss可以加20攻击力并让精英怪愤怒，精英怪可以加10攻击力让小兵愤怒，而小兵愤怒给自己加5攻击力<br/>
 
---
  在Boss类中创建一个列表 可以为 :<br/> `List<VillainComponent> villainComponents = new ArrayList<VillainComponent>();`<br/>
  这个列表未来会添加精英怪<br/>
  重写beRage()，遍历villainComponents ，调用beRage() <br/><br/>
  同理，在精英怪类中创建一个列表 可以为 :<br/> `List<VillainComponent> villainComponents = new ArrayList<VillainComponent>();`<br/>
  这个列表未来会添加小兵<br/>
  重写beRage()，遍历villainComponents ，调用beRage()  <br/><br/>
  在小兵类中创建一个列表 可以为 :<br/> `List<VillainComponent> villainComponents = new ArrayList<VillainComponent>();`<br/>
  重写beRage()，遍历villainComponents ，调用beRage()
  这个列表可以用于以后的扩展  <br/><br/>
  
  
---

  现在只需要把小兵类 的 **实例** 加载到 精英怪 类的 **实例** 上，再把精英怪 的 **实例** 加载到 Boss类 的 **实例**上<br/>
  当Boss 调用 beRage() ，手下的精英怪也会调用beRage(),让所有的小兵也beRage()
