## java基础 ##
1. **集合ArrayList、LinkedList、Vector的底层实现和区别**

	-  ArrayList底层实际是采用数组实现的（并且该数组的类型是Object类型的）
		如果jdk6,采用Array.copyOf()方法来生成一个新的数组，如果是jdk5，采用的是System.arraycopy()方法（当添加的数据量大于数组的长度的时候）
	- List list = new ArrayList()时，底层会生成一个长度为10的数组来存放对象
    - ArrayList、Vector底部都是采用数组实现的
    - 对于ArrayList，方法都不是同步的，对于Vector，大部分public方法都是同步的
    - LinkedList采用双向循环列表
    - 对于ArrayList，查询速度很快，增加和删除（非最后一个节点）操作非常慢（本质上由数组的		特性决定的）
    - 对于LinkedList，查询速度非常慢，增加和删除操作非常快（本质上是由双向循环列表决定的）
    
    - 线性安全的有：vector,hashTable,StringBuffer
    - 不安全的有：ArrayList,HashMap,StringBuilder,LinkedList 
2. **HashMap和HashTable源代码级别的区别**
	- HashMap的底层源码实现：当我们往HashMap中put元素的时候，先根据key的hashCode重新计算hash值，根据hash值得到这个元素在数组中的位置（即下标），如果数组该位置上已经存放有其他元素了，那么在这个位置上的元素将以链表的形式存放，新加入的放在链头，最先加入的放在链尾。如果数组该位置上没有元素，就直接将该元素放到此数组中的该位置上。
   - 最明显的区别在于Hashtable是同步的（每个方法都是synchronized），而HashMap则不是。
   - HashTable比较老，是基于Dictionary 类实现的，HashTable 则是基于 Map接口实现的 = - - HashTable 是线程安全的， HashMap 则是线程不安全的 HashMap可以让你将空值作为一个表的条目的key或value
3. **Map、Set、List、Queue、Stack的特点与用法。**
	
	-  Collection 是对象集合， Collection 有两个子接口 List 和 Set
 		List 可以通过下标 (1,2..) 来取得值，值可以重复而 Set 只能通过游标来取值，并且值是不能重复的
	- 	ArrayList ， Vector ， LinkedList 是 List 的实现类
	 	ArrayList 是线程不安全的， Vector 是线程安全的，这两个类底层都是由数组实现的
		LinkedList 是线程不安全的，底层是由链表实现的
	- 	Map 是键值对集合	
	- 	HashTable 和 HashMap 是 Map 的实现类 
	- 	HashTable 是线程安全的，不能存储 null 值 
	- 	HashMap 不是线程安全的，可以存储 null 值
	- 	Stack类：继承自Vector，实现一个后进先出的栈。提供了几个基本方法，push、pop、		peak、empty、search等。
	- 	Queue接口：提供了几个基本方法，offer、poll、peek等。已知实现类有LinkedList、	PriorityQueue等。

4. **Switch不支持的类型有Long double,float，String实在java7后才支持的。不支持float，	long,double**
5. **equals与==的区别：**
	
	==是判断两个变量或实例是不是指向同一个内存空间 equals是判断两个变量或实例所指向的内存空间的值是不是相同

6. **String、StringBuffer与StringBuilder的区别。**

	- Java 平台提供了两种类型的字符串：String和StringBuffer / StringBuilder，它们可以储存和操作字符串。其中String是只读字符串，也就意味着String引用的字符串内容是不能被改变的。而StringBuffer和StringBulder类表示的字符串对象可以直接进行修改。StringBuilder是JDK1.5引入的，它和StringBuffer的方法完全相同，区别在于它是单线程环境下使用的，因为它的所有方面都没有被synchronized修饰，因此它的效率也比StringBuffer略高。（StringBuffer是线性安全的StringBuilder）
		
	- String 类型和 StringBuffer 类型的主要性能区别其实在于 String 是不可变的对象 StringBuffer和StringBuilder底层是 char[]数组实现的 StringBuffer是线程安全的，而StringBuilder是线程不安全的
7. **Object有哪些公用方法？**
	- 方法equals测试的是两个对象是否相等
	- 方法clone进行对象拷贝
	- 方法getClass返回和当前对象相关的Class对象
	- 方法notify,notifyall,wait都是用来对给定对象进行线程同步的
