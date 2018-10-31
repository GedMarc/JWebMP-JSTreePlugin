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

import com.jwebmp.core.annotations.JWebMPSiteBinder;
import com.jwebmp.core.base.client.HttpMethodTypes;
import com.jwebmp.core.base.html.Div;
import com.jwebmp.core.htmlbuilder.css.themes.Theme;
import com.jwebmp.core.plugins.ComponentInformation;
import com.jwebmp.core.plugins.jquery.JQueryPageConfigurator;
import com.jwebmp.plugins.jstree.enumerations.JSTreeAttributes;
import com.jwebmp.plugins.jstree.events.JSTreeRefreshFeature;
import com.jwebmp.plugins.jstree.interfaces.IJSTree;
import com.jwebmp.plugins.jstree.interfaces.JSTreeChildren;
import com.jwebmp.plugins.jstree.interfaces.JSTreeEvents;
import com.jwebmp.plugins.jstree.interfaces.JSTreeFeatures;
import com.jwebmp.plugins.jstree.options.JSTreeNodeOptions;
import com.jwebmp.plugins.jstree.options.JSTreeSearchOptions;
import com.jwebmp.plugins.jstree.options.JSTreeTypesOptions;
import com.jwebmp.plugins.jstree.options.functions.JSTreeCheckCallbackFunction;
import com.jwebmp.plugins.jstree.options.functions.JSTreeCoreDataFunction;
import com.jwebmp.plugins.jstree.plugins.JSTreePlugins;
import com.jwebmp.plugins.jstree.themes.JSTreeDefaultTheme;
import com.jwebmp.plugins.jstree.themes.JSTreeTheme;

import javax.validation.constraints.NotNull;

