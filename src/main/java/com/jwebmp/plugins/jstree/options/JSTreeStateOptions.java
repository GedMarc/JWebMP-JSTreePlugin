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
package com.jwebmp.plugins.jstree.options;

import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.core.htmlbuilder.javascript.JavascriptLiteralFunction;

import jakarta.validation.constraints.NotNull;

/**
 * This plugin saves all opened and selected nodes in the user's browser, so when returning to the same tree the previous state will be restored.
 *
 * @author GedMarc
 * @version 1.0
 * @since 23 Dec 2016
 */
public class JSTreeStateOptions<J extends JSTreeStateOptions<J>>
		extends JavaScriptPart<J>
{


	/**
	 * A string for the key to use when saving the current tree (change if using multiple trees in your project). Defaults to jstree.
	 */
	private String key;
	/**
	 * A space separated list of events that trigger a state save. Defaults to changed.jstree open_node.jstree close_node.jstree.
	 */
	private String events;
	/**
	 * Time in milliseconds after which the state will expire. Defaults to 'false' meaning - no expire.
	 */
	private Integer ttl;
	/**
	 * A function that will be executed prior to restoring state with one argument - the state object. Can be used to clear unwanted parts of the state.
	 */
	private JavascriptLiteralFunction filter;

	public JSTreeStateOptions()
	{
		//Nothing Needed
	}

	/**
	 * A string for the key to use when saving the current tree (change if using multiple trees in your project). Defaults to jstree.
	 *
	 * @return
	 */
	public String getKey()
	{
		return key;
	}

	/**
	 * A string for the key to use when saving the current tree (change if using multiple trees in your project). Defaults to jstree.
	 *
	 * @param key
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setKey(String key)
	{
		this.key = key;
		return (J) this;
	}

	/**
	 * A space separated list of events that trigger a state save. Defaults to changed.jstree open_node.jstree close_node.jstree.
	 *
	 * @return
	 */
	public String getEvents()
	{
		return events;
	}

	/**
	 * A space separated list of events that trigger a state save. Defaults to changed.jstree open_node.jstree close_node.jstree.
	 *
	 * @param events
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setEvents(String events)
	{
		this.events = events;
		return (J) this;
	}

	/**
	 * Time in milliseconds after which the state will expire. Defaults to 'false' meaning - no expire.
	 *
	 * @return
	 */
	public Integer getTtl()
	{
		return ttl;
	}

	/**
	 * Time in milliseconds after which the state will expire. Defaults to 'false' meaning - no expire.
	 *
	 * @param ttl
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setTtl(Integer ttl)
	{
		this.ttl = ttl;
		return (J) this;
	}

	/**
	 * A function that will be executed prior to restoring state with one argument - the state object. Can be used to clear unwanted parts of the state.
	 *
	 * @return
	 */
	public JavascriptLiteralFunction<?> getFilter()
	{
		return filter;
	}

	/**
	 * A function that will be executed prior to restoring state with one argument - the state object. Can be used to clear unwanted parts of the state.
	 *
	 * @param filter
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setFilter(JavascriptLiteralFunction<?> filter)
	{
		this.filter = filter;
		return (J) this;
	}

}
