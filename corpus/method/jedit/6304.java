//{{{ SearchBar constructor
public  SearchBar(final View view, boolean temp) {
    this.view = view;
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    setFloatable(false);
    add(Box.createHorizontalStrut(2));
    JLabel label = new JLabel(jEdit.getProperty("view.search.find"));
    add(label);
    add(Box.createHorizontalStrut(12));
    add(find = new HistoryTextField("find"));
    find.setSelectAllOnFocus(true);
    SyntaxStyle style = SyntaxUtilities.parseStyle(jEdit.getProperty("view.style.invalid"), "Dialog", 12, true);
    errorBackground = style.getBackgroundColor();
    errorForeground = style.getForegroundColor();
    defaultBackground = find.getBackground();
    defaultForeground = find.getForeground();
    Dimension max = find.getPreferredSize();
    max.width = Integer.MAX_VALUE;
    find.setMaximumSize(max);
    ActionHandler actionHandler = new ActionHandler();
    find.addKeyListener(new KeyHandler());
    find.addActionListener(actionHandler);
    find.getDocument().addDocumentListener(new DocumentHandler());
    Insets margin = new Insets(1, 1, 1, 1);
    addSeparator(new Dimension(12, 12));
    add(ignoreCase = new JCheckBox(jEdit.getProperty("search.case")));
    ignoreCase.addActionListener(actionHandler);
    ignoreCase.setMargin(margin);
    ignoreCase.setOpaque(false);
    ignoreCase.setRequestFocusEnabled(false);
    add(Box.createHorizontalStrut(2));
    add(regexp = new JCheckBox(jEdit.getProperty("search.regexp")));
    regexp.addActionListener(actionHandler);
    regexp.setMargin(margin);
    regexp.setOpaque(false);
    regexp.setRequestFocusEnabled(false);
    add(Box.createHorizontalStrut(2));
    add(hyperSearch = new JCheckBox(jEdit.getProperty("search.hypersearch")));
    hyperSearch.addActionListener(actionHandler);
    hyperSearch.setMargin(margin);
    hyperSearch.setOpaque(false);
    hyperSearch.setRequestFocusEnabled(false);
    add(wholeWord = new JCheckBox(jEdit.getProperty("search.word.bar")));
    wholeWord.addActionListener(actionHandler);
    wholeWord.setMargin(margin);
    wholeWord.setOpaque(false);
    wholeWord.setRequestFocusEnabled(false);
    update();
    //{{{ Create the timer used by incremental search
    timer = new Timer(0, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent evt) {
            if (!incrementalSearch(searchStart, searchReverse)) {
                if (!incrementalSearch((searchReverse ? view.getBuffer().getLength() : 0), searchReverse)) {
                    // not found at all.
                    view.getStatus().setMessageAndClear(jEdit.getProperty("view.status.search-not-found"));
                }
            }
        }
    });
    // if 'temp' is true, hide search bar after user is done with it
    this.isRemovable = temp;
    setCloseButtonVisibility();
}