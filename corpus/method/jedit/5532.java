public int compare(Button button1, Button button2) {
    return StandardUtilities.compareStrings(button1.label, button2.label, true);
}