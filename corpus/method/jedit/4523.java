//}}}
//{{{ userInput() method
protected void userInput(char ch) {
    lastActionCount = 0;
    if (repeatCount == 1)
        textArea.userInput(ch);
    repeatCount = 1;
}