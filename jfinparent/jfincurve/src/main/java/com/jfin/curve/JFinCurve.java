package com.jfin.curve;

import org.joda.time.LocalDate;

import com.jfin.curve.instrument.JFinCurveInstrumentCollection;

public interface JFinCurve {

	LocalDate curveDate();

	JFinCurveInstrumentCollection instruments();

	void generate();
}