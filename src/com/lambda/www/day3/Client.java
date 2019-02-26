package com.lambda.www.day3;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.PrimitiveIterator.OfDouble;
import java.util.logging.Logger;
import java.util.TooManyListenersException;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java8 新特性，函数式编程
 */
public class Client {
	public static void main(String[] args) {
		// let's create Stream from a array:
		User[] users = { new User(15, "罗志祥", false), new User(18, "蔡依林", true), new User(17, "林正英", false),
				new User(17, "皮皮倩", true), new User(18, "殷鹏", false) };
		// ### 对于数组可以直接这样获得 Stream
		// Stream.of(users)
		List<User> mUserList = Arrays.asList(users);
		// 对于list 可以以如下的方式来获得
		// mUserList.stream()
		// #forEach()
		mUserList.stream().forEach(user -> {
			System.out.println(user.getName() + user.getAge() + user.isGirl());
			// user.setAge(10);
		});
		// #map()
		List<Gift> giftList = mUserList.stream().map(user -> {
			Gift gift = new Gift(user, Gift.Superise.MIDDEL);
			return gift;
		}).collect(Collectors.toList());
		giftList.stream().forEach(gitf -> System.out.println(gitf.getUser().getName() + gitf.getUser().getAge()));
		// ##what is collect()?
		List<Integer> mList = mUserList.stream().map(user -> {
			return 1;
		}).collect(Collectors.toList());
		mList.forEach(a -> System.out.println(a));
		// #Filter()  filter需要的是返回true或者false.代表着当前这个对象是否被过滤，true不过滤，false 进行过滤
		mUserList.stream().filter(user -> {
			return user.getAge() > 15;
		})
		.filter(user -> {
			return "皮皮倩".equals(user.getName());
		}).collect(Collectors.toList())
				.forEach(user -> System.out.println("最终筛选出来的结果：" + user.getName() + user.getAge()));
		
		//# findFirst 
		
		User newUser = mUserList.stream()
		.filter(
		user-> {return user.getAge()==20;}
		)
		.findFirst().orElse(null);
		
		if (newUser == null) {
			System.out.println("null");
		}else {
		System.out.println(newUser.getName());
		}
		
		//# toArray  使用collect的时候，我们生成的是List的 Stream
		User[] userArray = mUserList.stream().filter(user -> {return user.getAge()>16;}).toArray(User[]::new);
		for (int i = 0; i < userArray.length; i++) {
			System.out.println(userArray[i].getName());
		}
		//# flatMap
		
		List<List<User>> lists = new ArrayList<>();
		for(int i=0;i<3;i++) {
			List<User> list = new ArrayList<>();
			User user = new User(i, "战斗机"+i, true);
			list.add(user);
			lists.add(list);
		}
		
		List<User> userlists = lists.stream().flatMap(Collection::stream)
		.collect(Collectors.toList());
		for (int i = 0; i < userlists.size(); i++) {
			System.out.println(userlists.get(i).getName());
		}
		//# peek
		mUserList.stream().peek(user->System.out.println(user.getAge())).collect(Collectors.toList());
		
		}

}
