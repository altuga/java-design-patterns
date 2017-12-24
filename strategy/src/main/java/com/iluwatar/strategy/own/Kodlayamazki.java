package com.iluwatar.strategy.own;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Kodlayamazki implements KodYazabilme {

	private static final Logger LOGGER = LoggerFactory.getLogger(Kodlayamazki.class);

	public void kodla() {
		LOGGER.info("Kodlamak !! ; o ne nedir ?");
	}
}
