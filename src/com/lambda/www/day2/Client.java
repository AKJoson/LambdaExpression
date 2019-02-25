package com.lambda.www.day2;

import java.util.Arrays;
import java.util.List;
import java.util.PrimitiveIterator.OfDouble;
import java.util.TooManyListenersException;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Java8新特性之函数编程： 流
 */
public class Client {
	public static void main(String[] args) {
		//let's create Stream from a array:
		User[] users = {new User(15, "小明", true),new User(18, "小殷", true),new User(17,"小申", true)};
		Stream.of(users);
		List<User> lists = Arrays.asList(users);
		lists.stream();
		//######forEach()
		Stream.of(users).forEach(user->System.out.println(user.getName()));
		//######map()
		Stream.of(users)
		 .map(user->!user.isGirl())
		.collect(Collectors.toList())
		.forEach(action->System.out.println(action));
		
		lists.stream().map(user->{
			if (user.getAge()==18) {
				return user;
			}else {
				user.setAge(18);
				return user;
			}
		}).collect(Collectors.toList())
		.forEach(user->System.out.println(user.getAge()));
		//### what is collect()?
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
		//## Filter()过滤
		lists.stream()
		.filter(user->"小申".equals(user.getName()))
		.collect(Collectors.toList())
		.forEach(user->System.out.println(user.getName()));
		
		lists.stream()
		.filter(user->18==user.getAge())
		.collect(Collectors.toList())
		.forEach(user->System.out.println(user.getName()));
			
	}
	

}
