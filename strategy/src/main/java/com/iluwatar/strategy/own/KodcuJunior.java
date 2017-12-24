package com.iluwatar.strategy.own;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KodcuJunior implements KodYazabilme {

	private static final Logger LOGGER = LoggerFactory.getLogger(KodcuJunior.class);

	public void kodla() {
		LOGGER.info("Kodcuyum, yeni sayilirim ama yetenekliyim, yazarim!!");
	}
}
