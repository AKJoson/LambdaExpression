package com.lambda.www;
/**
 * 
 * 不使用lambda表达式，通过匿名内部类来计算两个值相加的结果
 */
public class Client {
	
	public static void main(String[] args) {
		Client client = new Client();
		int result = client.calculate(10, 15, new IAdd() {
			@Override
			public int add(int a, int b) {
				return a+b;
			}
		});
		System.out.println("the result is "+result);
		
		ISayMessage isMessage = (message)->System.out.println("----"+message);
		isMessage.saySomthing("wawawa");
	}
		 
	 public int calculate(int a,int b,IAdd iAdd) {
		return iAdd.add(a, b);
	}
	 
	 interface IAdd {
		int add(int a,int b);
	}
	 interface ISayMessage{
		 void saySomthing(String message);
	 }
	 
}
