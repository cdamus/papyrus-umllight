/*****************************************************************************
 * Copyright (c) 2018 Christian W. Damus and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Christian W. Damus - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.umllight.ui.internal;

import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.umllight.ui"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	private LogHelper logHelper;

	/**
	 * Initializes me.
	 */
	public Activator() {
		super();
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);

		logHelper = new LogHelper(context.getBundle());
		plugin = this;
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
		logHelper = null;

		super.stop(context);
	}

	/**
	 * Obtains the shared instance.
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	public void log(Throwable exception) {
		logHelper.error("Uncaught exception", exception); //$NON-NLS-1$
	}

	public void warn(String message) {
		logHelper.warn(message);
	}

}
