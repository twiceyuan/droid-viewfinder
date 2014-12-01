droid-viewfinder
================

## 源来

 近段实际在进行Android开发时，发现在UI组件比较多时，需要一个个调用findViewById实例化，着实感觉繁琐。通过在Spring的Annotation得到启发，于是写了一个项目来实现通过Annotation自动进行实例化。

## 用到的主要技术

 由于本人刚刚接触Android开发，对Android的很多实现机制还在探索中，这个项目目前实现也还比较简单，希望能有大牛能fork进行完善。 本项目主要用到的技术要点如下
  
  + Java Annotation  
  + Java 反射机制  
  + 简单工厂设计模式  

## 用法1

  以Acitity为例，用法1是把你的所有Activity继承包里面的ViewFinderActivity。
  ```java 
  public class HelloViewFinderActivity extends ViewFinderActivity {
	
	@FindViewById(value=R.id.tip)
	private TextView text;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //text 已经实例化
    }
}
  ```
## 用法2
  用法2是在你的Acitivity的onCreate生命周期里面调用包里面ViewFinderHelpler.findView()方法。
  
  ```java
    public class HelloViewFinderActivity2 extends Activity {
	
	@FindViewById(value=R.id.tip)
	private TextView text;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewFinderHelper.findView(this);
        System.out.println(text.getText());
    }
}

  ```
Android View Annotation
