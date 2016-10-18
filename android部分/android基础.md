1.  **绘制Activity生命周期流程图**
	- ![](http://i.imgur.com/y1f2qGU.png)
	- **不同场景下Activity生命周期的变化过程**
		- 启动Activity： onCreate()--->onStart()--->onResume()，Activity进入运行状态。
		- Activity退居后台： 当前Activity转到新的Activity界面或按Home键回到主屏： onPause()--->onStop()，进入停滞状态。
		- Activity返回前台： onRestart()--->onStart()--->onResume()，再次回到运行状态。
		- Activity退居后台，且系统内存不足， 系统会杀死这个后台状态的Activity，若再次回到这个Activity,则会走onCreate()-->onStart()--->onResume()
		- 锁定屏与解锁屏幕 只会调用onPause()，而不会调用onStop方法，开屏后则调用onResume()
	
2. **Android中的动画有哪些，区别是什么**
	- **逐帧动画**(Drawable Animation)： 加载一系列Drawable资源来创建动画，简单来说就是播放一系列的图片来实现动画效果，可以自定义每张图片的持续时间
	- **补间动画**(Tween Animation)： Tween可以对View对象实现一系列简单的动画效果，比如位移，缩放，旋转，透明度等等。但是它并不会改变View属性的值，只是改变了View的绘制的位置，比如，一个按钮在动画过后，不在原来的位置，但是触发点击事件的仍然是原来的坐标。
	- **属性动画(Property Animation)**： 动画的对象除了传统的View对象，还可以是Object对象，动画结束后，Object对象的属性值被实实在在的改变了
3. **Android中View绘制流程**

	![](http://i.imgur.com/B3NAYal.png)
	measure()方法，layout()，draw()三个方法主要存放了一些标识符，来判断每个View是否需要再重新测量，布局或者绘制，主要的绘制过程还是在onMeasure，onLayout，onDraw这个三个方法中
	- onMesarue() 为整个View树计算实际的大小，即设置实际的高(对应属性:mMeasuredHeight)和宽(对应属性: mMeasureWidth)，每个View的控件的实际宽高都是由父视图和本身视图决定的。
	- onLayout() 为将整个根据子视图的大小以及布局参数将View树放到合适的位置上。
	- onDraw() 开始绘制图像，绘制的流程如下
	- 首先绘制该View的背景
	- 调用onDraw()方法绘制视图本身 (每个View都需要重载该方法，ViewGroup不需要实现该方法)
	- 如果该View是ViewGroup，调用dispatchDraw ()方法绘制子视图
	- 绘制滚动条
4. **数据持久化的四种方式有哪些**？
	- **文件存储**： 通过java.io.FileInputStream和java.io.FileOutputStream这两个类来实现对文件的读写，java.io.File类则用来构造一个具体指向某个文件或者文件夹的对象。
	- **SharedPreferences**： SharedPreferences是一种轻量级的数据存储机制，他将一些简单的数据类型的数据，包括boolean类型，int类型，float类型，long类型以及String类型的数据，以键值对的形式存储在应用程序的私有Preferences目录（/data/data/<包名>/shared_prefs/）中，这种Preferences机制广泛应用于存储应用程序中的配置信息。
	- **SQLite数据库**： 当应用程序需要处理的数据量比较大时，为了更加合理地存储、管理、查询数据，我们往往使用关系数据库来存储数据。Android系统的很多用户数据，如联系人信息，通话记录，短信息等，都是存储在SQLite数据库当中的，所以利用操作SQLite数据库的API可以同样方便的访问和修改这些数据。
	- **ContentProvider**: 主要用于在不同的应用程序之间实现数据共享的功能，不同于sharepreference和文件存储中的两种全局可读写操作模式，内容提供其可以选择只对哪一部分数据进行共享，从而保证我们程序中的隐私数据不会有泄漏的风险
5. **Context与ApplicationContext的区别，分别用在什么情况下**
	- Application的Context是一个全局静态变量，SDK的说明是只有当你引用这个context的生命周期超过了当前activity的生命周期，而和整个应用的生命周期挂钩时，才去使用这个application的context。
	- 在android中context可以作很多操作，但是最主要的功能是加载和访问资源。在android中有两种context，一种是 application context，一种是activity context，通常我们在各种类和方法间传递的是activity context。
6.  **介绍Activity的几中启动模式，并简单说说自己的理解或者使用场景**
7.   **Service与Activity怎么实现通信**
	- **方法一**：
		- 添加一个继承Binder的内部类，并添加相应的逻辑方法	
		- 重写Service的onBind方法，返回我们刚刚定义的那个内部类实例
		- Activity中创建一个ServiceConnection的匿名内部类，并且重写里面的onServiceConnected方法和onServiceDisconnected方法，这两个方法分别会在活动与服务成功绑定以及解除绑定的时候调用，在onServiceConnected方法中，我们可以得到一个刚才那个service的binder对象，通过对这个binder对象进行向下转型，得到我们那个自定义的Binder实例，有了这个实例，做可以调用这个实例里面的具体方法进行需要的操作了
	- **方法二：**
	  	通过BroadCast(广播)的形式 当我们的进度发生变化的时候我们发送一条广播，然后在Activity的注册广播接收器，接收到广播之后更新视图
8. **onSaveInstanceState()被执行的场景有哪些：**
	- 当用户按下HOME键时
	- 长按HOME键，选择运行其他的程序时
	- 锁屏时
	- 从activity A中启动一个新的activity时
	- 屏幕方向切换时
	- **注：但是当用户主动去销毁一个Activity时，例如在应用中按返回键，onSaveInstanceState()就不会被调用。除非该activity是被用户主动销毁的，通常onSaveInstanceState()只适合用于保存一些临时性的状态，而onPause()适合用于数据的持久化保存。**
9.  **介绍Handle的机制android消息机制，画图说明handler,looper,message,messagequeue关系**
	- Handler通过调用sendmessage方法把消息放在消息队列MessageQueue中，Looper负责把消息从消息队列中取出来，重新再交给Handler进行处理，三者形成一个循环
	- 通过构建一个消息队列，把所有的Message进行统一的管理，当Message不用了，并不作为垃圾回收，而是放入消息队列中，供下次handler创建消息时候使用，提高了消息对象的复用，减少系统垃圾回收的次数
	- 每一个线程，都会单独对应的一个looper，这个looper通过ThreadLocal来创建，保证每个线程只创建一个looper，looper初始化后就会调用looper.loop创建一个MessageQueue，这个方法在UI线程初始化的时候就会完成，我们不需要手动创建
10. **ListView卡顿的原因与性能优化，越多越好**
	- 重用converView： 通过复用converview来减少不必要的view的创建，另外Infalte操作会把xml文件实例化成相应的View实例，属于IO操作，是耗时操作。
	- 减少findViewById()操作： 将xml文件中的元素封装成viewholder静态类，通过converview的setTag和getTag方法将view与相应的holder对象绑定在一起，避免不必要的findviewbyid操作
	- 避免在 getView 方法中做耗时的操作: 例如加载本地 Image 需要载入内存以及解析 Bitmap ，都是比较耗时的操作，如果用户快速滑动listview，会因为getview逻辑过于复杂耗时而造成滑动卡顿现象。用户滑动时候不要加载图片，待滑动完成再加载，可以使用这个第三方库glide
	- Item的布局层次结构尽量简单，避免布局太深或者不必要的重绘
	- 尽量能保证 Adapter 的 hasStableIds() 返回 true 这样在 notifyDataSetChanged() 的时候，如果item内容并没有变化，ListView 将不会重新绘制这个 View，达到优化的目的
	- 在一些场景中，ScollView内会包含多个ListView，可以把listview的高度写死固定下来。 由于ScollView在快速滑动过程中需要大量计算每一个listview的高度，阻塞了UI线程导致卡顿现象出现，如果我们每一个item的高度都是均匀的，可以通过计算把listview的高度确定下来，避免卡顿现象出现
	- 使用 RecycleView 代替listview： 每个item内容的变动，listview都需要去调用notifyDataSetChanged来更新全部的item，太浪费性能了。RecycleView可以实现当个item的局部刷新，并且引入了增加和删除的动态效果，在性能上和定制上都有很大的改善
	- ListView 中元素避免半透明： 半透明绘制需要大量乘法计算，在滑动时不停重绘会造成大量的计算，在比较差的机子上会比较卡。 在设计上能不半透明就不不半透明。实在要弄就把在滑动的时候把半透明设置成不透明，滑动完再重新设置成半透明。
	- 尽量开启硬件加速： 硬件加速提升巨大，避免使用一些不支持的函数导致含泪关闭某个地方的硬件加速。当然这一条不只是对 ListView。


	    - Adapter的getView方法里面convertView没有使用setTag和getTag方式；
		- 在getView方法里面ViewHolder初始化后的赋值或者是多个控件的显示状态和背景的显示没有优化好，抑或是里面含有复	杂的计算和耗时操作；
		- 在getView方法里面 inflate的row 嵌套太深（布局过于复杂）或者是布局里面有大图片或者背景所致；
		- Adapter多余或者不合理的notifySetDataChanged；
		- listview 被多层嵌套，多次的onMessure导致卡顿，如果多层嵌套无法避免，建议把listview的高和宽设置为		fill_parent. 如果是代码继承的listview，那么也请你别忘记为你的继承类添加上LayoutPrams，注意高和宽都是	fill_parent的;
		- 减少不必要的视图更新；使用Adapter提供的convertView；
		- 使用自定义的视图缓存类，通过convertView的setTag方法和getTag方法来存储
		- 减少不必要的视图更新**
11. **ANR 系列问题**
	- **什么ANR**
	ANR全称Application Not Responding，意思就是程序未响应。在Android里，应用程序的响应性是由Activity Manager和WindowManager系统服务监视的 。当它监测到以下情况中的一个时，Android就会针对特定的应用程序显示ANR：
		- 应用在5秒内未响应用户的输入事件（如按键或者触摸）
		- BroadcastReceiver未在10秒内完成相关的处理
	- **ANR是怎么引起的**？
		- 主线程中存在耗时的计算-
		- 主线程被IO操作（从4.0之后网络IO不允许在主线程中）阻塞。-
		- 主线程中错误的操作，比如Thread.wait或者Thread.sleep等
	- **如何避免ANR问题的出现**
		- 基本思路就是把一些耗时操作放到子线程中处理
		- 使用AsyncTask处理耗时IO操作。
		- 降低子线程优先级使用Thread或者HandlerThread时，调用Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND)设置优先级，否则仍然会降低程序响应，因为默认Thread的优先级和主线程相同。
		- 使用Handler处理子线程结果，而不是使用Thread.wait()或者Thread.sleep()来阻塞主线程。
		- Activity的onCreate和onResume回调中尽量避免耗时的代码
		- BroadcastReceiver中onReceive代码也要尽量减少耗时操作
		- 建议使用IntentService处理。IntentService是一个异步的，会自动停止的服务，很好解决了传统的Service中处理完耗时操作忘记停止并销毁Service的问题
11. **OOM系列问题**
	- **什么OOM？**
		OOM全称是Out Of Merrory，Android系统的每一个应用程序都设置一个硬性的Dalvik Heap Size最大限制阈值，如果申请的内存资源超过这个限制，系统就会抛出OOM错误
	- **内存泄漏有哪些场景以及解决方法**
		- **类的静态变量持有大数据对象** 静态变量长期维持到大数据对象的引用，阻止垃圾回收。

		- **非静态内部类存在静态实例** 非静态内部类会维持一个到外部类实例的引用，如果非静态内部类的实例是静态的，就会间接长期维持着外部类的引用，阻止被回收掉。
		- **资源对象未关闭** 资源性对象比如（Cursor，File文件等）往往都用了一些缓冲，我们在不使用的时候，应该及时关闭它们， 以便它们的缓冲及时回收内存。它们的缓冲不仅存在于java虚拟机内，还存在于java虚拟机外。 如果我们仅仅是把它的引用设置为null,而不关闭它们，往往会造成内存泄露。 解决办法： 比如SQLiteCursor（在析构函数finalize（）,如果我们没有关闭它，它自己会调close()关闭）， 如果我们没有关闭它，系统在回收它时也会关闭它，但是这样的效率太低了。 因此对于资源性对象在不使用的时候，应该调用它的close()函数，将其关闭掉，然后才置为null. 在我们的程序退出时一定要确保我们的资源性对象已经关闭。 程序中经常会进行查询数据库的操作，但是经常会有使用完毕Cursor后没有关闭的情况。如果我们的查询结果集比较小， 对内存的消耗不容易被发现，只有在常时间大量操作的情况下才会复现内存问题，这样就会给以后的测试和问题排查带来困难和风险，记得try catch后，在finally方法中关闭连接
		- **Handler内存泄漏** Handler作为内部类存在于Activity中，但是Handler生命周期与Activity生命周期往往并不是相同的，比如当Handler对象有Message在排队，则无法释放，进而导致本该释放的Acitivity也没有办法进行回收。 **解决办法**：声明handler为static类，这样内部类就不再持有外部类的引用了，就不会阻塞Activity的释放如果内部类实在需要用到外部类的对象，可在其内部声明一个弱引用引用外部类。


				public class MainActivity extends Activity {
				 private CustomHandler mHandler;
				
				 @Override
				 protected void onCreate(Bundle savedInstanceState) {
					 super.onCreate(savedInstanceState);
					 mHandler = new CustomHandler(this);
				 }
				
				 static class CustomHandlerextends Handler {
					 // 内部声明一个弱引用，引用外部类
					 private WeakReference<MainActivity > activityWeakReference;
					 public MyHandler(MyActivity activity) {
					 	activityWeakReference= new WeakReference<MainActivity >(activity);
					 }
					 // ... ...   
					 }
				}
			在Activity onStop或者onDestroy的时候，取消掉该Handler对象的Message和Runnable
			
			    Override
    			public void onDestroy() {
    			 //  If null, all callbacks and messages will be removed.
    			 mHandler.removeCallbacksAndMessages(null);
    			}

		- **一些不良代码习惯** 有些代码并不造成内存泄露，但是他们的资源没有得到重用，频繁的申请内存和销毁内存，消耗CPU资源的同时，也引起内存抖动 解决方案 如果需要频繁的申请内存对象和和释放对象，可以考虑使用对象池来增加对象的复用。 例如ListView便是采用这种思想，通过复用converview来避免频繁的GC

	- **如何避免 OOM 问题的出现**
		- **使用更加轻量的数据结构** 
		- **避免在Android里面使用Enum** 
		- **减小Bitmap对象的内存占用** Bitmap是一个极容易消耗内存的大胖子，减小创建出来的Bitmap的内存占用可谓是重中之重，，通常来说有以下2个措施： inSampleSize：**缩放比例**，在把图片载入内存之前，我们需要先计算出一个合适的缩放比例，避免不必要的大图载入。 decode format：**解码格式**，选择ARGB_6666/RBG_545/ARGB_4444/ALPHA_6，存在很大差异
		- **Bitmap对象的复用** 缩小Bitmap的同时，也需要提高BitMap对象的复用率，避免频繁创建BitMap对象，复用的方法有以下2个措施 LRUCache : “最近最少使用算法”在Android中有极其普遍的应用。ListView与GridView等显示大量图片的控件里，就是使用LRU的机制来缓存处理好的Bitmap，把近期最少使用的数据从缓存中移除，保留使用最频繁的数据， inBitMap高级特性:利用inBitmap的高级特性提高Android系统在Bitmap分配与释放执行效率。使用inBitmap属性可以告知Bitmap解码器去尝试使用已经存在的内存区域，新解码的Bitmap会尝试去使用之前那张Bitmap在Heap中所占据的pixel data内存区域，而不是去问内存重新申请一块区域来存放Bitmap。利用这种特性，即使是上千张的图片，也只会仅仅只需要占用屏幕所能够显示的图片数量的内存大小
		-  **使用更小的图片** 在涉及给到资源图片时，我们需要特别留意这张图片是否存在可以压缩的空间，是否可以使用更小的图片。尽量使用更小的图片不仅可以减少内存的使用，还能避免出现大量的Inflatio·nException。假设有一张很大的图片被XML文件直接引用，很有可能在初始化视图时会因为内存不足而发生InflationException，这个问题的根本原因其实是发生了OOM。
		- **StringBuilder** 在有些时候，代码中会需要使用到大量的字符串拼接的操作，这种时候有必要考虑使用StringBuilder来替代频繁的“+”。
		- **避免在onDraw方法里面执行对象的创建** 类似onDraw等频繁调用的方法，一定需要注意避免在这里做创建对象的操作，因为他会迅速增加内存的使用，而且很容易引起频繁的gc，甚至是内存抖动。
12. **Asynctask问题**
	- **AsynTask为什么要设计为只能够一次任务**？
	最核心的还是线程安全问题，多个子线程同时运行，会产生状态不一致的问题。所以要务必保证只能够执行一次
	-  **AsynTask造成的内存泄露的问题怎么解决**
		比如非静态内部类AsynTask会隐式地持有外部类的引用，如果其生命周期大于外部activity的生命周期，就会出现内存泄漏
		-	注意要复写AsynTask的onCancel方法，把里面的socket，file等，该关掉的要及时关掉
		- 在 Activity 的onDestory()方法中调用Asyntask.cancal方法
		- Asyntask内部使用弱引用的方式来持有Activity
	- **若Activity已经销毁，此时AsynTask执行完并且返回结果，会报异常吗?**
	
		当一个App旋转时，整个Activity会被销毁和重建。当Activity重启时，AsyncTask中对该Activity的引用是无效的，因此onPostExecute()就不会起作用，若AsynTask正在执行，折会报 view not attached to window manager 异常
		同样也是生命周期的问题，在 Activity 的onDestory()方法中调用Asyntask.cancal方法，让二者的生命周期同步
	- **Activity销毁但Task如果没有销毁掉，当Activity重启时这个AsyncTask该如何解决？**
		还是屏幕旋转这个例子，在重建Activity的时候，会回掉Activity.onRetainNonConfigurationInstance()重新传递一个新的对象给AsyncTask，完成引用的更新
14. **Android触摸分发机制**
	- **介绍触摸事件的分发机制**

		- 事件从Activity.dispatchTouchEvent()开始传递，只要没有被停止或拦截，从最上层的View(ViewGroup)开始一直往下(子View)传递。子View可以通过onTouchEvent()对事件进行处理。
		- 事件由父View(ViewGroup)传递给子View，ViewGroup可以通过onInterceptTouchEvent()对事件做拦截，停止其往下传递。
		- 如果事件从上往下传递过程中一直没有被停止，且最底层子View没有消费事件，事件会反向往上传递，这时父View(ViewGroup)可以进行消费，如果还是没有被消费的话，最后会到Activity的onTouchEvent()函数。
		- 如果View没有对ACTION_DOWN进行消费，之后的其他事件不会传递过来。
		- OnTouchListener优先于onTouchEvent()对事件进行消费。
		- 上面的消费即表示相应函数返回值为true。
	- **View中 setOnTouchListener的onTouch，onTouchEvent，onClick的执行顺序所以三者的顺序是：**
		- setOnTouchListener() 的onTouch
		-	onTouchEvent()
		- onClick()
15. **注册广播接收器有哪几种方式,有什么区别**
	- 静态注册：在AndroidManifest.xml文件中进行注册，当App退出后，Receiver仍然可以接收到广播并且进行相应的处理
	- 动态注册：在代码中动态注册，当App退出后，也就没办法再接受广播了
16. **显示Intent与隐式Intent的区别**
	- 对明确指出了目标组件名称的Intent，我们称之为“显式Intent”; 
	- 对于没有明确指出目标组件名称的Intent，则称之为“隐式 Intent”。
	- 对于隐式意图，在定义Activity时，指定一个intent-filter，当一个隐式意图对象被一个意图过滤器进行匹配时，将有三个方面会被参考到：
		- 动作(Action)
		- 类别(Category ['kætɪg(ə)rɪ] )
		- 数据(Data )
17. **Scrollview怎么判断是否滑倒底部**
	- 顶部判断：getScrollY() == 0
	- 底部判断：View childView = getChildAt(0);
	  childView.getMeasuredHeight() <= getScrollY() + getHeight();
18. **ViewPager怎么做性能优化**

	加入rootView,缓存加载后的view，如果有就不重新加载数据。
	加入判断是否已经加载数据完成的标志变量，如果已经加载了数据，就不重新加载数据。
19. **Postvalidata与Validata有什么区别**？
	一组是invalidate，另一组是postInvalidate，其中前者是在UI线程自身中使用，而后者在非UI线程中使用。
20. **Asset与raw都能存放资源，他们有什么区别？**
	- **assert**：可以以任何方式来进行组织。这些文件最终会被原装不动地打包在apk文件中。
	- **raw**：都是原装不动地打包在apk文件中的，不过它们会被赋予资源ID，这样我们就可以在程序中通过ID来访问它们。
	- **drawable**：注意，保存在这个目录中的Bitmap文件在打包的过程中，可能会被优化的 
1. **LurCahce原理**
2. **什么是反射，在哪里需要用到？**
3. **推送原理：**
4. 设计一个图片缓存加载机制
5. 设计一个文件的断点续传系统；
6. 应用怎么判断自己是处于前台还是后台
4. 什么是 MVC 模式？MVC 模式的好处是什么？
4. IntentService是Service的子类，是一个异步的，会自动停止的服务，很好解决了传统的Service中处理完耗时操作忘记停止并销毁Service的问题
会创建独立的worker线程来处理所有的Intent请求；
会创建独立的worker线程来处理onHandleIntent()方法实现的代码，无需处理多线程问题；
所有请求处理完成后，IntentService会自动停止，无需调用stopSelf()方法停止Service；
为Service的onBind()提供默认实现，返回null；
为Service的onStartCommand提供默认实现，将请求Intent添加到队列中；
IntentService不会阻塞UI线程，而普通Serveice会导致ANR异常
Intentservice若未执行完成上一次的任务，将不会新开一个线程，是等待之前的任务完成后，再执行新的任务，等任务完成后再次调用stopSelf()