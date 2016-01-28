package com.jfin.curve.instrument;

import static com.jfin.common.JFinCommonConstants.ONE_HUNDRED;

import org.joda.time.LocalDate;

import com.jfin.enums.JFinBdc;
import com.jfin.enums.JFinDcc;

public class JFinFutureInstrument extends AbstractJFinCurveInstrument {

	private static final long serialVersionUID = -8735066037949611711L;

	public JFinFutureInstrument(final String id, final LocalDate start, final LocalDate end, final double value,
			final JFinDcc dcc, final JFinBdc bdc) {
		super(id, start, end, value, dcc, bdc);
	}

	public double rate() {
		return (ONE_HUNDRED - price()) / ONE_HUNDRED;
	}

	public double price() {
		return value();
	}

	public JFinCurveInstrument copy() {
		return new JFinFutureInstrument(id, start, end, value, dcc, bdc);
	}
}