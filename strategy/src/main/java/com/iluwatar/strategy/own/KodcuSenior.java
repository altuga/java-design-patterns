package com.iluwatar.strategy.own;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KodcuSenior implements KodYazabilme {

	private static final Logger LOGGER = LoggerFactory.getLogger(KodcuSenior.class);
	public void kodla() {
		LOGGER.info("Deli gibi kodlarim ,Senior kişiyim...");
	}
}
