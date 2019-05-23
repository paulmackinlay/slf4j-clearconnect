package org.slf4j.impl;

import org.slf4j.helpers.BasicMDCAdapter;
import org.slf4j.spi.MDCAdapter;

/**
 * Responsible for binding the {@link MDCAdapter}. This is used by the SLF4J API.
 *
 * @author Paul Mackinlay
 */
public class StaticMDCBinder {

	/**
	 * The unique instance of this class.
	 */
	public static final StaticMDCBinder SINGLETON = new StaticMDCBinder();

	private StaticMDCBinder() {
	}

	/**
	 * Returns an instance of {@link BasicMDCAdapter}.
	 */
	public static MDCAdapter getMDCA() {
		return new BasicMDCAdapter();
	}

	public String getMDCAdapterClassStr() {
		return BasicMDCAdapter.class.getName();
	}
}
