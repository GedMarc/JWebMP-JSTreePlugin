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
import com.jwebmp.plugins.jstree.options.functions.JSTreeCheckCallbackFunction;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author GedMarc
 * @version 1.0
 * @since 22 Dec 2016
 */
public class JSTreeCoreOptions<J extends JSTreeCoreOptions<J>>
		extends JavaScriptPart<J>
{


	/**
	 * If left as false the HTML inside the jstree container element is used to populate the tree (that should be an unordered list with list items). You can also pass in a HTML
	 * string or a JSON array
	 * here. It is possible to pass in a standard jQuery-like AJAX config and jstree will automatically determine if the response is JSON or HTML and use that to populate the tree.
	 * In addition to the
	 * standard jQuery ajax options here you can suppy functions for data and url, the functions will be run in the current instance's scope and a param will be passed indicating
	 * which node is being
	 * loaded, the return value of those functions will be used. The last option is to specify a function, that function will receive the node being loaded as argument and a second
	 * param which is a
	 * function which should be called with the result.
	 */
	private JSTreeAjaxConfigOptions<?> data;
	/**
	 * configure the various strings used throughout the tree You can use an object where the key is the string you need to replace and the value is your replacement. Another
	 * option is to specify a
	 * function which will be called with an argument of the needed string and should return the replacement. If left as false no replacement is made.
	 */
	private Map<String, String> strings;
	/**
	 * determines what happens when a user tries to modify the structure of the tree
	 * <p>
	 * If left as false all operations like create, rename, delete, move or copy are prevented. You can set this to true to allow all interactions or use a function to have better
	 * control.
	 */
	@JsonProperty("check_callback")
	private JSTreeCheckCallbackFunction checkCallback;
	/**
	 * the open / close animation duration in milliseconds - set this to false to disable the animation (default is 200)
	 */
	private Integer animation;
	/**
	 * a boolean indicating if multiple nodes can be selected
	 */
	private Boolean multiple;

	/**
	 * theme configuration object
	 */
	private JSTreeThemeOptions<?> themes;
	/**
	 * if left as true web workers will be used to parse incoming JSON data where possible, so that the UI will not be blocked by large requests. Workers are however about 30%
	 * slower. Defaults to true
	 */
	private Boolean worker;
	/**
	 * Force node text to plain text (and escape HTML). Defaults to false
	 */
	@JsonProperty("force_text")
	private Boolean forceText;

	/**
	 * Should the node should be toggled if the text is double clicked . Defaults to true
	 */
	@JsonProperty("dblclick_toggle")
	private Boolean doubleClickToggle;

	public JSTreeCoreOptions()
	{
		//Nothing Needed
	}

	/**
	 * If left as false the HTML inside the jstree container element is used to populate the tree (that should be an unordered list with list items). You can also pass in a HTML
	 * string or a JSON array
	 * here. It is possible to pass in a standard jQuery-like AJAX config and jstree will automatically determine if the response is JSON or HTML and use that to populate the tree.
	 * In addition to the
	 * standard jQuery ajax options here you can suppy functions for data and url, the functions will be run in the current instance's scope and a param will be passed indicating
	 * which node is being
	 * loaded, the return value of those functions will be used. The last option is to specify a function, that function will receive the node being loaded as argument and a second
	 * param which is a
	 * function which should be called with the result.
	 *
	 * @return
	 */
	public JSTreeAjaxConfigOptions<?> getData()
	{
		if (data == null)
		{
			data = new JSTreeAjaxConfigOptions<>();
		}
		return data;
	}

	/**
	 * If left as false the HTML inside the jstree container element is used to populate the tree (that should be an unordered list with list items). You can also pass in a HTML
	 * string or a JSON array
	 * here. It is possible to pass in a standard jQuery-like AJAX config and jstree will automatically determine if the response is JSON or HTML and use that to populate the tree.
	 * In addition to the
	 * standard jQuery ajax options here you can suppy functions for data and url, the functions will be run in the current instance's scope and a param will be passed indicating
	 * which node is being
	 * loaded, the return value of those functions will be used. The last option is to specify a function, that function will receive the node being loaded as argument and a second
	 * param which is a
	 * function which should be called with the result.
	 *
	 * @param data
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setData(JSTreeAjaxConfigOptions<?> data)
	{
		this.data = data;
		return (J) this;
	}

	/**
	 * configure the various strings used throughout the tree You can use an object where the key is the string you need to replace and the value is your replacement. Another
	 * option is to specify a
	 * function which will be called with an argument of the needed string and should return the replacement. If left as false no replacement is made.
	 *
	 * @return
	 */
	public Map<String, String> getStrings()
	{
		if (strings == null)
		{
			strings = new TreeMap<>();
		}
		return strings;
	}

	/**
	 * configure the various strings used throughout the tree You can use an object where the key is the string you need to replace and the value is your replacement. Another
	 * option is to specify a
	 * function which will be called with an argument of the needed string and should return the replacement. If left as false no replacement is made.
	 *
	 * @param strings
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setStrings(Map<String, String> strings)
	{
		this.strings = strings;
		return (J) this;
	}

	/**
	 * determines what happens when a user tries to modify the structure of the tree
	 * <p>
	 * If left as false all operations like create, rename, delete, move or copy are prevented. You can set this to true to allow all interactions or use a function to have better
	 * control.
	 *
	 * @return
	 */
	public JSTreeCheckCallbackFunction getCheckCallback()
	{
		if (checkCallback == null)
		{
			checkCallback = new JSTreeCheckCallbackFunction();
		}
		return checkCallback;
	}

	/**
	 * determines what happens when a user tries to modify the structure of the tree
	 * <p>
	 * If left as false all operations like create, rename, delete, move or copy are prevented. You can set this to true to allow all interactions or use a function to have better
	 * control.
	 *
	 * @param checkCallback
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setCheckCallback(JSTreeCheckCallbackFunction checkCallback)
	{
		this.checkCallback = checkCallback;
		return (J) this;
	}

	/**
	 * the open / close animation duration in milliseconds - set this to false to disable the animation (default is 200)
	 *
	 * @return
	 */
	public Integer getAnimation()
	{
		return animation;
	}

	/**
	 * the open / close animation duration in milliseconds - set this to false to disable the animation (default is 200)
	 *
	 * @param animation
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setAnimation(Integer animation)
	{
		this.animation = animation;
		return (J) this;
	}

	/**
	 * a boolean indicating if multiple nodes can be selected
	 *
	 * @return
	 */
	public Boolean getMultiple()
	{
		return multiple;
	}

	/**
	 * a boolean indicating if multiple nodes can be selected
	 *
	 * @param multiple
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setMultiple(Boolean multiple)
	{
		this.multiple = multiple;
		return (J) this;
	}

	/**
	 * theme configuration object
	 *
	 * @return
	 */
	public JSTreeThemeOptions<?> getThemes()
	{
		if (themes == null)
		{
			themes = new JSTreeThemeOptions();
		}
		return themes;
	}

	/**
	 * theme configuration object
	 *
	 * @param themes
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setThemes(JSTreeThemeOptions<?> themes)
	{
		this.themes = themes;
		return (J) this;
	}

	/**
	 * if left as true web workers will be used to parse incoming JSON data where possible, so that the UI will not be blocked by large requests. Workers are however about 30%
	 * slower. Defaults to true
	 *
	 * @return
	 */
	public Boolean getWorker()
	{
		return worker;
	}

	/**
	 * if left as true web workers will be used to parse incoming JSON data where possible, so that the UI will not be blocked by large requests. Workers are however about 30%
	 * slower. Defaults to true
	 *
	 * @param worker
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setWorker(Boolean worker)
	{
		this.worker = worker;
		return (J) this;
	}

	/**
	 * Force node text to plain text (and escape HTML). Defaults to false
	 *
	 * @return
	 */
	public Boolean getForceText()
	{
		return forceText;
	}

	/**
	 * Force node text to plain text (and escape HTML). Defaults to false
	 *
	 * @param forceText
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setForceText(Boolean forceText)
	{
		this.forceText = forceText;
		return (J) this;
	}

	/**
	 * Should the node should be toggled if the text is double clicked . Defaults to true
	 *
	 * @return
	 */
	public Boolean getDoubleClickToggle()
	{
		return doubleClickToggle;
	}

	/**
	 * Should the node should be toggled if the text is double clicked . Defaults to true
	 *
	 * @param doubleClickToggle
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDoubleClickToggle(Boolean doubleClickToggle)
	{
		this.doubleClickToggle = doubleClickToggle;
		return (J) this;
	}

}
