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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.core.plugins.ComponentInformation;

import javax.validation.constraints.NotNull;

/**
 * This plugin adds the possibility to search for items in the tree and even to show only matching nodes.
 *
 * @author GedMarc
 * @version 1.0
 * @since 23 Dec 2016
 */
@ComponentInformation(name = "JS Tree Search Plugin",
		description = "This plugin adds the possibility to search for items in the tree and even to show only matching nodes.",
		url = "https://www.jstree.com/plugins/")
public class JSTreeSearchOptions<J extends JSTreeSearchOptions<J>>
		extends JavaScriptPart<J>
{


	/**
	 * a jQuery-like AJAX config, which jstree uses if a server should be queried for results. A str (which is the search string) parameter will be added with the request, an
	 * optional inside parameter
	 * will be added if the search is limited to a node id. The expected result is a JSON array with nodes that need to be opened so that matching nodes will be revealed. Leave
	 * this setting as false
	 * to not query the server. You can also set this to a function, which will be invoked in the instance's scope and receive 3 parameters - the search string, the callback to
	 * call with the array of
	 * nodes to load, and the optional node ID to limit the search to
	 */
	private JSTreeSearchOptionsAjax<?> ajax;
	/**
	 * Indicates if the search should be fuzzy or not (should chnd3 match child node 3). Default is false.
	 */
	private Boolean fuzzy;
	/**
	 * Indicates if the search should be case sensitive. Default is false.
	 */
	@JsonProperty("case_sensitive")
	private Boolean caseSensitive;
	/**
	 * Indicates if the tree should be filtered (by default) to show only matching nodes (keep in mind this can be a heavy on large trees in old browsers).
	 * <p>
	 * This setting can be changed at runtime when calling the search method. Default is false.
	 */
	@JsonProperty("show_only_matches")
	private Boolean showOnlyMatches;
	/**
	 * Indicates if the children of matched element are shown (when show_only_matches is true)
	 * <p>
	 * This setting can be changed at runtime when calling the search method. Default is false.
	 */
	@JsonProperty("show_only_matches_children")
	private Boolean showOnlyMatchesChildren;
	/**
	 * Indicates if all nodes opened to reveal the search result, should be closed when the search is cleared or a new search is performed. Default is true.
	 */
	@JsonProperty("close_opened_onclear")
	private Boolean closeOpenedOnClear;
	/**
	 * Indicates if only leaf nodes should be included in search results. Default is false.
	 */
	@JsonProperty("search_leaves_only")
	private Boolean searchLeavesOnly;

	public JSTreeSearchOptions()
	{
		//Nothing Needed
	}

	/**
	 * a jQuery-like AJAX config, which jstree uses if a server should be queried for results.
	 * <p>
	 * A str (which is the search string) parameter will be added with the request, an optional inside parameter will be added if the search is limited to a node id. The expected
	 * result is a JSON
	 * array with nodes that need to be opened so that matching nodes will be revealed. Leave this setting as false to not query the server. You can also set this to a function,
	 * which will be invoked
	 * in the instance's scope and receive 3 parameters - the search string, the callback to call with the array of nodes to load, and the optional node ID to limit the search to
	 *
	 * @return
	 */
	public JSTreeSearchOptionsAjax<?> getAjax()
	{
		return ajax;
	}

	/**
	 * a jQuery-like AJAX config, which jstree uses if a server should be queried for results. A str (which is the search string) parameter will be added with the request, an
	 * optional inside parameter
	 * will be added if the search is limited to a node id. The expected result is a JSON array with nodes that need to be opened so that matching nodes will be revealed. Leave
	 * this setting as false
	 * to not query the server. You can also set this to a function, which will be invoked in the instance's scope and receive 3 parameters - the search string, the callback to
	 * call with the array of
	 * nodes to load, and the optional node ID to limit the search to
	 *
	 * @param ajax
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setAjax(JSTreeSearchOptionsAjax<?> ajax)
	{
		this.ajax = ajax;
		return (J) this;
	}

	/**
	 * Indicates if the search should be fuzzy or not (should chnd3 match child node 3). Default is false.
	 *
	 * @return
	 */
	public Boolean getFuzzy()
	{
		return fuzzy;
	}

	/**
	 * Indicates if the search should be fuzzy or not (should chnd3 match child node 3). Default is false.
	 *
	 * @param fuzzy
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setFuzzy(Boolean fuzzy)
	{
		this.fuzzy = fuzzy;
		return (J) this;
	}

	/**
	 * Indicates if the search should be case sensitive. Default is false.
	 *
	 * @return
	 */
	public Boolean getCaseSensitive()
	{
		return caseSensitive;
	}

	/**
	 * Indicates if the search should be case sensitive. Default is false.
	 *
	 * @param caseSensitive
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setCaseSensitive(Boolean caseSensitive)
	{
		this.caseSensitive = caseSensitive;
		return (J) this;
	}

	/**
	 * Indicates if the tree should be filtered (by default) to show only matching nodes (keep in mind this can be a heavy on large trees in old browsers).
	 * <p>
	 * This setting can be changed at runtime when calling the search method. Default is false.
	 *
	 * @return
	 */
	public Boolean getShowOnlyMatches()
	{
		return showOnlyMatches;
	}

	/**
	 * Indicates if the tree should be filtered (by default) to show only matching nodes (keep in mind this can be a heavy on large trees in old browsers).
	 * <p>
	 * This setting can be changed at runtime when calling the search method. Default is false.
	 *
	 * @param showOnlyMatches
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setShowOnlyMatches(Boolean showOnlyMatches)
	{
		this.showOnlyMatches = showOnlyMatches;
		return (J) this;
	}

	/**
	 * Indicates if the children of matched element are shown (when show_only_matches is true)
	 * <p>
	 * This setting can be changed at runtime when calling the search method. Default is false.
	 *
	 * @return
	 */
	public Boolean getShowOnlyMatchesChildren()
	{
		return showOnlyMatchesChildren;
	}

	/**
	 * Indicates if the children of matched element are shown (when show_only_matches is true)
	 * <p>
	 * This setting can be changed at runtime when calling the search method. Default is false.
	 *
	 * @param showOnlyMatchesChildren
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setShowOnlyMatchesChildren(Boolean showOnlyMatchesChildren)
	{
		this.showOnlyMatchesChildren = showOnlyMatchesChildren;
		return (J) this;
	}

	/**
	 * Indicates if all nodes opened to reveal the search result, should be closed when the search is cleared or a new search is performed. Default is true.
	 *
	 * @return
	 */
	public Boolean getCloseOpenedOnClear()
	{
		return closeOpenedOnClear;
	}

	/**
	 * Indicates if all nodes opened to reveal the search result, should be closed when the search is cleared or a new search is performed. Default is true.
	 *
	 * @param closeOpenedOnClear
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setCloseOpenedOnClear(Boolean closeOpenedOnClear)
	{
		this.closeOpenedOnClear = closeOpenedOnClear;
		return (J) this;
	}

	/**
	 * Indicates if only leaf nodes should be included in search results. Default is false.
	 *
	 * @return
	 */
	public Boolean getSearchLeavesOnly()
	{
		return searchLeavesOnly;
	}

	/**
	 * Indicates if only leaf nodes should be included in search results. Default is false.
	 *
	 * @param searchLeavesOnly
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setSearchLeavesOnly(Boolean searchLeavesOnly)
	{
		this.searchLeavesOnly = searchLeavesOnly;
		return (J) this;
	}

}
