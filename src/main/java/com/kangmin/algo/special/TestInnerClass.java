package com.kangmin.algo.special;

public class TestInnerClass {


	class Person {
		String name;

		Person () {

		}

		Person(String aName) {
			this.name = aName;
		}

		@Override
		public String toString() {
			return "Person name: " + this.name;
		}
	}

	class Student extends Person {
		int id;

		Student() {

		}

		Student(int id) {
			this.id = id;
		}

		Student(String aName) {
			super(aName);
		}

		Student(int id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public String toString() {
			return "Student name: " + this.name + "\n"
					+ "Student Id: " + this.id;
		}
	}


	public static void main(String[] args) {
		System.out.println("main functions starting...\n");
		TestInnerClass outer = new TestInnerClass();
		Person p = outer.new Person("Xiaoming");
		System.out.println(p);

		Person s = outer.new Student("Longzhe");
		System.out.println(s);
	}

}
