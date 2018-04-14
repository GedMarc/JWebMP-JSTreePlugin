/*
 * Copyright (C) 2017 Marc Magon
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
package com.jwebmp.plugins.jstree.plugins.onchangedevent;

import com.jwebmp.Component;
import com.jwebmp.Event;
import com.jwebmp.base.ajax.AjaxCall;
import com.jwebmp.base.ajax.AjaxResponse;
import com.jwebmp.base.angular.AngularAttributes;
import com.jwebmp.base.angular.AngularPageConfigurator;
import com.jwebmp.htmlbuilder.javascript.events.enumerations.EventTypes;
import com.jwebmp.plugins.jstree.JSTreeEvents;
import za.co.mmagon.logger.LogFactory;

import java.util.logging.Level;

import static com.jwebmp.utilities.StaticStrings.STRING_ANGULAR_EVENT_START_SHORT;
import static com.jwebmp.utilities.StaticStrings.STRING_CLOSING_BRACKET_SEMICOLON;

/**
 * Handles all events. Over-ride methods.
 *
 * @author Marc Magon
 */
public abstract class JSTreeOnChangedPluginAdapter
		extends Event
		implements JSTreeEvents
{

	/**
	 * Logger for the Component
	 */
	private static final java.util.logging.Logger LOG = LogFactory.getInstance()
	                                                              .getLogger("JSTreeOnChangedPluginEvent");
	private static final long serialVersionUID = 1L;
	private JSTreeOnChangedPluginDirective directive;

	/**
	 * Performs a click
	 *
	 * @param component
	 * 		The component this click is going to be acting on
	 */
	public JSTreeOnChangedPluginAdapter(Component component)
	{
		super(EventTypes.activate, component);

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
		int result = super.hashCode();
		result = 31 * result + getDirective().hashCode();
		return result;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof JSTreeOnChangedPluginAdapter))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		JSTreeOnChangedPluginAdapter that = (JSTreeOnChangedPluginAdapter) o;

		return getDirective().equals(that.getDirective());
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
}
