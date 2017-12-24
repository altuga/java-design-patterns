package com.iluwatar.strategy.own;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ITUzmaniAyse extends ITUzmani {

	private static final Logger LOGGER = LoggerFactory.getLogger(ITUzmaniAyse.class);

	public ITUzmaniAyse() {
		kodYazabilme = new Kodlayamazki();
		testEdebilme = new TestUzmaniSenior();
	}

	public void display() {
		LOGGER.info("Merhaba Ben Ayse");
	}
}
