//{{{ StatusBar constructor
public  StatusBar(View view) {
    super(new BorderLayout());
    setName("StatusBar");
    setBorder(new CompoundBorder(new EmptyBorder(4, 0, 0, (OperatingSystem.isMacOS() ? 18 : 0)), UIManager.getBorder("TextField.border")));
    this.view = view;
    panel = new JPanel(new BorderLayout());
    box = new Box(BoxLayout.X_AXIS);
    panel.add(BorderLayout.EAST, box);
    add(BorderLayout.CENTER, panel);
    MouseHandler mouseHandler = new MouseHandler();
    caretStatus = new ToolTipLabel();
    caretStatus.setName("caretStatus");
    caretStatus.setToolTipText(jEdit.getProperty("view.status.caret-tooltip"));
    caretStatus.addMouseListener(mouseHandler);
    message = new JLabel(" ");
    setMessageComponent(message);
    modeWidget = _getWidget("mode");
    foldWidget = _getWidget("fold");
    encodingWidget = _getWidget("encoding");
    wrapWidget = _getWidget("wrap");
    indentWidget = _getWidget("indent");
    multiSelectWidget = _getWidget("multiSelect");
    rectSelectWidget = _getWidget("rectSelect");
    overwriteWidget = _getWidget("overwrite");
    lineSepWidget = _getWidget("lineSep");
    lockedWidget = _getWidget("locked");
    taskHandler = new TaskHandler();
}