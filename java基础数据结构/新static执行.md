##  **java类static成员加载顺寻** ##
	父类静态变量
	父类静态块
	子类静态变量
	子类静态块
	父类变量
	父类普通块
	父类构造函数(子类实例化时先要调用父类构造函数)
	子类变量
	子类普通块
	子类构造函数

1. static块可以出现类中的任何地方，并且执行是按照static块的顺序执行的。
	
		public class Test {
     
		    static{
		        System.out.println("test static 1");
		    }
		    public static void main(String[] args) {
		         
		    }
		     
		    static{
		        System.out.println("test static 2");
		    }
		}
	

		test static 1
		test static 2
2. 首先加载Test类，因此会执行Test类中的static块。接着执行new MyClass()，而MyClass类还没有被加载，因此需要加载MyClass类。在加载MyClass类的时候，发现MyClass类继承自Test类，但是由于Test类已经被加载了，所以只需要加载MyClass类，那么就会执行MyClass类的中的static块。在加载完之后，就通过构造器来生成对象。而在生成对象的时候，必须先初始化父类的成员变量，因此会执行Test中的Person person = new Person()，而Person类还没有被加载过，因此会先加载Person类并执行Person类中的static块，接着执行父类的构造器，完成了父类的初始化，然后就来初始化自身了，因此会接着执行MyClass中的Person person = new Person()，最后执行MyClass的构造器。

		public class Test {
		    Person person = new Person("Test");
		    static{
		        System.out.println("test static");
		    }
		     
		    public Test() {
		        System.out.println("test constructor");
		    }
		     
		    public static void main(String[] args) {
		        new MyClass();
		    }
		}
		 
		class Person{
		    static{
		        System.out.println("person static");
		    }
		    public Person(String str) {
		        System.out.println("person "+str);
		    }
		}
		 
		 
		class MyClass extends Test {
		    Person person = new Person("MyClass");
		    static{
		        System.out.println("myclass static");
		    }
		     
		    public MyClass() {
		        System.out.println("myclass constructor");
		    }
		}
	
		test static
		myclass static
		person static
		person Test
		test constructor
		person MyClass
		myclass constructor
3. 
		public class Test extends Base{
	 
		    static{
		        System.out.println("test static");
		    }
		     
		    public Test(){
		        System.out.println("test constructor");
		    }
		     
		    public static void main(String[] args) {
		        new Test();
		    }
		}
		 
		class Base{
		     
		    static{
		        System.out.println("base static");
		    }
		     
		    public Base(){
		        System.out.println("base constructor");
		    }
		}

		base static
		test static
		base constructor
		test constructor