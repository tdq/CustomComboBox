package org.vaadin.nikolai.client.customcombobox;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel.PositionCallback;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.VConsole;
import com.vaadin.client.ui.VOverlay;

@SuppressWarnings("deprecation")
class SuggestionPopup extends VOverlay implements PositionCallback {
	private static final int Z_INDEX = 30000;
	private static final String EMPTY = "";
	private static final String OPTIONLIST_ID = "VAADIN_COMBOBOX_OPTIONLIST";
	private static final String SUGGESTMENU_STYLE = "-suggestmenu";

	private final VerticalPanel panel;
	private int topPosition;

	public SuggestionPopup(final Widget owner) {
		super(true, false);
		setOwner(owner);

		panel = new VerticalPanel();
		setWidget(panel);
		
		Label label = new Label("Test");
		panel.add(label);

		getElement().getStyle().setZIndex(Z_INDEX);
	}

	public void showSuggestions() {
		getElement().setId(OPTIONLIST_ID);

		final SuggestionPopup popup = this;

		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
			@Override
			public void execute() {
				final int x = getOwner().getAbsoluteLeft();
				topPosition = getOwner().getAbsoluteTop();
				topPosition += getOwner().getOffsetHeight();

				setPopupPosition(x, topPosition);

				panel.setStyleName(getOwner().getStylePrimaryName() + SUGGESTMENU_STYLE);

				panel.setWidth(EMPTY);
				panel.getElement().getFirstChildElement().getStyle().clearWidth();

				setPopupPositionAndShow(popup);
			}
		});
	}

	@Override
	public void setPosition(int offsetWidth, int offsetHeight) {
		int top = topPosition;
		int left = getPopupLeft();

		panel.setHeight(EMPTY);
	}
}
