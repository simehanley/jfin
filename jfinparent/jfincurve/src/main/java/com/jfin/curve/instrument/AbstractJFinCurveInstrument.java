package com.jfin.curve.instrument;

import java.io.Serializable;

import org.joda.time.LocalDate;

import com.jfin.enums.JFinBdc;
import com.jfin.enums.JFinDcc;

public abstract class AbstractJFinCurveInstrument implements JFinCurveInstrument, Serializable {

	private static final long serialVersionUID = -1763471490496588751L;

	/** unique identifier **/
	protected final String id;

	/** start date of the instrument **/
	protected final LocalDate start;

	/** end date of the instrument **/
	protected final LocalDate end;

	/** value of the instrument e.g. rate, price, spread **/
	protected final double value;

	/** day count convention / basis **/
	protected final JFinDcc dcc;

	/** business day convention / basis **/
	protected final JFinBdc bdc;

	public AbstractJFinCurveInstrument(final String id, final LocalDate start, final LocalDate end, final double value,
			final JFinDcc dcc, final JFinBdc bdc) {
		super();
		this.id = id;
		this.start = start;
		this.end = end;
		this.value = value;
		this.dcc = dcc;
		this.bdc = bdc;
	}

	public final String id() {
		return id;
	}

	public final LocalDate start() {
		return start;
	}

	public final LocalDate end() {
		return end;
	}

	public final double value() {
		return value;
	}

	public final JFinDcc dcc() {
		return dcc;
	}

	public final JFinBdc bdc() {
		return bdc;
	}

	public int compareTo(final JFinCurveInstrument instrument) {
		return end().compareTo(instrument.end());
	}
}