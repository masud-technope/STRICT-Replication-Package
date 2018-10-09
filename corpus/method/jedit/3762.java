 LogSettings() {
    super(jEdit.getActiveView(), jEdit.getProperty("log-viewer.dialog.title"));
    AbstractOptionPane pane = new AbstractOptionPane(jEdit.getProperty("log-viewer.settings.label")) {

        @Override
        protected void _init() {
            setBorder(BorderFactory.createEmptyBorder(11, 11, 12, 12));
            maxLines = new JSpinner(new SpinnerNumberModel(jEdit.getIntegerProperty("log-viewer.maxlines", 500), 500, Integer.MAX_VALUE, 1));
            addComponent(jEdit.getProperty("log-viewer.maxlines.label", "Max lines"), maxLines, GridBagConstraints.REMAINDER);
            addComponent(Box.createVerticalStrut(11));
            debug = new JCheckBox(jEdit.getProperty("log-viewer.message.debug.label", "Debug"), jEdit.getBooleanProperty("log-viewer.message.debug", true));
            message = new JCheckBox(jEdit.getProperty("log-viewer.message.message.label", "Message"), jEdit.getBooleanProperty("log-viewer.message.message", true));
            notice = new JCheckBox(jEdit.getProperty("log-viewer.message.notice.label", "Notice"), jEdit.getBooleanProperty("log-viewer.message.notice", true));
            warning = new JCheckBox(jEdit.getProperty("log-viewer.message.warning.label", "Warning"), jEdit.getBooleanProperty("log-viewer.message.warning", true));
            error = new JCheckBox(jEdit.getProperty("log-viewer.message.error.label", "Error"), jEdit.getBooleanProperty("log-viewer.message.error", true));
            addComponent(new JLabel(jEdit.getProperty("log-viewer.message.label", "Message Display:")));
            addComponent(debug, debugColor = new ColorWellButton(jEdit.getColorProperty("log-viewer.message.debug.color", Color.BLUE)), GridBagConstraints.REMAINDER);
            addComponent(message, messageColor = new ColorWellButton(jEdit.getColorProperty("log-viewer.message.message.color", Color.GREEN)), GridBagConstraints.REMAINDER);
            addComponent(notice, noticeColor = new ColorWellButton(jEdit.getColorProperty("log-viewer.message.notice.color", Color.GREEN)), GridBagConstraints.REMAINDER);
            addComponent(warning, warningColor = new ColorWellButton(jEdit.getColorProperty("log-viewer.message.warning.color", Color.ORANGE)), GridBagConstraints.REMAINDER);
            addComponent(error, errorColor = new ColorWellButton(jEdit.getColorProperty("log-viewer.message.error.color", Color.RED)), GridBagConstraints.REMAINDER);
            addComponent(Box.createVerticalStrut(11));
            beep = new JCheckBox(jEdit.getProperty("debug.beepOnOutput.label"), jEdit.getBooleanProperty("debug.beepOnOutput", false));
            addComponent(beep);
            addComponent(Box.createVerticalStrut(11));
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JButton okButton = new JButton(jEdit.getProperty("common.ok"));
            okButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    save();
                    LogSettings.this.setVisible(false);
                    LogSettings.this.dispose();
                }
            });
            JButton cancelButton = new JButton(jEdit.getProperty("common.cancel"));
            cancelButton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent ae) {
                    LogSettings.this.setVisible(false);
                    LogSettings.this.dispose();
                }
            });
            buttonPanel.add(okButton);
            buttonPanel.add(cancelButton);
            addComponent(buttonPanel, GridBagConstraints.HORIZONTAL);
        }

        @Override
        protected void _save() {
            jEdit.setIntegerProperty("log-viewer.maxlines", ((SpinnerNumberModel) maxLines.getModel()).getNumber().intValue());
            Log.setMaxLines(jEdit.getIntegerProperty("log-viewer.maxlines", 500));
            ListModel<String> model = Log.getLogListModel();
            listModel = new MyFilteredListModel(model);
            list.setModel(listModel);
            listModel.setList(list);
            showDebug = debug.isSelected();
            jEdit.setBooleanProperty("log-viewer.message.debug", showDebug);
            showMessage = message.isSelected();
            jEdit.setBooleanProperty("log-viewer.message.message", showMessage);
            showNotice = notice.isSelected();
            jEdit.setBooleanProperty("log-viewer.message.notice", showNotice);
            showWarning = warning.isSelected();
            jEdit.setBooleanProperty("log-viewer.message.warning", showWarning);
            showError = error.isSelected();
            jEdit.setBooleanProperty("log-viewer.message.error", showError);
            jEdit.setColorProperty("log-viewer.message.debug.color", debugColor.getSelectedColor());
            jEdit.setColorProperty("log-viewer.message.message.color", messageColor.getSelectedColor());
            jEdit.setColorProperty("log-viewer.message.notice.color", noticeColor.getSelectedColor());
            jEdit.setColorProperty("log-viewer.message.warning.color", warningColor.getSelectedColor());
            jEdit.setColorProperty("log-viewer.message.error.color", errorColor.getSelectedColor());
            jEdit.setBooleanProperty("debug.beepOnOutput", beep.isSelected());
            // it would be most clean to call jEdit.propertiesChanged() now
            // which is needed since global debug.beepOnOutput flag is attached to this pane;
            // but to avoid extra log entries, we workaround it by direct Log access
            Log.setBeepOnOutput(beep.isSelected());
        // jEdit.propertiesChanged();
        }
    };
    setContentPane(pane);
    pane.init();
    pack();
    setLocationRelativeTo(LogViewer.this);
    setVisible(true);
}