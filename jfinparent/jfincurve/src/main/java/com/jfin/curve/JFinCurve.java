package com.jfin.curve;

import org.joda.time.LocalDate;

import com.jfin.curve.factor.JFinFactorCurve;
import com.jfin.curve.instrument.JFinCurveInstrumentCollection;

public interface JFinCurve {

	/** start / reference date of the curve **/
	LocalDate curveDate();

	/** instruments (quotes) that make up this curve instance **/
	JFinCurveInstrumentCollection instruments();

	/** bootstrapped curve factors **/
	JFinFactorCurve factors();

	/** call to generate or bootstrap the curve **/
	void generate();
}