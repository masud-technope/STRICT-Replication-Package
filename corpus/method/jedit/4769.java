/**
	 * Creates a new view.
	 * @param view An existing view
	 * @param buffer A buffer to display, or null
	 * @param config Encapsulates the view geometry, split configuration
	 * and if the view is a plain view
	 * @since jEdit 4.2pre1
	 */
public static View newView(View view, Buffer buffer, View.ViewConfig config) {
    // during jEdit startup, by the loading of the perspective.
    if (isStartupDone())
        PerspectiveManager.setPerspectiveDirty(true);
    try {
        if (view != null) {
            view.showWaitCursor();
            view.getEditPane().saveCaretInfo();
        }
        View newView = new View(buffer, config);
        addViewToList(newView);
        EditBus.send(new ViewUpdate(newView, ViewUpdate.CREATED));
        newView.pack();
        newView.adjust(view, config);
        newView.setVisible(true);
        if (!config.plainView) {
            int index;
            synchronized (startupDone) {
                index = startupDone.size();
                startupDone.add(false);
            }
            EventQueue.invokeLater(new DockingLayoutSetter(newView, config, index));
        }
        // show tip of the day
        if (newView == viewsFirst) {
            newView.getTextArea().requestFocus();
            // with the -nosettings switch
            if (settingsDirectory != null && getBooleanProperty("firstTime"))
                new HelpViewer("welcome.html");
            else if (jEdit.getBooleanProperty("tip.show"))
                new TipOfTheDay(newView);
            setBooleanProperty("firstTime", false);
        } else
            GenericGUIUtilities.requestFocus(newView, newView.getTextArea());
        return newView;
    } finally {
        if (view != null)
            view.hideWaitCursor();
    }
}