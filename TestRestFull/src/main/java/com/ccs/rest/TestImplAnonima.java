package com.ccs.rest;

public class TestImplAnonima {

	public static void main(String[] args) {
		TestImplAnonima t = new TestImplAnonima();
		t.anonima();
		t.anonima2();

	}
	
	public void anonima() {
		
		try {
			
			TestInter inter = new TestInter() {
				
				public Integer metodo3() {
					System.out.println("i am method three..");
					return 1000;
				}
				
				public void metodo2() {
					System.out.println("i am method two..");
				}
				
				public String metodo1() {
					return "i am method one..";
				}
			};
			
			System.out.println(inter.metodo1());
			inter.metodo2();
			inter.metodo3();
			
			
		}catch(Exception e ) {
			
		}
		
	}
	public void anonima2() {
		
		try {
			
			TestInter inter = new TestInter() {
				
				public Integer metodo3() {
					System.out.println("i am method three.. anonima 2");
					return 1000;
				}
				
				public void metodo2() {
					System.out.println("i am method two.. anonima 2");
				}
				
				public String metodo1() {
					return "i am method one.. anonima 2";
				}
			};
			
			System.out.println(inter.metodo1());
			inter.metodo2();
			inter.metodo3();
			
			
		}catch(Exception e ) {
			
		}
		
	}

}
