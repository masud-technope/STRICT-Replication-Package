/**
	 * Creates a new StandaloneTextArea. A reference to the propertyManager is saved and used to read the properties
	 * when {@link StandaloneTextArea#propertiesChanged()} is called.
	 *
	 * @param propertyManager the property manager that contains both shortcut bindings and UI information
	 */
public  StandaloneTextArea(IPropertyManager propertyManager) {
    super(propertyManager, null);
    this.propertyManager = propertyManager;
    initInputHandler();
    setMouseHandler(new TextAreaMouseHandler(this));
    // todo : make TextareaTransferHandler standalone
    //		textArea.setTransferHandler(new TextAreaTransferHandler());
    JEditActionSet<JEditBeanShellAction> actionSet = new StandaloneActionSet(propertyManager, this, TextArea.class.getResource("textarea.actions.xml"));
    addActionSet(actionSet);
    actionSet.load();
    actionSet.initKeyBindings();
    //{{{ init Style property manager
    if (SyntaxUtilities.propertyManager == null) {
        SyntaxUtilities.propertyManager = propertyManager;
    }
    //}}}
    initTextArea();
    DefaultFoldHandlerProvider foldHandlerProvider = new DefaultFoldHandlerProvider();
    FoldHandler.foldHandlerProvider = foldHandlerProvider;
    foldHandlerProvider.addFoldHandler(new ExplicitFoldHandler());
    foldHandlerProvider.addFoldHandler(new IndentFoldHandler());
    foldHandlerProvider.addFoldHandler(new DummyFoldHandler());
    JEditBuffer buffer = new JEditBuffer();
    TokenMarker tokenMarker = new TokenMarker();
    tokenMarker.addRuleSet(new ParserRuleSet("text", "MAIN"));
    buffer.setTokenMarker(tokenMarker);
    setBuffer(buffer);
    String property = propertyManager.getProperty("buffer.undoCount");
    int undoCount = 100;
    if (property != null)
        try {
            undoCount = Integer.parseInt(property);
        } catch (NumberFormatException e) {
        }
    this.buffer.setUndoLimit(undoCount);
    Mode mode = new Mode("text");
    mode.setTokenMarker(tokenMarker);
    ModeProvider.instance.addMode(mode);
    KillRing.setInstance(new KillRing());
    KillRing.getInstance().propertiesChanged(100);
}