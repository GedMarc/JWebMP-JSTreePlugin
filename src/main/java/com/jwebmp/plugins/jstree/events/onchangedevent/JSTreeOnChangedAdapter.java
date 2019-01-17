/*
 * Copyright (C) 2017 GedMarc
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.jwebmp.plugins.jstree.events.onchangedevent;

import com.jwebmp.core.Component;
import com.jwebmp.core.Event;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.angular.AngularAttributes;
import com.jwebmp.core.base.angular.AngularPageConfigurator;
import com.jwebmp.core.base.html.interfaces.GlobalFeatures;
import com.jwebmp.core.htmlbuilder.javascript.events.enumerations.EventTypes;
import com.jwebmp.logger.LogFactory;
import com.jwebmp.plugins.jstree.interfaces.JSTreeEvents;

import java.util.logging.Level;

import static com.jwebmp.core.utilities.StaticStrings.*;

/**
 * Handles all events. Over-ride methods.
 *
 * @author GedMarc
 */
public abstract class JSTreeOnChangedAdapter
		extends Event<GlobalFeatures, JSTreeOnChangedAdapter>
		implements JSTreeEvents
{

	/**
	 * Logger for the Component
	 */
	private static final java.util.logging.Logger LOG = LogFactory.getInstance()
	                                                              .getLogger("JSTreeOnChangedAdapter");

	private JSTreeOnChangedPluginDirective directive;

	/**
	 * Performs a click
	 *
	 * @param component
	 * 		The component this click is going to be acting on
	 */
	public JSTreeOnChangedAdapter(Component component)
	{
		super(EventTypes.undefined, component);

	}

	@Override
	public void fireEvent(AjaxCall call, AjaxResponse response)
	{
		try
		{
			onChanged(call, response);
		}
		catch (Exception e)
		{
			LOG.log(Level.WARNING, "Error In Firing Event", e);
		}
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}

	/**
	 * Sets JQuery and Angular enabled, adds the directive to angular, and the attribute to the component
	 */
	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{
			AngularPageConfigurator.setRequired(true);
			getComponent().addAttribute(AngularAttributes.ngJSTreeOnChanged, STRING_ANGULAR_EVENT_START_SHORT + renderVariables() + STRING_CLOSING_BRACKET_SEMICOLON);
		}
		super.preConfigure();
	}

	/**
	 * Triggers on Click
	 * <p>
	 *
	 * @param call
	 * 		The physical AJAX call
	 * @param response
	 * 		The physical Ajax Receiver
	 */
	public abstract void onChanged(AjaxCall call, AjaxResponse response);

	/**
	 * Returns the angular directive associated with the right click event
	 *
	 * @return
	 */
	public JSTreeOnChangedPluginDirective getDirective()
	{
		if (directive == null)
		{
			directive = new JSTreeOnChangedPluginDirective();
		}
		return directive;
	}

	/**
	 * Sets the right click angular event
	 *
	 * @param directive
	 */
	public void setDirective(JSTreeOnChangedPluginDirective directive)
	{
		this.directive = directive;
	}
}
