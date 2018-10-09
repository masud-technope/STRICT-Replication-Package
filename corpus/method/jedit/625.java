//{{{ ActionListHandler constructor
 ActionListHandler(String path, JEditActionSet actionSet) {
    this.path = path;
    this.actionSet = actionSet;
    stateStack = new Stack<String>();
    code = new StringBuilder();
    isSelected = new StringBuilder();
}