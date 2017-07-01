package org.vaadin.nikolai;

import org.vaadin.nikolai.client.customcombobox.CustomComboBoxClientRpc;
import org.vaadin.nikolai.client.customcombobox.CustomComboBoxServerRpc;
import com.vaadin.shared.MouseEventDetails;
import org.vaadin.nikolai.client.customcombobox.CustomComboBoxState;

public class CustomComboBox extends com.vaadin.ui.AbstractComponent {

	private CustomComboBoxServerRpc rpc = new CustomComboBoxServerRpc() {
		private int clickCount = 0;

		public void clicked(MouseEventDetails mouseDetails) {
			// nag every 5:th click using RPC
			if (++clickCount % 5 == 0) {
				getRpcProxy(CustomComboBoxClientRpc.class).alert(
						"Ok, that's enough!");
			}
			// update shared state
			getState().text = "You have clicked " + clickCount + " times";
		}
	};  

	public CustomComboBox() {
		registerRpc(rpc);
	}

	@Override
	public CustomComboBoxState getState() {
		return (CustomComboBoxState) super.getState();
	}
}
