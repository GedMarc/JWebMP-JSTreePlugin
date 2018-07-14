package com.jwebmp.plugins.jstree.interfaces;

import com.jwebmp.htmlbuilder.css.themes.Theme;
import com.jwebmp.plugins.jstree.*;
import com.jwebmp.plugins.jstree.events.JSTreeRefreshFeature;
import com.jwebmp.plugins.jstree.options.JSTreeNodeOptions;
import com.jwebmp.plugins.jstree.options.JSTreeSearchOptions;
import com.jwebmp.plugins.jstree.options.JSTreeTypesOptions;
import com.jwebmp.plugins.jstree.options.functions.JSTreeCheckCallbackFunction;
import com.jwebmp.plugins.jstree.themes.JSTreeTheme;

import javax.validation.constraints.NotNull;

public interface IJSTree<J extends JSTree<J>>
{
	JSTreeOptions<?> getOptions();

	/**
	 * Set the tree theme
	 *
	 * @param <J2>
	 * @param theme
	 */
	<J2 extends Theme & JSTreeTheme> void setTheme(J2 theme);

	/**
	 * This plugin adds additional information about selection changes. Once included in the plugins config option, each changed.jstree event data will contain a new property named
	 * changed, which will give information about selected and deselected nodes since the last changed.jstree event
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J enableChangedEvents();

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
	@SuppressWarnings("unchecked")
	@NotNull
	J enableCheckBoxes();

	/**
	 * This plugin overrides the activate_node function (the one that gets called when a user tries to select a node) and enables preventing the function invokation by using a
	 * callback.
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J enableConditionalSelect();

	/**
	 * This plugin makes it possible to right click nodes and shows a list of configurable actions in a menu.
	 * <p>
	 * You can find all the contextmenu plugin config options in the API.
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	JSTreeCheckCallbackFunction<?> enableContextMenu();

	/**
	 * This plugin makes it possible to drag and drop tree nodes and rearrange the tree.
	 * <p>
	 * You can find all the dnd plugin config options in the API.
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	JSTreeCheckCallbackFunction<?> enableDragAndDrop();

	/**
	 * This plugin automatically arranges all sibling nodes according to a comparison config option function, which defaults to alphabetical order.
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J enableClientSideSorting();

	/**
	 * This plugin saves all opened and selected nodes in the user's browser, so when returning to the same tree the previous state will be restored.
	 * <p>
	 * You can find all the state plugin config options in the API. Make a selection and refresh this page to see the change persisted.
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J enableStateKeeping(String stateKey);

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
	JSTreeTypesOptions<?> registerType(String typeName, JSTreeTypesOptions<?> typesOptions);

	/**
	 * Enforces that no nodes with the same name can coexist as siblings. This plugin has no options, it just prevents renaming and moving nodes to a parent, which already contains
	 * a node with the same name.
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J enableForcedUniqueness();

	/**
	 * Makes each node appear block level which makes selection easier. May cause slow down for large trees in old browsers.
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J enableWholeRowSelection();

	/**
	 * This plugin makes it possible to load nodes in a single request (used with lazy loading).
	 * <p>
	 * You can find all the massload plugin config options in the API.
	 *
	 * @param renderDataClass
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	JSTreeCheckCallbackFunction<?> enableAjaxDataChildrenLazyLoading(Class<? extends JSTreeData<?>> renderDataClass);

	/**
	 * Renders this tree's data asynchronously with the given data provider
	 *
	 * @param dataProvider
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	J setRenderAsync(Class<? extends JSTreeData<?>> dataProvider);

	/**
	 * This plugin adds the possibility to search for items in the tree and even to show only matching nodes.
	 * <p>
	 * You can find all the search plugin config options in the API.
	 *
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	JSTreeSearchOptions<?> enableSearch();

	@SuppressWarnings("unchecked")
	@NotNull
	JSTreeList<?> addRoot(JSTreeListItem<?> rootItem);

	@SuppressWarnings("unchecked")
	@NotNull
	JSTreeList<?> addRoot(JSTreeListItem<?> rootItem, JSTreeNodeOptions<?> options);

	/**
	 * Returns a new event that refreshes the tree
	 *
	 * @return
	 */
	JSTreeRefreshFeature getRefreshEvent();
}