8.  **Override和Overload的含义去区别**
	
	Overload顾名思义是重新加载，它可以表现类的多态性，可以是函数里面可以有相同的函数名但是参数名、返回值、类型不能相同；或者说可以改变参数、类型、返回值但是函数名字依然不变。 Override顾名思义就是ride(重写)的意思，在子类继承父类的时候子类中可以定义某方法与其父类有相同的名称和参数，当子类在调用这一函数时自动调用子类的方法，而父类相当于被覆盖（重写）了。
9. **抽象类和接口的区别**
	
	 一个类只能继承单个类，但是可以实现多个接口 接口强调特定功能的实现，而抽象类强调所属关系 抽象类中的所有方法并不一定要是抽象的，你可以选择在抽象类中实现一些基本的方法。而接口要求所有的方法都必须是抽象的
10. **wait()和sleep()的区别**

	- sleep来自Thread类，和wait来自Object类
	- 调用sleep()方法的过程中，线程不会释放对象锁。而 调用 wait 方法线程会释放对象锁
	- sleep睡眠后不出让系统资源，wait让出系统资源其他线程可以占用CPU
	- sleep(milliseconds)需要指定一个睡眠时间，时间一到会自动唤醒
11. **解析XML的几种方式的原理与特点：DOM、SAX、PULL**
	- DOM：消耗内存：先把xml文档都读到内存中，然后再用DOM API来访问树形结构，并获取数据。这个写起来很简单，但是很消耗内存。要是数据过大，手机不够牛逼，可能手机直接死机
	- SAX：解析效率高，占用内存少，基于事件驱动的：更加简单地说就是对文档进行顺序扫描，当扫描到文档(document)开始与结束、元素(element)开始与结束、文档(document)结束等地方时通知事件处理函数，由事件处理函数做相应动作，然后继续同样的扫描，直至文档结束。
	- PULL：与 SAX 类似，也是基于事件驱动，我们可以调用它的next（）方法，来获取下一个解析事件（就是开始文档，结束文档，开始标签，结束标签），当处于某个元素时可以调用XmlPullParser的getAttributte()方法来获取属性的值，也可调用它的nextText()获取本节点的值。
12. **JAVA多态的实现原理**
	抽象的来讲，多态的意思就是同一消息可以根据发送对象的不同而采用多种不同的行为方式。（发送消息就是函数调用） 实现的原理是动态绑定，程序调用的方法在运行期才动态绑定，追溯源码可以发现，JVM 通过参数的自动转型来找到合适的办法。
13. **Java的四种引用的区别**
 	- 强引用：如果一个对象具有强引用，它就不会被垃圾回收器回收。即使当前内存空间不足，JVM 也不会回收它，而是抛出 OutOfMemoryError 错误，使程序异常终止。如果想中断强引用和某个对象之间的关联，可以显式地将引用赋值为null，这样一来的话，JVM在合适的时间就会回收该对象
	- 软引用：在使用软引用时，如果内存的空间足够，软引用就能继续被使用，而不会被垃圾回收器回收，只有在内存不足时，软引用才会被垃圾回收器回收。
	- 弱引用：具有弱引用的对象拥有的生命周期更短暂。因为当 JVM 进行垃圾回收，一旦发现弱引用对象，无论当前内存空间是否充足，都会将弱引用回收。不过由于垃圾回收器是一个优先级较低的线程，所以并不一定能迅速发现弱引用对象
	- 虚引用：顾名思义，就是形同虚设，如果一个对象仅持有虚引用，那么它相当于没有引用，在任何时候都可能被垃圾回收器回收。
