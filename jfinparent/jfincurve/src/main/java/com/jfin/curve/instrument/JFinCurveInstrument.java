package com.jfin.curve.instrument;

import org.joda.time.LocalDate;

import com.jfin.enums.JFinBdc;
import com.jfin.enums.JFinDcc;

public interface JFinCurveInstrument extends Comparable<JFinCurveInstrument> {

	/** logical identifier for this instrument **/
	String id();

	/** logical start date for this instrument **/
	LocalDate start();

	/** logical end date for this instrument **/
	LocalDate end();

	/** logical value for this instrument e.g. rate, price etc. **/
	double value();

	/** logical dcc for this instrument **/
	JFinDcc dcc();

	/** logical bdc for this instrument **/
	JFinBdc bdc();

	/** return a deep copy of this instrument **/
	JFinCurveInstrument copy();
}