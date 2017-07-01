package org.vaadin.nikolai.client.customcombobox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.shared.ui.Connect;

import org.vaadin.nikolai.CustomComboBox;
import org.vaadin.nikolai.client.customcombobox.CustomComboBoxWidget;
import org.vaadin.nikolai.client.customcombobox.CustomComboBoxServerRpc;
import com.vaadin.client.communication.RpcProxy;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.client.MouseEventDetailsBuilder;
import org.vaadin.nikolai.client.customcombobox.CustomComboBoxClientRpc;
import org.vaadin.nikolai.client.customcombobox.CustomComboBoxState;
import com.vaadin.client.communication.StateChangeEvent;

@Connect(CustomComboBox.class)
public class CustomComboBoxConnector extends AbstractComponentConnector {

	CustomComboBoxServerRpc rpc = RpcProxy
			.create(CustomComboBoxServerRpc.class, this);
	
	public CustomComboBoxConnector() {
		registerRpc(CustomComboBoxClientRpc.class, new CustomComboBoxClientRpc() {
			public void alert(String message) {
				// TODO Do something useful
				Window.alert(message);
			}
		});

		// TODO ServerRpc usage example, do something useful instead
		/*
		getWidget().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				final MouseEventDetails mouseDetails = MouseEventDetailsBuilder
					.buildMouseEventDetails(event.getNativeEvent(),
								getWidget().getElement());
				rpc.clicked(mouseDetails);
			}
		});
		*/
	}

	@Override
	protected Widget createWidget() {
		return GWT.create(CustomComboBoxWidget.class);
	}

	@Override
	public CustomComboBoxWidget getWidget() {
		return (CustomComboBoxWidget) super.getWidget();
	}

	@Override
	public CustomComboBoxState getState() {
		return (CustomComboBoxState) super.getState();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);

		// TODO do something useful
		final String text = getState().text;
		//getWidget().setText(text);
	}

}