import static com.jwebmp.core.utilities.StaticStrings.*;

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
public class JSTree<J extends JSTree<J>>
		extends Div<JSTreeChildren, JSTreeAttributes, JSTreeFeatures, JSTreeEvents, J>
		implements com.jwebmp.plugins.jstree.interfaces.IJSTree<J>
{


	private final JSTreeList<?> rootList = new JSTreeList<>();
	private JSTreeFeature feature;
	private boolean renderTreeAsync;
	private Class<? extends JSTreeData<?>> renderDataClass;

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
	 * Returns a slimmer form of the JS Tree
	 *
	 * @return
	 */
	public IJSTree<J> asMe()
	{
		return this;
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
			if (renderTreeAsync)
			{
				getOptions().getCore()
				            .getData()
				            .setType(HttpMethodTypes.POST);

				getOptions().getCore()
				            .getData()
				            .setUrl(JWebMPSiteBinder.getDataLocation()
				                                    .replace(STRING_FORWARD_SLASH, STRING_EMPTY) + "?component=" + renderDataClass.getCanonicalName()
				                                                                                                                  .replace(CHAR_DOT, CHAR_UNDERSCORE));
				getOptions().getCore()
				            .getData()
				            .setData(new JSTreeCoreDataFunction());
			}
			else
			{
				add(rootList);
			}
		}

		super.preConfigure();
	}

	@Override
	public JSTreeOptions<?> getOptions()
	{
		return getFeature().getOptions();
	}

	/**
	 * Set the tree theme
	 *
	 * @param <J>
	 * @param theme
	 */
	@Override
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
	 * This plugin adds additional information about selection changes. Once included in the plugins config option, each changed.jstree event data will contain a new property named
	 * changed, which will give information about selected and deselected nodes since the last changed.jstree event
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J enableChangedEvents()
	{
		getOptions().getPlugins()
		            .add(JSTreePlugins.Changed);
		return (J) this;
	}

	/**
	 * This plugin renders checkbox icons in front of each node, making multiple selection much easier.
	 * It also supports tri-state behavior, meaning that if a node has a few of its children checked it will be rendered as undetermined, and state will be propagated up. You can
	 * also fine tune the cascading options with the cascade config option.
	 * Keep in mind when cascading checkbox will check even disabled nodes.
	 * <p>
	 * Undetermined state is automatically calculated, but if you are using AJAX and loading on demand and want to render a node as underemined pass "undetermined" : true in its
	 * state.
	 * <p>
	 * You can find all the checkbox plugin config options in the API.
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J enableCheckBoxes()
	{
		getOptions().getPlugins()
		            .add(JSTreePlugins.Checkbox);

		getOptions().getCheckbox()
		            .setKeepSelectedStyle(false);

		return (J) this;
	}

	/**
	 * This plugin overrides the activate_node function (the one that gets called when a user tries to select a node) and enables preventing the function invokation by using a
	 * callback.
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J enableConditionalSelect()
	{
		getOptions().getPlugins()
		            .add(JSTreePlugins.ConditionalSelect);

		//TODO the conditional select event

		return (J) this;
	}

	/**
	 * This plugin makes it possible to right click nodes and shows a list of configurable actions in a menu.
	 * <p>
	 * You can find all the contextmenu plugin config options in the API.
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public JSTreeCheckCallbackFunction<?> enableContextMenu()
	{
		getOptions().getPlugins()
		            .add(JSTreePlugins.ContextMenu);

		JSTreeCheckCallbackFunction<?> context = new JSTreeCheckCallbackFunction<>();
		getOptions().getCore()
		            .setCheckCallback(context);
		return context;
	}

	/**
	 * This plugin makes it possible to drag and drop tree nodes and rearrange the tree.
	 * <p>
	 * You can find all the dnd plugin config options in the API.
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public JSTreeCheckCallbackFunction<?> enableDragAndDrop()
	{
		getOptions().getPlugins()
		            .add(JSTreePlugins.DnD);
		JSTreeCheckCallbackFunction<?> context = new JSTreeCheckCallbackFunction<>();
		getOptions().getCore()
		            .setCheckCallback(context);
		return context;
	}

	/**
	 * This plugin automatically arranges all sibling nodes according to a comparison config option function, which defaults to alphabetical order.
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J enableClientSideSorting()
	{
		getOptions().getPlugins()
		            .add(JSTreePlugins.Sort);
		return (J) this;
	}

	/**
	 * This plugin saves all opened and selected nodes in the user's browser, so when returning to the same tree the previous state will be restored.
	 * <p>
	 * You can find all the state plugin config options in the API. Make a selection and refresh this page to see the change persisted.
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J enableStateKeeping(String stateKey)
	{
		getOptions().getPlugins()
		            .add(JSTreePlugins.State);
		getOptions().getState()
		            .setKey(stateKey);
		return (J) this;
	}

	/**
	 * This plugin makes it possible to add predefined types for groups of nodes, which means to easily control nesting rules and icon for each group.
	 * <p>
	 * To set a node's type you can use set_type or supply a type property with the node's data.
	 * <p>
	 * You can find all the types plugin config options and functions in the API.
	 *
	 * @param typeName
	 * @param typesOptions
	 *
	 * @return
	 */
	@Override
	public JSTreeTypesOptions<?> registerType(String typeName, JSTreeTypesOptions<?> typesOptions)
	{
		getOptions().getPlugins()
		            .add(JSTreePlugins.Types);
		getOptions().getTypes()
		            .put(typeName, typesOptions);

		return typesOptions;
	}

	/**
	 * Enforces that no nodes with the same name can coexist as siblings. This plugin has no options, it just prevents renaming and moving nodes to a parent, which already contains
	 * a node with the same name.
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J enableForcedUniqueness()
	{
		getOptions().getPlugins()
		            .add(JSTreePlugins.Unique);

		return (J) this;
	}

	/**
	 * Makes each node appear block level which makes selection easier. May cause slow down for large trees in old browsers.
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J enableWholeRowSelection()
	{
		getOptions().getPlugins()
		            .add(JSTreePlugins.WholeRow);

		return (J) this;
	}

	/**
	 * This plugin makes it possible to load nodes in a single request (used with lazy loading).
	 * <p>
	 * You can find all the massload plugin config options in the API.
	 *
	 * @param renderDataClass
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public JSTreeCheckCallbackFunction<?> enableAjaxDataChildrenLazyLoading(Class<? extends JSTreeData<?>> renderDataClass)
	{
		getOptions().getPlugins()
		            .add(JSTreePlugins.Massload);
		getOptions().getPlugins()
		            .add(JSTreePlugins.State);

		setRenderAsync(renderDataClass);

		getOptions().getMassLoad()
		            .setType(HttpMethodTypes.POST);

		getOptions().getMassLoad()
		            .setUrl(JWebMPSiteBinder.getDataLocation()
		                                    .replace(STRING_FORWARD_SLASH, STRING_EMPTY) + "?component=" + renderDataClass.getCanonicalName()
		                                                                                                                  .replace(CHAR_DOT, CHAR_UNDERSCORE));
		getOptions().getMassLoad()
		            .setData(new JSTreeCoreDataFunction());

		JSTreeCheckCallbackFunction<?> context = new JSTreeCheckCallbackFunction<>();
		getOptions().getCore()
		            .setCheckCallback(context);
		return context;
	}

	/**
	 * Renders this tree's data asynchronously with the given data provider
	 *
	 * @param dataProvider
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public J setRenderAsync(Class<? extends JSTreeData<?>> dataProvider)
	{
		renderTreeAsync = true;
		renderDataClass = dataProvider;
		return (J) this;
	}

	/**
	 * This plugin adds the possibility to search for items in the tree and even to show only matching nodes.
	 * <p>
	 * You can find all the search plugin config options in the API.
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public JSTreeSearchOptions<?> enableSearch()
	{
		getOptions().getPlugins()
		            .add(JSTreePlugins.Search);

		JSTreeSearchOptions<?> searchOptions = new JSTreeSearchOptions();
		searchOptions.getAjax()
		             .setType(HttpMethodTypes.POST);
		searchOptions.getAjax()
		             .setUrl(JWebMPSiteBinder.getDataLocation()
		                                     .replace(STRING_FORWARD_SLASH, STRING_EMPTY) + "?component=" + renderDataClass.getCanonicalName()
		                                                                                                                   .replace(CHAR_DOT, CHAR_UNDERSCORE));
		searchOptions.getAjax()
		             .setData(new JSTreeCoreDataFunction());
		return searchOptions;
	}

	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public JSTreeList<?> addRoot(JSTreeListItem<?> rootItem)
	{
		return addRoot(rootItem, null);
	}

	/**
	 * Adds a root note to the tree
	 *
	 * @param rootItem
	 * @param options
	 *
	 * @return
	 */
	@Override
	@SuppressWarnings("unchecked")
	@NotNull
	public JSTreeList<?> addRoot(JSTreeListItem<?> rootItem, JSTreeNodeOptions<?> options)
	{
		rootItem.setAsParent(true);
		if (options != null)
		{
			rootItem.setOptions(options);
		}
		rootList.add(rootItem);
		return rootList;
	}

	/**
	 * Returns a new event that refreshes the tree
	 *
	 * @return
	 */
	@Override
	public JSTreeRefreshFeature getRefreshEvent()
	{
		return new JSTreeRefreshFeature(this);
	}

	/**
	 * @return hash-int
	 */
	@Override
	public int hashCode()
	{
		return super.hashCode();
	}

	/**
	 * Method equals ...
	 *
	 * @param o
	 * 		of type Object
	 *
	 * @return boolean
	 */
	@Override
	public boolean equals(Object o)
	{
		return super.equals(o);
	}
}
