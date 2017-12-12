package com.iluwatar.strategy.own;

public abstract class ITUzmani {
	KodYazabilme kodYazabilme;
	TestEdebilme testEdebilme;

	public ITUzmani() {
	}

	public void setKodYazabilme(KodYazabilme kodYazabilme) {
		this.kodYazabilme = kodYazabilme;
	}

	public void setTestEdebilme(TestEdebilme testEdebilme) {
        this.testEdebilme = testEdebilme;
	}

	abstract void display();

	public void kodlayabilirMisin() {
		kodYazabilme.kodla();
	}

	public void testYapabilirMisin() {
		testEdebilme.testEt();
	}


}
