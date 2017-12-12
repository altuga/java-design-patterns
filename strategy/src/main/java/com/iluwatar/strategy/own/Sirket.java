package com.iluwatar.strategy.own;

public class Sirket {
 
	public static void main(String[] args) {
 
		ITUzmaniBerkay uzmanBerkay = new ITUzmaniBerkay();
		ITUzmaniAyse uzmanAyse = new ITUzmaniAyse();

        uzmanBerkay.display();
        uzmanBerkay.kodlayabilirMisin();
        uzmanBerkay.testYapabilirMisin();


        uzmanAyse.display();
        uzmanAyse.kodlayabilirMisin();
        uzmanAyse.setKodYazabilme(new KodcuSenior()); // egitim almis ve senior kisiye donusmus
        uzmanAyse.kodlayabilirMisin();
	}
}