14. JAVA 垃圾回收与内存分配策略

	- **垃圾回收是什么**？
		就是释放那些不再持有引用的对象的内存
	- **怎么判断一个对象是否需要收集**？
		- 引用计数（最简单古老的方法）：指将资源（可以是对象、内存或磁盘空间等等）的被引用次数保存起来，当被引用次数变为零时就将其释放的过程
		- 对象引用遍历（现在大多数 jvm 使用的方法）：对象引用遍历从一组对象开始，沿着整个对象图上的每条链接，递归确定可到达（reachable）的对象。如果某对象不能从这些根对象的一个（至少一个）到达，则将它作为垃圾收集引用计数缺陷：引用计数无法解决循环引用问题：假设对象A，B都已经被实例化，让A=B,B=A,除此之外这两个对象再无任何引用，此时计数器的值就永远不可能为0，但是引用计数器无法通知gc回收他们
	- **介绍垃圾回收机制**
		- 标记回收法：遍历对象图并且记录可到达的对象，以便删除不可到达的对象，一般使用单线程工作并且可能产生内存碎片
		- 标记-压缩回收法：前期与第一种方法相同，只是多了一步，将所有的存活对象压缩到内存的一端，这样内存碎片就可以合成一大块可再利用的内存区域，提高了内存利用率
		- 复制回收法：把现有内存空间分成两部分，gc运行时，它把可到达对象复制到另一半空间，再清空正在使用的空间的全部对象。这种方法适用于短生存期的对象，持续复制长生存期的对象则导致效率降低。
		- 分代回收发：把内存空间分为两个或者多个域，如年轻代和老年代，年轻代的特点是对象会很快被回收，因此在年轻代使用效率比较高的算法。当一个对象经过几次回收后依然存活，对象就会被放入称为老年的内存空间，老年代则采取标记-压缩算法
15. **JAVA 中堆和栈的区别**
	- 基本数据类型比变量和对象的引用都是在栈分配的
	- 堆内存用来存放由new创建的对象和数组
	- 类变量（static修饰的变量），程序在一加载的时候就在堆中为类变量分配内存，堆中的内存地址存放在栈中
	- 实例变量：当你使用java关键字new的时候，系统在堆中开辟并不一定是连续的空间分配给变量，是根据零散的堆内存地址，通过哈希算法换算为一长串数字以表征这个变量在堆中的"物理位置”,实例变量的生命周期--当实例变量的引用丢失后，将被GC（垃圾回收器）列入可回收“名单”中，但并不是马上就释放堆中内存
	- 局部变量: 由声明在某方法，或某代码段里（比如for循环），执行到它的时候在栈中开辟内存，当局部变量一但脱离作用域，内存立即释放
16. **Hashcode的作用，与 equal 有什么区别**
	
	同样用于鉴定2个对象是否相等的，java集合中有 list 和 set 两类，其中 set不允许元素重复实现，那个这个不允许重复实现的方法，如果用 equal 去比较的话，如果存在1000个元素，你 new 一个新的元素出来，需要去调用1000次 equal 去逐个和他们比较是否是同一个对象，这样会大大降低效率。hashcode实际上是返回对象的存储地址，如果这个位置上没有元素，就把元素直接存储在上面，如果这个位置上已经存在元素，这个时候才去调用equal方法与新元素进行比较，相同的话就不存了，散列到其他地址上
17. **数据结构与算法部分**：
1.给最外层的rootview，把这个根视图下的全部button背景设置成红色，手写代码，不许用递归
2.给一串字符串比如abbbcccd，输出a1b3c3d1，手写代码（注意有个别字符可能会出现十次以上的情况）
3.一个序列，它的形式是12349678，9是最高峰，经历了一个上升又下降的过程，找出里面的最大值的位置，要求效率尽可能高
4.二叉查找树的删除操作，手写代码
5.反转链表，手写代码
6.二分查找，手写代码
7.有海量条 url，其中不重复的有300万条，现在希望挑选出重复出现次数最高的 url，要求效率尽可能的高
8.一篇英语文章，去掉字符只留下k个，如何去掉才能使这k个字符字典序最小
9.弗洛伊德算法和 Dijkstra算法的区别？复杂度是多少？讲讲 Dijkstra算法的具体过程
10.反转字符串，要求手写代码，优化速度、优化空间
11.给出两个无向图，找出这2个无向图中相同的环路。手写代码
12.单例模式，手写代码
13.生产者与消费者，手写代码
14.二叉树镜像，手写代码
15.最长不重复子串（最长重复子串），手写代码
操作系统部分：
1.分别从操作系统的内存角度与进程线程角度解释分析堆，栈二者的区别
2.什么是事务？
3.OSI七层模型有哪些，各层次的作用
4.TCP的三次握手过程，四次挥手过程，为什么需要三次？
5.说说操作系统中进程的通信方式
6.浏览器输入地址之后，之后的过程
1.查找域名对应的IP地址。这一步会依次查找浏览器缓存，系统缓存，路由器缓存，ISPNDS缓存，根域名服务器。
2.向IP对应的服务器发送请求。
3.服务器响应请求，发回网页内容。
4.浏览器解析网页内容。
由于网页可能有重定向，或者嵌入了图片，AJAX，其它子网页等等，这4个步骤可能反复进行多次才能将最终页面展示给用户。

