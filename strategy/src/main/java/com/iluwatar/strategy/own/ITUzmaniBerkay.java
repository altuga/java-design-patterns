package com.iluwatar.strategy.own;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ITUzmaniBerkay extends ITUzmani {

	private static final Logger LOGGER = LoggerFactory.getLogger(ITUzmaniBerkay.class);
	public ITUzmaniBerkay() {
		setKodYazabilme(new KodcuJunior());
		setTestEdebilme(new TestEdemezki());
	}
	public void display() {
		LOGGER.info("Ben Berkay...");
	}
}
