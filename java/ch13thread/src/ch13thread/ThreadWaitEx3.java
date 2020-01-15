package ch13thread;

import java.util.ArrayList;
// 손님객체
class Customer implements Runnable {
	// 손님이 들어오면 테이블을 할당해주고, 음식주문을 받는다.
	private Table table;
	private String food;
	
	// 생성자를 이용해서 테이블을 할당해 주고, 음식주문을 받는다.
	Customer(Table table, String food){
		this.table = table;
		this.food = food;
	}
	public void run() {
		// 음식이 나오면 처리문을 계속 진행해서 본인의 음식이면 먹는다.
		while(true) {
			// 약간의 딜레이 타임. 동작을 원할하게 하기 위해서.
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {}
			String name = Thread.currentThread().getName();
			// 음식을 먹는다.-> wait를 반복하다가 음식을 먹으면 notify를 한다.
			table.remove(food);
			System.out.println(name + " ate a " + food);
		}
	}
}
// 주방장 객체
class Cook implements Runnable{
	//주방장은 손님과  같은 테이블을 공유하기 위해서 생성자를 이용해서 파라메터로 받는다.
	private Table table;
	
	Cook(Table table){this.table = table;}
	
	public void run() {
		// 테이블의 올려 놓은 음식이 최대 음식 갯수보다 적으면 음식을 만들어서 테이블에 올려 놓는다.
		while(true) {
			// 메뉴판에서 만들 메뉴를 램덤하게 선택한다.
			int idx = (int)(Math.random()*table.dishNum());
			// 음식을 만든다. -> table이 꽉차있으면 wait하다가 음식을 만들면 notify한다.
			table.add(table.dishNames[idx]);
			try {Thread.sleep(10);}catch(InterruptedException e) {}
		}
	}
}
// 테이블 객체
class Table {
	// 테이블 정보 저장 변수- 메뉴판 (음식주문), 전체음식수, 음식이 저장되는 접시 배열
	// 메뉴판 변수
	String[] dishNames = {"도넛", "도넛", "버거"};
	// 테이블에 올려 놓을 수 있는 전체 음식의 갯수
	final int MAX_FOOD = 6;
	private ArrayList<String>dishes = new ArrayList<>();
	
	// 주방장이 음식을 만들어서 올려 놓은 메서드 - 동기화 메서드 -> 한순간에는 한가지 메뉴만 만든다.
	public synchronized void add(String dish) {
		// 음식이 테이블에 꽉 찼다.
		while(dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name + " 기다리는 중 입니다.");
			try {
				wait();// notify()에 의해서 깨어난다.
				Thread.sleep(500);// 깨어나면 0.5초를 기다린다.
			}catch(InterruptedException e) {}
		}
    //테이블에 음식이 비었다.
		dishes.add(dish); // 랜덤으로 만들려고하는 음식을 만든다. -> 파라메터로 전달 받는다.
		// wait하고 있는 손님 쓰레드를 깨운다.
		notify();
		// 현재 테이블에 있는 모든 음식 목록을 출력
		System.out.println("나온 음식:" + dishes.toString());
	}
	// 손님이 음식을 먹어 치우는 메서드 
	public void remove (String dishName) {
		// 동기화 블록 -> 한 손님이 먹고 있는 음식을 다른 손님이 먹지 못하도록 동기화 시킨다.
		synchronized (this) {
			// 손님쓰레드 이름을 가져온다.
			String name = Thread.currentThread().getName();
			// 테이블에 만들어진 음식이 없으면 기다린다.
			while(dishes.size()==0) {
				System.out.println(name + " 기다리는 중 입니다.");
				try {
					wait();// notify()에 의해서 깨어난다.
					Thread.sleep(500);// 깨어나면 0.5초를 기다린다.
				}catch(InterruptedException e) {}
			}
			// 테이블에 만들어진 음식이 있다. -> 내가 주문한 음식이 나와서 먹을때 까지 무한 루프.
			while(true) {
				// 내가 주문한 음식이 있는지 확인 
				for(int i = 0; i<dishes.size(); i++) {
					// 테이블에 있는 음식(dishes) 내가 주문한 음식(dish)인지 확인한다.
					if(dishName.equals(dishes.get(i))) {
						// 손님이 음식을 먹는다.
						dishes.remove(i);
						// 다른 쓰레드에게 깨어나도록 처리(주방장이 포함되어 있다.)
						notify();
						// 손님이 먹어치우는 메서드를 빠져 나간다.
						return;
					}
				}// end of for -> dishes에 주문한 음식이 있는지 확인 하는 for
				// 주문한 음식이 없는 경우 처리 -> 기다린다. (주방장이 음식을 만들고 notify 때)
				try {
					System.out.println(name + " 기다리는 중 입니다.");
					wait(); 
					Thread.sleep(500);
				}catch(InterruptedException e) {}
			}
		}
	}
	// 만들 수 있는 음식의 갯수 (메뉴판 음식의 갯수)를 알아내는 메서드
	public int dishNum() {return dishNames.length;}
}

//여러개의 class가 있는 경우 public으로 작성 할 수 있는 class는 파일이름과 동일한 클래스만 가능하다.
class ThreadWaitEx3 {
	public static void main(String[] args) throws Exception {
		// 공통으로 사용하는 테이블 생성 
		Table table = new Table();
		// 주방장 쓰레드
		new Thread(new Cook(table), "요리사").start();
		// 손님 1 쓰레드
		new Thread(new Customer(table, "도넛"), "손님1").start();
		// 손님 2 쓰레드 
		new Thread(new Customer(table, "버거"), "손님2").start();
		Thread.sleep(2000);
		System.exit(0);
	}
		
}
	