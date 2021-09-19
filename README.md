# Mybatis
>### 框架的使用方式：
  1. 通过sql的id，使用SqlSession对象，执行sql语句。
  2. 使用自定义的dao对象。
  3. 使用mybatis的代理对象<br>
         -------使用SqlSession.getMapper()获取一个dao对象，通过这个dao对象执行方法就能访问数据库。<br>
         -------核心是mybatis创建的dao,也就是调用SqlSession的方法执行sql语句

>### mybatis框架的使用步骤
  1. 实体类：使用实体类表示表中的数据：表中的一行数据就相当于是一个实体类对象。
  2. 定义dao接口：定义方法，方法表示要执行的数据库操作，方法名称应该和mapper文件中的id名称一样。
  3. 定义mapper文件，是一个xml文件，编写sql语句
  4. 定义mybatis主配置文件：1）定义数据源DataSource；2）指定mapper文件的位置。
  5. mybatis执行sql语句的核心对象：sqlSession，使用SqlSession的方法执行sql语句，使用SqlSessionFactory的openSession（）方法获取SqlSession对象
  
 > ### mybatis的传参
  ##### 从java程序把数据传入到mapper的文件中的sql语句
  1. dao方法有一个简单类型的参数，在mapper文件中，使用 #{任意字符串}
  2. 使用@Param注解给参数命名，在mapper文件，使用#{自定义的名称}
  3. 使用java对象传参，在mapper文件中，使用#{java对象属性名称}
  4. 使用参数位置，在mapper文件中，使用#{arg位置值，从0开始}
  5. 使用map，#{map的key}


> #和$区别
1. #是占位符，使用？做占位符，mybatis内部使用PreparedStatement对象执行sql语句，效率高
2. #表示列的值，一般是放在等号的右侧使用
3. $是字符串代理连接，把sql语句和${}位置的值连接在一起
4. $所表示的内容是原样替换
5. $使用的sql语句，mybatis使用的是Statement对象执行sql
6. $一般是替换表名，列名，部分sql语句的

>### mybatis封装SQL语句执行结果
##### mybatis执行SQL语句后，把ResultSet转为java对象，mybatis负责创建对象，给属性赋值

1. resultType：在``` <select> ```标签中使用，把查询对象的结果转为java对象的类型  
-------------- 1). java类型的全限定名称  
-------------- 2). 别名   

2. resultMap：自定义列名和属性名称的对应关系  
-------------- 1). 先使用 ``` <resultMap> ``` 定义列和属性对应关系 <br>
 --------------2). 在``` <select resultMap>="定义好的名称"> ```

>### 表的列名和java对象的属性名称不一样
1. 使用resultMap指定列名和属性名称的对应
2. 使用resultType通过别名的方式，指定别名和属性名称对应一致


>### 模糊查询Like的使用

1. 在java代码中指定模糊查询的内容，例如'%李%'，然后把这个值传入到sql语句中    
2.在sql语句中拼接Like的内容，方式 where name like '%'空格#{name}空格'%'

>### 动态SQL
##### 通过在mapper中使用标签，通过条件生成不同的sql语句，主要是控制where条件部分
1. ``` <if test='boolean条件'> ``` :当条件为true，把SQL语句加到主SQL中  
2. ``` <where> ``` ：where里面是if，当if条件有一个满足，在主SQL语句加入where关键字和条件  
3. ``` <foreach> ```   
--------------1). 循环基本类型，例如List<Integer>  
--------------2). 循环对象类型，例如List<Student>

>### mybatis主配置文件的配置内容
1. settings中可以配置日志
2. 配置别名 ``` <typeAilases> ``` 1). typeAlias : 一次只能给一个java类型配置别名  2).package；把一个包中的所有类作为别名。类名就是别名  
3. dataSource : 配置数据源  
4. 配置mapper文件的位置 1). 使用 ``` <mapper resource=''/> ``` 2). 使用 ``` <package name= '包名' /> ```  
5. 使用属性配置文件（.properties） 1). 定义属性配置文件，在resource目录下创建jdbc.properties。 2). 属性配置文件中，定义key=value 3).在mybatis主配置文件中，使用
``` <proper resource='类路径之下的jdbc.properties'/> ``` 4). 在需要使用值的地方，语法${key}

>### PageHelp
##### 是一个插件，给sql语句增加分页功能。在我们sql语句之后，通过插件加入limit这样的语句

###### 使用步骤
1. 加入依赖
2. 在mybatis主配置文件中，加入plugin  ``` <plugins>
            <plugin interceptor="com.github.pagehelper.PageInterceptor">
            </plugin> ```  
  
3.在你查询方法之前加入 PageHelper.starPage(第几页，每页几行数据)
