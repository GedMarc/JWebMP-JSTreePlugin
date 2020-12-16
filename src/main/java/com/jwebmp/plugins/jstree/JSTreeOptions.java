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
package com.jwebmp.plugins.jstree;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.jstree.enumerations.JSTreePlugins;
import com.jwebmp.plugins.jstree.events.onchangedevent.JSTreeOnChangedAdapter;
import com.jwebmp.plugins.jstree.options.*;

import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static com.guicedee.guicedinjection.json.StaticStrings.STRING_HASH;
import static com.jwebmp.core.utilities.StaticStrings.*;

/**
 * Holds all jstree related functions and variables, including the actual class and methods to create, access and manipulate instances.
 * <p>
 *
 * @author GedMarc
 * @version 1.0
 * 		<p>
 * 		<p>
 * @since Dec 22, 2016
 */
public class JSTreeOptions<J extends JSTreeOptions<J>>
		extends JavaScriptPart<J>
{


	/**
	 * holds all the default options used when creating new instances
	 */
	private JSTreeDefaultOptions<?> defaults;
	/**
	 * holds all jstree related functions and variables, including the actual class and methods to create, access and manipulate instances.
	 */
	private JSTreeCoreOptions<?> core;

	/**
	 * stores all loaded jstree plugins (used internally)
	 */
	private List<JSTreePlugins> plugins;
	/**
	 * specifies the jstree version in use
	 */
	private String version;

	/**
	 * This plugin adds additional information about selection changes. Once included in the plugins config option, each changed.jstree event data will contain a new property named
	 * changed, which will
	 * give information about selected and deselected nodes since the last changed.jstree event
	 */
	@JsonIgnore
	private boolean extendedChangeDetails;

	/**
	 * This plugin renders checkbox icons in front of each node, making multiple selection much easier.
	 * <p>
	 * <p>
	 * It also supports tri-state behavior, meaning that if a node has a few of its children checked it will be rendered as undetermined, and state will be propagated up. You can
	 * also fine tune the
	 * cascading options with the cascade config option.
	 * <p>
	 * <p>
	 * Keep in mind when cascading checkbox will check even disabled nodes.
	 * <p>
	 * <p>
	 * Undetermined state is automatically calculated, but if you are using AJAX and loading on demand and want to render a node as undetermined pass "undetermined" : true in its
	 * state.
	 */
	private JSTreeCheckboxOptions<?> checkbox;

	/**
	 * This plugin makes it possible to right click nodes and shows a list of configurable actions in a menu.
	 */
	@JsonProperty("contextmenu")
	private JSTreeContextMenuOptions<?> contextMenu;
	/**
	 * This plugin makes it possible to drag and drop tree nodes and rearrange the tree.
	 */
	@JsonProperty("dnd")
	private JSTreeDragAndDropOptions dragAndDrop;
	/**
	 * This plugin makes it possible to load nodes in a single request (used with lazy loading).
	 */
	@JsonProperty("massload")
	private JSTreeAjaxConfigOptions<?> massLoad;
	/**
	 * This plugin adds the possibility to search for items in the tree and even to show only matching nodes.
	 */
	private JSTreeSearchOptions<?> search;

	/**
	 * This plugin automatically arranges all sibling nodes according to a comparison config option function, which defaults to alphabetical order.
	 */
	@JsonIgnore
	private boolean sort;
	/**
	 * This plugin saves all opened and selected nodes in the user's browser, so when returning to the same tree the previous state will be restored.
	 */
	private JSTreeStateOptions<?> state;
	/**
	 * This plugin makes it possible to add predefined types for groups of nodes, which means to easily control nesting rules and icon for each group.
	 */
	private Map<String, JSTreeTypesOptions<?>> types;

	/**
	 * Enforces that no nodes with the same name can coexist as siblings. This plugin has no options, it just prevents renaming and moving nodes to a parent, which already contains
	 * a node with the
	 * same name.
	 */
	private JSTreeUniqueOptions<?> unique;

	/**
	 *
	 */
	@JsonIgnore
	private boolean wholeRowSelection;

	public JSTreeOptions()
	{
		//No Config Needed
	}

	/**
	 * holds all the default options used when creating new instances
	 *
	 * @return
	 */
	public JSTreeDefaultOptions<?> getDefaults()
	{
		if (defaults == null)
		{
			defaults = new JSTreeDefaultOptions<>();
		}
		return defaults;
	}

	/**
	 * holds all the default options used when creating new instances
	 *
	 * @param defaults
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDefaults(JSTreeDefaultOptions<?> defaults)
	{
		this.defaults = defaults;
		return (J) this;
	}

	/**
	 * specifies the jstree version in use
	 *
	 * @return
	 */
	public String getVersion()
	{
		return version;
	}

	/**
	 * specifies the jstree version in use
	 *
	 * @param version
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setVersion(String version)
	{
		this.version = version;
		return (J) this;
	}

	/**
	 * This plugin adds additional information about selection changes. Once included in the plugins config option, each changed.jstree event data will contain a new property named
	 * changed, which will
	 * give information about selected and deselected nodes since the last changed.jstree event
	 *
	 * @return
	 */
	public boolean isExtendedChangeDetails()
	{
		return extendedChangeDetails;
	}

	/**
	 * This plugin adds additional information about selection changes. Once included in the plugins config option, each changed.jstree event data will contain a new property named
	 * changed, which will
	 * give information about selected and deselected nodes since the last changed.jstree event
	 *
	 * @param tree
	 * @param extendedChangeDetails
	 * 		if on or off
	 * @param event
	 * 		The event needed if enabled
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setExtendedChangeDetails(JSTree<?> tree, boolean extendedChangeDetails, JSTreeOnChangedAdapter event)
	{
		this.extendedChangeDetails = extendedChangeDetails;
		if (this.extendedChangeDetails)
		{
			tree.addEvent(event);
			getPlugins().add(JSTreePlugins.Changed);
		}
		else
		{
			getPlugins().remove(JSTreePlugins.Changed);
		}
		return (J) this;
	}

	/**
	 * stores all loaded jstree plugins (used internally)
	 *
	 * @return
	 */
	public List<JSTreePlugins> getPlugins()
	{
		if (plugins == null)
		{
			plugins = new ArrayList<>();
		}
		return plugins;
	}

	/**
	 * stores all loaded jstree plugins (used internally)
	 *
	 * @param plugins
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setPlugins(List<JSTreePlugins> plugins)
	{
		this.plugins = plugins;
		return (J) this;
	}

	/**
	 * This plugin renders checkbox icons in front of each node, making multiple selection much easier.
	 * <p>
	 * <p>
	 * It also supports tri-state behavior, meaning that if a node has a few of its children checked it will be rendered as undetermined, and state will be propagated up. You can
	 * also fine tune the
	 * cascading options with the cascade config option.
	 * <p>
	 * <p>
	 * Keep in mind when cascading checkbox will check even disabled nodes.
	 * <p>
	 * <p>
	 * Undetermined state is automatically calculated, but if you are using AJAX and loading on demand and want to render a node as undetermined pass "undetermined" : true in its
	 * state.
	 *
	 * @return
	 */
	public JSTreeCheckboxOptions<?> getCheckbox()
	{
		if (checkbox == null)
		{
			checkbox = new JSTreeCheckboxOptions<>();
			getPlugins().add(JSTreePlugins.Checkbox);
		}
		return checkbox;
	}

	/**
	 * This plugin renders checkbox icons in front of each node, making multiple selection much easier.
	 * <p>
	 * <p>
	 * It also supports tri-state behavior, meaning that if a node has a few of its children checked it will be rendered as undetermined, and state will be propagated up. You can
	 * also fine tune the
	 * cascading options with the cascade config option.
	 * <p>
	 * <p>
	 * Keep in mind when cascading checkbox will check even disabled nodes.
	 * <p>
	 * <p>
	 * Undetermined state is automatically calculated, but if you are using AJAX and loading on demand and want to render a node as undetermined pass "undetermined" : true in its
	 * state.
	 *
	 * @param checkbox
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setCheckbox(JSTreeCheckboxOptions<?> checkbox)
	{
		if (checkbox != null)
		{
			getPlugins().add(JSTreePlugins.Checkbox);
		}
		this.checkbox = checkbox;
		return (J) this;
	}

	/**
	 * This plugin makes it possible to right click nodes and shows a list of configurable actions in a menu.
	 *
	 * @return never null
	 */
	public JSTreeContextMenuOptions<?> getContextMenu()
	{
		if (contextMenu == null)
		{
			contextMenu = new JSTreeContextMenuOptions<>();
			getPlugins().add(JSTreePlugins.ContextMenu);
		}
		return contextMenu;
	}

	/**
	 * This plugin makes it possible to right click nodes and shows a list of configurable actions in a menu.
	 *
	 * @param contextMenu
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setContextMenu(JSTreeContextMenuOptions<?> contextMenu)
	{
		if (contextMenu != null)
		{
			getPlugins().add(JSTreePlugins.ContextMenu);
		}
		this.contextMenu = contextMenu;
		return (J) this;
	}

	/**
	 * This plugin makes it possible to drag and drop tree nodes and rearrange the tree.
	 *
	 * @return
	 */
	public JSTreeDragAndDropOptions getDragAndDrop()
	{
		if (dragAndDrop == null)
		{
			dragAndDrop = new JSTreeDragAndDropOptions();
			getPlugins().add(JSTreePlugins.DnD);
		}
		return dragAndDrop;
	}

	/**
	 * This plugin makes it possible to drag and drop tree nodes and rearrange the tree.
	 *
	 * @param dragAndDrop
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDragAndDrop(JSTreeDragAndDropOptions dragAndDrop)
	{
		this.dragAndDrop = dragAndDrop;
		if (dragAndDrop != null)
		{
			getPlugins().add(JSTreePlugins.DnD);
		}
		return (J) this;
	}

	/**
	 * This plugin makes it possible to load nodes in a single request (used with lazy loading).
	 *
	 * @return
	 */
	public JSTreeAjaxConfigOptions<?> getMassLoad()
	{
		if (massLoad == null)
		{
			massLoad = new JSTreeAjaxConfigOptions<>();
			getPlugins().add(JSTreePlugins.Massload);
			getPlugins().add(JSTreePlugins.State);
		}
		return massLoad;
	}

	/**
	 * This plugin makes it possible to load nodes in a single request (used with lazy loading).
	 *
	 * @param massLoad
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setMassLoad(JSTreeAjaxConfigOptions<?> massLoad)
	{
		this.massLoad = massLoad;
		if (massLoad != null)
		{
			getPlugins().add(JSTreePlugins.Massload);
			getPlugins().add(JSTreePlugins.State);
		}
		return (J) this;
	}

	/**
	 * This plugin adds the possibility to search for items in the tree and even to show only matching nodes.
	 *
	 * @return
	 */
	public JSTreeSearchOptions<?> getSearch()
	{
		if (search == null)
		{
			setSearch(new JSTreeSearchOptions<>());
		}
		return search;
	}

	/**
	 * This plugin adds the possibility to search for items in the tree and even to show only matching nodes.
	 *
	 * @param search
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSearch(JSTreeSearchOptions<?> search)
	{
		this.search = search;
		if (search != null)
		{
			getPlugins().add(JSTreePlugins.Search);
		}
		return (J) this;
	}

	/**
	 * This plugin automatically arranges all sibling nodes according to a comparison config option function, which defaults to alphabetical order.
	 *
	 * @return
	 */
	public boolean isSort()
	{
		return sort;
	}

	/**
	 * This plugin automatically arranges all sibling nodes according to a comparison config option function, which defaults to alphabetical order.
	 *
	 * @param sort
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSort(boolean sort)
	{
		this.sort = sort;
		if (sort)
		{
			getPlugins().add(JSTreePlugins.Sort);
		}
		return (J) this;
	}

	/**
	 * This plugin saves all opened and selected nodes in the user's browser, so when returning to the same tree the previous state will be restored.
	 *
	 * @return
	 */
	public JSTreeStateOptions<?> getState()
	{
		if (state == null)
		{
			setState(new JSTreeStateOptions<>());
		}
		return state;
	}

	/**
	 * This plugin saves all opened and selected nodes in the user's browser, so when returning to the same tree the previous state will be restored.
	 *
	 * @param state
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setState(JSTreeStateOptions<?> state)
	{
		this.state = state;
		if (state != null)
		{
			getPlugins().add(JSTreePlugins.State);
		}
		return (J) this;
	}

	/**
	 * # represents the root of the tree, for example max_children would control the maximum number of root nodes.
	 *
	 * @return
	 */
	public JSTreeTypesOptions<?> addRootType()
	{
		JSTreeTypesOptions<?> type = new JSTreeTypesOptions<>();
		getTypes().put(STRING_HASH, type);
		return type;
	}

	/**
	 * This plugin makes it possible to add predefined types for groups of nodes, which means to easily control nesting rules and icon for each group.
	 *
	 * @return
	 */
	public Map<String, JSTreeTypesOptions<?>> getTypes()
	{
		if (types == null)
		{
			types = new TreeMap<>();
			getPlugins().add(JSTreePlugins.Types);
		}
		return types;
	}

	/**
	 * This plugin makes it possible to add predefined types for groups of nodes, which means to easily control nesting rules and icon for each group.
	 *
	 * @param types
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setTypes(Map<String, JSTreeTypesOptions<?>> types)
	{
		this.types = types;
		if (types != null)
		{
			getPlugins().add(JSTreePlugins.Types);
		}
		return (J) this;
	}

	/**
	 * default represents the default node - any settings here will be applied to all nodes that do not have a type specified.
	 *
	 * @return
	 */
	public JSTreeTypesOptions<?> addDefaultNodeType()
	{
		JSTreeTypesOptions<?> type = new JSTreeTypesOptions<>();
		getTypes().put("default", type);
		return type;
	}

	/**
	 * Enforces that no nodes with the same name can coexist as siblings.
	 * <p>
	 * This plugin has no options, it just prevents renaming and moving nodes to a parent, which already contains a node with the same name.
	 *
	 * @return not null, calling enables
	 */
	public JSTreeUniqueOptions<?> getUnique()
	{
		if (unique == null)
		{
			setUnique(new JSTreeUniqueOptions<>());
		}
		return unique;
	}

	/**
	 * Enforces that no nodes with the same name can coexist as siblings.
	 * <p>
	 * This plugin has no options, it just prevents renaming and moving nodes to a parent, which already contains a node with the same name.
	 *
	 * @param unique
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setUnique(JSTreeUniqueOptions<?> unique)
	{
		this.unique = unique;
		if (unique != null)
		{
			getPlugins().add(JSTreePlugins.Unique);
		}
		return (J) this;
	}

	/**
	 * Makes each node appear block level which makes selection easier. May cause slow down for large trees in old browsers.
	 *
	 * @return
	 */
	public boolean isWholeRowSelection()
	{
		return wholeRowSelection;
	}

	/**
	 * Makes each node appear block level which makes selection easier. May cause slow down for large trees in old browsers.
	 *
	 * @param wholeRowSelection
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setWholeRowSelection(boolean wholeRowSelection)
	{
		this.wholeRowSelection = wholeRowSelection;
		if (wholeRowSelection)
		{
			getPlugins().add(JSTreePlugins.WholeRow);
		}
		return (J) this;
	}

	/**
	 * holds all jstree related functions and variables, including the actual class and methods to create, access and manipulate instances.
	 *
	 * @return
	 */
	public JSTreeCoreOptions<?> getCore()
	{
		if (core == null)
		{
			core = new JSTreeCoreOptions<>();
		}
		return core;
	}

	/**
	 * holds all jstree related functions and variables, including the actual class and methods to create, access and manipulate instances.
	 *
	 * @param core
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setCore(JSTreeCoreOptions<?> core)
	{
		this.core = core;
		return (J) this;
	}
}
