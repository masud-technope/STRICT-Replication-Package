/**
	 * Creates a new JEditTextArea.
	 * @param propertyManager the property manager that contains informations like shortcut bindings
	 * @param inputHandlerProvider the inputHandlerProvider
	 */
protected  TextArea(IPropertyManager propertyManager, InputHandlerProvider inputHandlerProvider) {
    this.inputHandlerProvider = inputHandlerProvider;
    enableEvents(AWTEvent.FOCUS_EVENT_MASK | AWTEvent.KEY_EVENT_MASK);
    //{{{ Initialize some misc. stuff
    selectionManager = new SelectionManager(this);
    chunkCache = new ChunkCache(this);
    painter = new TextAreaPainter(this);
    gutter = new Gutter(this);
    gutter.setMouseActionsProvider(new MouseActions(propertyManager, "gutter"));
    listenerList = new EventListenerList();
    caretEvent = new MutableCaretEvent();
    blink = true;
    offsetXY = new Point();
    structureMatchers = new LinkedList<StructureMatcher>();
    structureMatchers.add(new StructureMatcher.BracketMatcher());
    //}}}
    //{{{ Initialize the GUI
    setLayout(new ScrollLayout());
    add(ScrollLayout.CENTER, painter);
    add(ScrollLayout.LEFT, gutter);
    // some plugins add stuff in a "right-hand" gutter
    RequestFocusLayerUI reqFocus = new RequestFocusLayerUI();
    verticalBox = new Box(BoxLayout.X_AXIS);
    verticalBox.add(new JLayer<JComponent>(vertical = new JScrollBar(Adjustable.VERTICAL), reqFocus));
    vertical.setRequestFocusEnabled(false);
    add(ScrollLayout.RIGHT, verticalBox);
    add(ScrollLayout.BOTTOM, new JLayer<JComponent>(horizontal = new JScrollBar(Adjustable.HORIZONTAL), reqFocus));
    horizontal.setRequestFocusEnabled(false);
    horizontal.setValues(0, 0, 0, 0);
    // breakage shouldn't matter
    if (UIManager.getLookAndFeel() instanceof MetalLookAndFeel) {
        setBorder(new TextAreaBorder());
        vertical.putClientProperty("JScrollBar.isFreeStanding", Boolean.FALSE);
        horizontal.putClientProperty("JScrollBar.isFreeStanding", Boolean.FALSE);
    //horizontal.setBorder(null);
    }
    //}}}
    //{{{ Add some event listeners
    vertical.addAdjustmentListener(new AdjustHandler());
    horizontal.addAdjustmentListener(new AdjustHandler());
    addFocusListener(new FocusHandler());
    addMouseWheelListener(new MouseWheelHandler());
    //}}}
    // This doesn't seem very correct, but it fixes a problem
    // when setting the initial caret position for a buffer
    // (eg, from the recent file list)
    focusedComponent = this;
}