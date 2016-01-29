package com.jfin.curve.instrument;

import org.joda.time.LocalDate;

import com.jfin.enums.JFinBasisType;
import com.jfin.enums.JFinBdc;
import com.jfin.enums.JFinDcc;

public class JFinBasisInstrument extends AbstractJFinCurveInstrument {

	private static final long serialVersionUID = -5835034872445296045L;

	private final JFinBasisType type;

	public JFinBasisInstrument(final String id, final LocalDate start, final LocalDate end, final double basis,
			final JFinBasisType type, final JFinDcc dcc, final JFinBdc bdc) {
		super(id, start, end, basis, dcc, bdc);
		this.type = type;
	}

	public final double basis() {
		return value();
	}

	public final JFinBasisType type() {
		return type;
	}

	public JFinCurveInstrument copy() {
		return new JFinBasisInstrument(id, start, end, value, type, dcc, bdc);
	}
}