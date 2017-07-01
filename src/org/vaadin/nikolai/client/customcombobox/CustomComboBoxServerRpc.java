package org.vaadin.nikolai.client.customcombobox;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.communication.ServerRpc;

public interface CustomComboBoxServerRpc extends ServerRpc {

	// TODO example API
	public void clicked(MouseEventDetails mouseDetails);

}
