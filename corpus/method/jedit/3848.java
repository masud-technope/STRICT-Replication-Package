//}}}
//{{{ sortDockables() method
void sortDockables() {
    buttonPanel.removeAll();
    buttonPanel.add(closeBox);
    buttonPanel.add(menuBtn);
    Collections.sort(buttons, new DockableWindowCompare());
    for (AbstractButton button : buttons) buttonPanel.add(button);
}