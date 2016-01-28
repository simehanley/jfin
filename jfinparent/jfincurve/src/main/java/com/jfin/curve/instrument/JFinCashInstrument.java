package com.jfin.curve.instrument;

import org.joda.time.LocalDate;

import com.jfin.enums.JFinBdc;
import com.jfin.enums.JFinDcc;

public class JFinCashInstrument extends AbstractJFinCurveInstrument {

	private static final long serialVersionUID = 7715400351961290544L;

	public JFinCashInstrument(final String id, final LocalDate start, final LocalDate end, final double value,
			final JFinDcc dcc, final JFinBdc bdc) {
		super(id, start, end, value, dcc, bdc);
	}

	public double rate() {
		return value();
	}

	public JFinCurveInstrument copy() {
		return new JFinCashInstrument(id, start, end, value, dcc, bdc);
	}
}