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

import javax.validation.constraints.NotNull;

/**
 * theme configuration object
 *
 * @author GedMarc
 * @version 1.0
 * @since 22 Dec 2016
 */
public class JSTreeThemeOptions<J extends JSTreeThemeOptions<J>>
		extends JavaScriptPart<J>
{


	/**
	 * the name of the theme to use (if left as false the default theme is used)
	 */
	private String name;
	/**
	 * the URL of the theme's CSS file, leave this as false if you have manually included the theme CSS (recommended).
	 * <p>
	 * You can set this to true too which will try to autoload the theme.
	 */
	private String url;
	/**
	 * the location of all jstree themes - only used if url is set to true
	 */
	private String dir;
	/**
	 * a boolean indicating if connecting dots are shown
	 */
	private Boolean dots;
	/**
	 * a boolean indicating if node icons are shown
	 */
	private Boolean icons;
	/**
	 * a boolean indicating if node ellipsis should be shown - this only works with a fixed with on the container
	 */
	private Boolean ellipsis;
	/**
	 * a boolean indicating if the tree background is striped
	 */
	private Boolean striped;
	/**
	 * a string (or boolean false) specifying the theme variant to use (if the theme supports variants)
	 */
	private String variant;
	/**
	 * a boolean specifying if a reponsive version of the theme should kick in on smaller screens (if the theme supports it). Defaults to false.
	 */
	private Boolean responsive;
	/**
	 * if left as true all parents of all selected nodes will be opened once the tree loads (so that all selected nodes are visible to the user)
	 */
	@JsonProperty("expand_selected_onload")
	private Boolean expandSelectedOnLoad;
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
	private Boolean dblClickToggle;

	public JSTreeThemeOptions()
	{
		//Nothing Needed
	}

	/**
	 * the name of the theme to use (if left as false the default theme is used)
	 *
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * the name of the theme to use (if left as false the default theme is used)
	 *
	 * @param name
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setName(String name)
	{
		this.name = name;
		return (J) this;
	}

	/**
	 * the URL of the theme's CSS file, leave this as false if you have manually included the theme CSS (recommended).
	 * <p>
	 * You can set this to true too which will try to autoload the theme.
	 *
	 * @return
	 */
	public String getUrl()
	{
		return url;
	}

	/**
	 * the URL of the theme's CSS file, leave this as false if you have manually included the theme CSS (recommended). You can set this to true too which will try to autoload the
	 * theme.
	 *
	 * @param url
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setUrl(String url)
	{
		this.url = url;
		return (J) this;
	}

	/**
	 * the location of all jstree themes - only used if url is set to true
	 *
	 * @return
	 */
	public String getDir()
	{
		return dir;
	}

	/**
	 * the location of all jstree themes - only used if url is set to true
	 *
	 * @param dir
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDir(String dir)
	{
		this.dir = dir;
		return (J) this;
	}

	/**
	 * a boolean indicating if connecting dots are shown
	 *
	 * @return
	 */
	public Boolean getDots()
	{
		return dots;
	}

	/**
	 * a boolean indicating if connecting dots are shown
	 *
	 * @param dots
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDots(Boolean dots)
	{
		this.dots = dots;
		return (J) this;
	}

	/**
	 * a boolean indicating if node icons are shown
	 *
	 * @return
	 */
	public Boolean getIcons()
	{
		return icons;
	}

	/**
	 * a boolean indicating if node icons are shown
	 *
	 * @param icons
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setIcons(Boolean icons)
	{
		this.icons = icons;
		return (J) this;
	}

	/**
	 * a boolean indicating if node ellipsis should be shown - this only works with a fixed with on the container
	 *
	 * @return
	 */
	public Boolean getEllipsis()
	{
		return ellipsis;
	}

	/**
	 * a boolean indicating if node ellipsis should be shown - this only works with a fixed with on the container
	 *
	 * @param ellipsis
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setEllipsis(Boolean ellipsis)
	{
		this.ellipsis = ellipsis;
		return (J) this;
	}

	/**
	 * a boolean indicating if the tree background is striped
	 *
	 * @return
	 */
	public Boolean getStriped()
	{
		return striped;
	}

	/**
	 * a boolean indicating if the tree background is striped
	 *
	 * @param striped
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setStriped(Boolean striped)
	{
		this.striped = striped;
		return (J) this;
	}

	/**
	 * a string (or boolean false) specifying the theme variant to use (if the theme supports variants)
	 *
	 * @return
	 */
	public String getVariant()
	{
		return variant;
	}

	/**
	 * a string (or boolean false) specifying the theme variant to use (if the theme supports variants)
	 *
	 * @param variant
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setVariant(String variant)
	{
		this.variant = variant;
		return (J) this;
	}

	/**
	 * a boolean specifying if a reponsive version of the theme should kick in on smaller screens (if the theme supports it). Defaults to false.
	 *
	 * @return
	 */
	public Boolean getResponsive()
	{
		return responsive;
	}

	/**
	 * a boolean specifying if a reponsive version of the theme should kick in on smaller screens (if the theme supports it). Defaults to false.
	 *
	 * @param responsive
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setResponsive(Boolean responsive)
	{
		this.responsive = responsive;
		return (J) this;
	}

	/**
	 * if left as true all parents of all selected nodes will be opened once the tree loads (so that all selected nodes are visible to the user)
	 *
	 * @return
	 */
	public Boolean getExpandSelectedOnLoad()
	{
		return expandSelectedOnLoad;
	}

	/**
	 * if left as true all parents of all selected nodes will be opened once the tree loads (so that all selected nodes are visible to the user)
	 *
	 * @param expandSelectedOnLoad
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setExpandSelectedOnLoad(Boolean expandSelectedOnLoad)
	{
		this.expandSelectedOnLoad = expandSelectedOnLoad;
		return (J) this;
	}

	/**
	 * if left as true web workers will be used to parse incoming JSON data where possible, so that the UI will not be blocked by large requests.
	 * <p>
	 * Workers are however about 30% slower. Defaults to true
	 *
	 * @return
	 */
	public Boolean getWorker()
	{
		return worker;
	}

	/**
	 * if left as true web workers will be used to parse incoming JSON data where possible, so that the UI will not be blocked by large requests.
	 * <p>
	 * Workers are however about 30% slower. Defaults to true
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
	public Boolean getDblClickToggle()
	{
		return dblClickToggle;
	}

	/**
	 * Should the node should be toggled if the text is double clicked . Defaults to true
	 *
	 * @param dblClickToggle
	 */
	@SuppressWarnings("unchecked")
	@NotNull
	public J setDblClickToggle(Boolean dblClickToggle)
	{
		this.dblClickToggle = dblClickToggle;
		return (J) this;
	}

}
