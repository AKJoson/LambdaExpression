package com.lambda.www.day1;

public class LambdaClient {

	public static void main(String[] args) {
		LambdaClient client = new LambdaClient();
		MathOperation addtion = (int a, int b) -> a + b;
		int result = client.operate(10, 5, addtion);
		ICheck iCheck = (a, b) -> a > b; // not declare a and b type.
		System.out.println(result + "---");
		boolean isTrue = client.check(5, 10, iCheck);
		System.out.println(isTrue);
		ISayMessage iSayMessage = (message) -> System.out.println("wa~~wa~~" + message);
		iSayMessage.sayMessage("Never mind I will find someone like you , I wish nothing but the best for you");
	}

	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}

	private boolean check(int a, int b, ICheck iCheck) {
		return iCheck.check(a, b);
	}

	interface ICheck {
		boolean check(int a, int b);
	}

	interface MathOperation {
		int operation(int a, int b);
	}

	interface ISayMessage {
		void sayMessage(String message);
	}

}
