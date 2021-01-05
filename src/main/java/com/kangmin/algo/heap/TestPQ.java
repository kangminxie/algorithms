package com.kangmin.algo.heap;

import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

class Container {
	int cid; // not necessary
	int val;
	int stackId;
	int tierId;
}

class Data {
	PriorityQueue<Container> pq = new PriorityQueue<Container>(new Comparator<Container>() {
		@Override
		public int compare(Container c1, Container c2) {
			return c1.tierId - c2.tierId;
		}
	});
	Deque<Container> deque = new LinkedList<Container>();
	Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
}

class Pickup {
	int num;
	int cid;
	int stackId;
	int avgVal;
}

class People {
	int age;
}
public class TestPQ {

	Map<Integer, Data> map = new HashMap<Integer, Data>();

	public static void main(String[] args) {
        PriorityQueue<People> pq = new PriorityQueue<People>(
                new Comparator<People>() {
                  public int compare(People p1, People p2) {
                    return p2.age - p1.age;
                  }
                });
	}

}
