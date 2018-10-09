//}}}
//{{{ getCompletions() method
private static String[] getCompletions(String str) {
    str = str.toLowerCase();
    String[] actions = jEdit.getActionNames();
    ArrayList<String> returnValue = new ArrayList<String>(actions.length);
    for (String act : actions) {
        if (act.toLowerCase().contains(str))
            returnValue.add(act);
    }
    return returnValue.toArray(new String[returnValue.size()]);
}