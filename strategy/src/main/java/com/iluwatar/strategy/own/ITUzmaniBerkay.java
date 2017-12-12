package com.iluwatar.strategy.own;

public class ITUzmaniBerkay extends ITUzmani {
	public ITUzmaniBerkay() {
		setKodYazabilme(new KodcuJunior());
		setTestEdebilme(new TestEdemezki());
	}
	public void display() {
		System.out.println("Ben Berkay...");
	}
}
