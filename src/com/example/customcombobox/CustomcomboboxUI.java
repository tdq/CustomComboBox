package com.example.customcombobox;

import javax.servlet.annotation.WebServlet;

import org.vaadin.nikolai.CustomComboBox;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("customcombobox")
public class CustomcomboboxUI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = CustomcomboboxUI.class, widgetset = "org.vaadin.nikolai.CustomcomboboxWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		setContent(layout);

		CustomComboBox customComboBox = new CustomComboBox();
		
		layout.addComponent(customComboBox);
	}

}