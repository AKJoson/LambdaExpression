## <center>Lambda表达式</center>
1. Lambda表达式是<font color="#0099CC" size="4" >一个匿名方法</font>,将<font color="#FF0000" size="4" >行为</font>像<font color="#FF0000" size="4" >数据</font>一样进行传递。
2. Lambda 表达式常见的结构：

		BinaryOperator<Integer> add = (x,y) -> x+y;
3. 函数接口指仅具有单个抽象方法的接口，用来表示Lambda表达式的类型。
4. Lambda表达式主要用来定义<font color="#FF0000" size="4" >行内执行的方法类型接口</font>。
5. Lambda表达式<font color="#FF0000" size="5" >免去了使用匿名方法的麻烦</font>，并且给予了java简单但是强大的函数化编程能力。
### tips1：java当中涉及匿名内部类就是将一个类作为数据在进行传递。
		button.addActionListener(new ActionLisstener() {
			public void actionPerformed(ActionEvent event) {
			System.out.println("button clicked");
			}
		});
### 我们并不想传入传入对象，我们只想传入行为，因为传入对象会使代码变得难读。
---
## <center>Java8的新特性：函数式编程(要先能看的懂Lambda)：流</center>
### tips1:A stream does not store data and, in that sense, is not a data structure. It also never modifies the underlying data source.
### tips1:流不存储数据，并且在这个意义上，不是数据结构。它也永远不会修改底层数据源。

###<font color="#f800">如何创建Stream？</font>
* Let's first obtain a stream from an existing array:

		User[] users = {new User(15, "小明", true),new User(18, "小殷", true),new User(17,"小申", true)};
		Stream.of(users)//立即可以得到Stream,就可以开整了
* Let's sencond obtain a stream from a list:

		List<User> lists = Arrays.asList(users);
		//Java 8 added a new stream() method to the Collection interface.
		lists.stream() //里即获得Stream,请从这里开始你的表演。

### <font color="#f800">:forEach()操作</font>
* for example

		Stream.of(users).forEach(user->System.out.println(user.getName()));
* 上面的forEach输出是:

		小明
		小殷
		小申
* 注意 <font size="4">forEach() is a terminal operation</font>,即，forEach使用了"终结者模式",使用forEach之后在也不能进行调用！！
### <font color="#f800">:map()操作</font>
* map() produces a new stream after applying a function to each element of the original stream. The new stream could be of different type.
* <font color="#ff00ff" size=4>神翻译：</font>map()操作会产生新的Stream,而且这个新的Stream可能类型会不同。
* for Example:
		
		Stream.of(users)
		.map(user->!user.isGirl()) //注意map的isGirl的返回值是boolean,因此产生新的Stream存的是Boolean
		.collect(Collectors.toList())
		.forEach(action->System.out.println(action)); //所以这个forEach这边返回的值是：true或者false

		//输出结果：
		false
		false
		false
* 稍微改装一下，在map中进行判断之后，返回User类型：
		
		lists.stream().map(user->{
			if (user.getAge()==18) {
				return user;
			}else {
				user.setAge(18);  //所有人手动设置18一朵花，
				return user;	  //且这边的map返回的是User,因此被map之后新生成的Stream的类型是User.
			}
		}).collect(Collectors.toList())
		.forEach(user->System.out.println(user.getAge())); //可以从这看出，确实是User.

		//输出结果：【这些结果都是在eclipse上输出来的啊，真实有效】
		18
		18
		18
### <font color="#f800">:collect()</font>
* its one of the common ways to get stuff out of the stream once we are done with all the processing,we used the toList collector to collect all Stream elements into a List instance.
* 当我们做完所有操作要得到这个Stream的时候，使用collect()就对了：
		
		List<User> newLists = lists.stream().map(user->{
			if (user.getAge()==18) {
				return user;
			}else {
				user.setAge(18);
				return user;
			}
		}).collect(Collectors.toList());
		
		for(User user:newLists) {
			System.out.println(user.getName()+user.getAge()+user.isGirl());
		}
	
		//输出结果：	
		小明18true
		小殷18true
		小申18true

### <font color="#f800">:filter()</font>
*  this produces a new stream that contains elements of the original stream that pass a given test (specified by a Predicate).
*  一句话扯清楚：过滤，过滤->返回new stream。

		lists.stream()
		.filter(user->"小申".equals(user.getName()))
		.collect(Collectors.toList())
		.forEach(user->System.out.println(user.getName()));

		//输出结果,可以看出来过滤已经生效了。
		小申 