7.谈谈 HTTP 中Get 和 Post 方法的区别？
而HTTP中的GET，POST，PUT，DELETE就对应着对这个资源的查，改，增，删4个操作

6. **使用wait/notify/notifyAll实现线程间通信(生产者与消费者)**
			
		import java.util.LinkedList;
		public class ProducerConsumer {
		    private LinkedList<Object> storeHouse = new LinkedList<Object>();
		    private int MAX = 10;
		
		    public ProducerConsumer() {
		    }
		
		    public void start() {
		        new Producer().start();
		        new Comsumer().start();
		    }
		
		    class Producer extends Thread {
		        public void run() {
		            while (true) {
		                synchronized (storeHouse) {
		                    try {
		                        while (storeHouse.size() == MAX) {
		                            System.out.println("storeHouse is full , please wait");
		                            storeHouse.wait();
		                        }
		                        Object newOb = new Object();
		                        if (storeHouse.add(newOb)) {
		                            System.out.println("Producer put a Object to storeHouse");
		                            Thread.sleep((long) (Math.random() * 3000));
		                            storeHouse.notify();
		                        }
		                    } catch (InterruptedException ie) {
		                        System.out.println("producer is interrupted!");
		                    }
		
		                }
		            }
		        }
		    }
		
		    class Comsumer extends Thread {
		        public void run() {
		            while (true) {
		                synchronized (storeHouse) {
		                    try {
		                        while (storeHouse.size() == 0) {
		                            System.out.println("storeHouse is empty , please wait");
		                            storeHouse.wait();
		                        }
		                        storeHouse.removeLast();
		                        System.out.println("Comsumer get  a Object from storeHouse");
		                        Thread.sleep((long) (Math.random() * 3000));
		                        storeHouse.notify();
		                    } catch (InterruptedException ie) {
		                        System.out.println("Consumer is interrupted");
		                    }
		
		                }
		            }
		
		        }
		    }
		
		    public static void main(String[] args) throws Exception {
		        ProducerConsumer pc = new ProducerConsumer();
		        pc.start();
		    }
		}

7. **快速排序算法：**

	    int quicksort(vector<int> &v, int left, int right){
	    		if(left < right){
	    			int key = v[left];
			    	int low = left;
			    	int high = right;
			    	while(low < high){
				    	while(low < high && v[high] > key){
				    	high--;
				    }
	    			v[low] = v[high];
	    			while(low < high && v[low] < key){
	    				low++;
	    			}
	    			v[high] = v[low];
	    		}
	    		v[low] = key;
	    		quicksort(v,left,low-1);
	    		quicksort(v,low+1,right);
    		}
    	}
8. **筛选法求100以内的素数**
	- 挖去1；
	- 用下一个未被挖去的数P去除P后面各数，把P的倍数挖掉；
	- 检查P是否小于n的开方的整数部分，如果是，则返回2继续执行，否则就结束。
	- 剩下的数就是素数。

			#include <stdio.h>
			#include <math.h>   //程序中用到求平方根函数sqrt
			void main()
			{
				int i,j,n,a[101];					//定义a数组中包含101个元素
				for(i=1;i<=100;i++)					//a[0]不用，只用a[1]到a[100]
					a[i]=i;							//使a[1]到a[100]的值为1到100
				a[1]=0;								//先“挖掉”a[1]
				for(i=2;i<=sqrt(100);i++)
				for(j=i+1;j<=100;j++)
				{
					if(a[i]!=0 && a[j]!=0)		//关系运算符！=为“不等于”，逻辑运算符&&为“与”，！为“非”
						if(a[j]%a[i]==0)
							a[j]=0;				//把非素数“挖掉”
				}
				printf("/n");
				for(i=1,n=0;i<=100;i++)
				{
					if(a[i]!=0)					//选出值不为0的数组元素，即非素数
					{
						printf("%5d",a[i]);		//输出素数，宽度为5列
						n++;					//累计本行已输出的数据个数
					}
					if(n==10)					//输出10个数后换行
					{
						printf("/n");
						n=0;
					}
				}
				printf("/n");		
			}
			/*运行结果如下：
			--------------------------------------------------------
			2357   11   13   17   19   23   29
			   31   37   41   43   47   53   59   61   67   71
			   73   79   83   89   97
			--------------------------------------------------------
			*/
