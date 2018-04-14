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
package com.jwebmp.plugins.jstree;

import com.jwebmp.annotations.SiteBinder;
import com.jwebmp.base.client.HttpMethodTypes;
import com.jwebmp.base.html.Div;
import com.jwebmp.base.servlets.interfaces.IDataComponent;
import com.jwebmp.htmlbuilder.css.themes.Theme;
import com.jwebmp.plugins.ComponentInformation;
import com.jwebmp.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.plugins.jstree.events.JSTreeRefreshEvent;
import com.jwebmp.plugins.jstree.options.functions.JSTreeCoreDataFunction;
import com.jwebmp.plugins.jstree.themes.JSTreeDefaultTheme;
import com.jwebmp.plugins.jstree.themes.JSTreeTheme;

import java.util.Map;

import static com.jwebmp.utilities.StaticStrings.STRING_HASH;

/**
 * An implementation of the jsTree project.
 * <p>
 *
 * @author Marc Magon
 * @version 1.0
 * @since 29 Aug 2015
 */
@ComponentInformation(name = "jsTree",
		description = "jsTree is jquery plugin, that provides interactive trees. It is absolutely free, open source and distributed under the MIT license. jsTree is easily extendable, themable and configurable, it supports HTML & JSON data sources and AJAX loading.",
		url = "https://www.jstree.com/")
public class JSTree
		extends Div<JSTreeChildren, JSTreeAttributes, JSTreeFeatures, JSTreeEvents, JSTree>
		implements IDataComponent<JSTreeData>
{

	private static final long serialVersionUID = 1L;

	private JSTreeFeature feature;

	private JSTreeData data;

	/**
	 * Constructs a new instance of the JS Tree
	 */
	public JSTree()
	{
		addFeature(getFeature());
	}

	public final JSTreeFeature getFeature()
	{
		if (feature == null)
		{
			feature = new JSTreeFeature(this);
		}
		return feature;
	}

	/**
	 * Adds the AJAX mode
	 */
	@Override
	public void preConfigure()
	{
		if (!isConfigured())
		{
			JQueryPageConfigurator.setRequired(true);
			getOptions().getCore()
			            .getData()
			            .setType(HttpMethodTypes.POST);
			getOptions().getCore()
			            .getData()
			            .setUrl(SiteBinder.getDataLocation()
			                              .replace("/", "") + "?component=" + getID());
			getOptions().getCore()
			            .getData()
			            .setData(new JSTreeCoreDataFunction());
		}
		super.preConfigure();
	}

	@Override
	public JSTreeOptions getOptions()
	{
		return getFeature().getOptions();
	}

	/**
	 * Returns the data, and any parameters if supplied
	 *
	 * @param params
	 *
	 * @return
	 */
	@Override
	public JSTreeData getData(Map<String, String[]> params)
	{
		onGetData(params);
		String[] ids = params.get("id");
		String id = ids[0];
		if (STRING_HASH.equalsIgnoreCase(id))
		{
			return data;
		}
		else
		{
			return data.findNode(id)
			           .getChildNodes();
			//go through the nodes looking for the next id item
		}
	}

	/**
	 * Execute something before get data is called
	 *
	 * @param params
	 */
	protected void onGetData(Map<String, String[]> params)
	{
		//Not Implemented
	}

	public void setData(JSTreeData data)
	{
		this.data = data;
	}

	/**
	 * Set the tree theme
	 *
	 * @param <J>
	 * @param theme
	 */
	public <J extends Theme & JSTreeTheme> void setTheme(J theme)
	{
		theme.getCssReferences()
		     .forEach(this::addCssReference);
		if (!JSTreeDefaultTheme.class.isAssignableFrom(theme.getClass()))
		{
			getOptions().getCore()
			            .getThemes()
			            .setName(theme.getName());
		}
	}

	/**
	 * Returns a new event that refreshes the tree
	 *
	 * @return
	 */
	public JSTreeRefreshEvent getRefreshEvent()
	{
		return new JSTreeRefreshEvent(this);
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
		{
			return true;
		}
		if (!(o instanceof JSTree))
		{
			return false;
		}
		if (!super.equals(o))
		{
			return false;
		}

		JSTree jsTree = (JSTree) o;

		if (!getFeature().equals(jsTree.getFeature()))
		{
			return false;
		}
		return data.equals(jsTree.data);
	}

	@Override
	public int hashCode()
	{
		return super.hashCode();
	}
}
