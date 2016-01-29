package com.jfin.curve.instrument;

import org.joda.time.LocalDate;

import com.jfin.enums.JFinBdc;
import com.jfin.enums.JFinDcc;
import com.jfin.enums.JFinFrequency;

public class JFinSwapInstrument extends AbstractJFinCurveInstrument {

	private static final long serialVersionUID = -685087355240427320L;

	/** payment frequency of the fixed leg **/
	private JFinFrequency fixedFrequency;

	/** payment frequency of the float leg **/
	private JFinFrequency floatFrequency;

	/** float leg dcc **/
	private JFinDcc floatDcc;

	/** float leg bdc **/
	private JFinBdc floatBdc;

	public JFinSwapInstrument(final String id, final LocalDate start, final LocalDate end, final double fixedRate,
			final JFinFrequency fixedFrequency, final JFinDcc fixedDcc, final JFinBdc fixedBdc) {
		this(id, start, end, fixedRate, fixedFrequency, fixedDcc, fixedBdc, fixedFrequency, fixedDcc, fixedBdc);
	}

	public JFinSwapInstrument(final String id, final LocalDate start, final LocalDate end, final double fixedRate,
			final JFinFrequency fixedFrequency, final JFinDcc fixedDcc, final JFinBdc fixedBdc,
			final JFinFrequency floatFrequency, final JFinDcc floatDcc, final JFinBdc floatBdc) {
		super(id, start, end, fixedRate, fixedDcc, fixedBdc);
		this.fixedFrequency = fixedFrequency;
		this.floatFrequency = floatFrequency;
		this.floatDcc = floatDcc;
		this.floatBdc = floatBdc;
	}

	public double fixedRate() {
		return value();
	}

	public JFinFrequency fixedFrequency() {
		return fixedFrequency;
	}

	public JFinDcc fixedDcc() {
		return dcc();
	}

	public JFinBdc fixedBdc() {
		return bdc();
	}

	public JFinFrequency floatFrequency() {
		return floatFrequency;
	}

	public JFinDcc floatDcc() {
		return floatDcc;
	}

	public JFinBdc floatBdc() {
		return floatBdc;
	}

	public JFinCurveInstrument copy() {
		return new JFinSwapInstrument(id, start, end, value, fixedFrequency, dcc, bdc, floatFrequency, floatDcc,
				floatBdc);
	}
}