public  SwingInstall() {
    installer = new Install();
    osTasks = OperatingSystem.getOperatingSystem().getOSTasks(installer);
    appName = installer.getProperty("app.name");
    appVersion = installer.getProperty("app.version");
    setTitle(appName + " " + appVersion + " installer");
    JPanel content = new JPanel(new WizardLayout());
    setContentPane(content);
    caption = new JLabel();
    caption.setFont(new Font("SansSerif", Font.BOLD, 18));
    ActionHandler actionHandler = new ActionHandler();
    cancelButton = new JButton("Cancel");
    cancelButton.setRequestFocusEnabled(false);
    cancelButton.addActionListener(actionHandler);
    prevButton = new JButton("Previous");
    prevButton.setRequestFocusEnabled(false);
    prevButton.addActionListener(actionHandler);
    nextButton = new JButton();
    nextButton.setRequestFocusEnabled(false);
    nextButton.addActionListener(actionHandler);
    content.add(caption);
    content.add(cancelButton);
    content.add(prevButton);
    content.add(nextButton);
    String clazz = OperatingSystem.getOperatingSystem().getClass().getName();
    String completedInfo = "done-" + clazz.substring(clazz.indexOf('$') + 1) + ".html";
    pages = new Component[] { new TextPanel(installer.getProperty("app.readme")), new TextPanel(installer.getProperty("app.license")), chooseDirectory = new ChooseDirectory(), selectComponents = new SelectComponents(), progress = new SwingProgress(), new TextPanel(completedInfo) };
    for (int i = 0; i < pages.length; i++) content.add(pages[i]);
    pageChanged();
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowHandler());
    Dimension screen = getToolkit().getScreenSize();
    pack();
    setLocation((screen.width - getSize().width) / 2, (screen.height - getSize().height) / 2);
    setVisible(true);
}