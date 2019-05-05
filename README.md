# ManGoSchool
校园电商

# 校园电商平台
### 这个APP主要是针对在校大学生所开发的创业项目，社交+电商
代码开发规范：
二．命名规范
（一）包（packages）的命名规范:
          采用反域名命名规则，全部使用小写字母。一级包名为com，二级包名lwz（为个人或公司名称，可以简写），三级包名guidecity（根据应用进行命名），四级包名ui或utils等（模块名或层级名），根据实际情况也是可以用五级包名，六级包名。 
         这里的四级包名是要重点理解和分类的，例如：com.lwz.应用.utils ，此包中包含：公共工具方法类

1.utils
         此包中包含：公共工具方法类，比如：SPHelperUtil、TimeUitl、FileUtil等

2.adapter
         此包中包含：一些适配器的类，比如：ArticleAdapter、FansAdapter，HistorAdaper等

3.base
         此包中包含：一些共同类的基类，比如：BaseActivity（所有的Activity类都继承这个类）、BaseFragment（所有的Fragment都继承这个类），ListItemAdapter（封装了Base Adapter的基类）等

4.bean
         此包中包含：一些属性对象类，比如：StudentBean、LonginBean、ArticleBean等

5.config
         此包中包含：最顶级的配置类，比如：MyApp（继承了Application）

6.httpservice
         此包中包含：Http数据的请求接口类，好像Retrofit网络框架请求网络数据才要使用。如：ILogin接口，IAddTopic接口，IUpdate等

7.interface
         此包中包含：某个页面或对象的所用操作接口类，这个接口主要是定义这个对象的所有方法。如：IUser接口，IArticle接口，ITopic接口等

8.model
         这是MVC或MVP框架设计中的M。此包中包含：某个页面或对象的所用操作类，这个类继承了上面定义的interface接口，重写并实现厘米那的方法。如：UserModel，ArticleMode类，TopicMode类等

9.ui
         这个ui表示的页面的意思，也是MVC或MVP中的V，很多人把这个包名写成activity，其实是不准确的，因为ui包含了activity和fragment，所以ui是四级包名，而activity和fragment是ui包下的五级包名。 
         activity此包中包含：Activity对象类。如：MainActivity类，HomeActivity类，FansListActivity类等。如果是使用了MVP框架模式，activity包名下还可以有六级包名，比如：loginMVP（包含ILoginView接口类，LoginPresenter类）、seleteTopicMVP 
         fragment此包中包含：Fragment对象类。但是Fragment一般都是多个存在的，所以fragment包下一般还有六级包名，表示里面是哪个页面的Fragment对象。

10.weight
         此包中包含：自定义View或自定义对话框等视图类。如：CursroDialog类，SpringScrollView类，ScrollListView类等

11.db
         此包中包含：数据库操作类

12.service
         此包中包含：Service服务类

13.broadcast
         此包中包含：Broadcast广播接收者类

14.provider
         此包中包含：Provider内容提供者类（用得很少）

         包名规划我感觉对程序后期阅读或修改有很大的帮助，特别是很大的程序，文件太多，不规划的话自己都不知道这个类是干什么的！ 
         当然如果程序中没有这一类的文件，这个包名是可以不写，但是一些基本的包名，基本每个程序都是需要的比如：ui、utils、adapter、weight、bean等

（二）类（classes）的命名规范：
         一般用名词，采用大驼峰命名法，尽量避免缩写，除非该缩写是众所周知的，比如HTML,URL，如果类名称中包含单词缩写，则单词缩写的每个字母均应大写。

以下是部分示例说明： 
1.activity 类，如欢迎页面类WelcomeActivity. 
2.adapter类,如商品详情适配器ProductDetailAdapter 
3.util公共方法类，如：线程池管理类：ThreadPoolManager，日志工具类：LogUtil 
4.db数据库类，以DBHelper后缀标识。如城市数据库：CityDBHelper 
5.Service类，以Service为后缀标识 
6.BroadcastReceive，以Broadcast为后缀标识 
7.ContentProvider，以Provider为后缀标识

（三）接口（interface）：
         命名规则与类一样采用大驼峰命名法，多以able或ible结尾或以I开头，如Runnable、Accessible、IUser。

（四）方法（methods）的命名规则：
         一般使用动词或动名词，采用小驼峰命名法 例如:onCreate(),run()

>1.initXXX()初始化相关方法,使用init为前缀标识
2.isXXX()、checkXXX() 方法返回值为boolean型的请使用is或check为前缀标识
3.getXXX()返回某个值的方法，使用get为前缀标识
4.processXXX() 对数据进行处理的方法，尽量使用process为前缀标识
5.displayXXX() 弹出提示框和提示信息，使用display为前缀标识
6.saveXXX()    与保存数据相关的，使用sav为e前缀标识
7.resetXXX()   对数据重组的，使用reset前缀标识
8.clearXXX()removeXXX()  清除数据相关的，使用clear或remove为前缀标识
9.drawXXX()     绘制数据或效果相关的，使用draw前缀标识

（五）变量（variables）采用小驼峰命名法。类中控件名称一般与xml布局id保持一致
（六）常量（constants）全部大写,采用下划线命名法.例如：MIN_WIDTH
（七）XML文件（布局文件）：全部小写，采用下划线命名法，
例如：main_activity.xml， item_activity.xml、homeposter_item_poster.xml

（八）资源文件（图片）： 全部小写，采用下划线命名法，加前缀区分
命名	说明
btn_login_normal	按钮图片使用btn_功能_说明
bg_head	背景图片使用bg_功能_说明
def_search_cell	默认图片使用def_功能_说明
icon_more_help	图标图片使用icon_功能_说明
seg_list_line	具有分隔特征的图片使用seg_功能_说明
sel_ok	选择图标使用sel_功能_说明
（九）动画文件（anim包）：全部小写，采用下划线命名法，加前缀区分。
动画命名例子：

规范写法	备注
click_head_left	点击背景切换动画使用click前缀标识
bg_shape_rectangle	背景自定义图形使用bg前缀标识
show_shopcar_add	小动画效果使用show前缀标识
（十）资源ID（resources id）：大小写规范与方法名一致，采用小驼峰命名法。
         命名规范为“资源控件的缩写名”+“变量名”。例如TextView的id=“tv_userName”。注意：页面控件名称应该和控件id名一般是一致，例如：TextView tv_userName=(TextView)findViewById(R.id.tv_userName);
