package com.jfin.curve.instrument;

import org.joda.time.LocalDate;

import com.jfin.enums.JFinBdc;
import com.jfin.enums.JFinDcc;

public class JFinForwardInstrument extends AbstractJFinCurveInstrument {

	private static final long serialVersionUID = -2198149026614290816L;

	public JFinForwardInstrument(final String id, final LocalDate start, final LocalDate end, final double value,
			final JFinDcc dcc, final JFinBdc bdc) {
		super(id, start, end, value, dcc, bdc);
	}

	public double rate() {
		return value();
	}

	public JFinCurveInstrument copy() {
		return new JFinForwardInstrument(id, start, end, serialVersionUID, dcc, bdc);
	}
}