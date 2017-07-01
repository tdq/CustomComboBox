package org.vaadin.nikolai.client.customcombobox;

import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.TextBox;

/**
 * 
 * @author nikolaigorokhov
 *
 */
public class CustomComboBoxWidget extends Composite implements MouseDownHandler {

	public static final String CLASSNAME = "v-filterselect";
	
	private static final String INPUT_STYLE = "-input";
	private static final String BUTTON_STYLE = "-button";
	private static final String SUGGESTPOPUP_STYLE = "-suggestpopup";
	
	private final FlowPanel content = new FlowPanel();
	private final TextBox inputField = new TextBox();
	private final HTML popupOpener = new HTML("");
	private final SuggestionPopup suggestionPopup = new SuggestionPopup(this);
	
	public CustomComboBoxWidget() {
		content.add(inputField);
		content.add(popupOpener);
		
		popupOpener.addMouseDownHandler(this);
		
		initWidget(content);
		setStyleName(CLASSNAME);

	}

	protected void updateStyleNames() {
        inputField.setStyleName(getStylePrimaryName() + INPUT_STYLE);
        popupOpener.setStyleName(getStylePrimaryName() + BUTTON_STYLE);
        suggestionPopup.setStyleName(getStylePrimaryName() + SUGGESTPOPUP_STYLE);
    }
	
	@Override
    public void setStyleName(String style) {
        super.setStyleName(style);
        updateStyleNames();
    }

    @Override
    public void setStylePrimaryName(String style) {
        super.setStylePrimaryName(style);
        updateStyleNames();
    }

	@Override
	public void onMouseDown(MouseDownEvent event) {
		suggestionPopup.showSuggestions();
	}
}