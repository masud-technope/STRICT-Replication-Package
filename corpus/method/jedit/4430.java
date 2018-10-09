//{{{ HistoryListActionHandler constructor
 HistoryListActionHandler(HelpHistoryModel.HistoryEntry entry) {
    super(entry.title);
    this.entry = entry;
    this.putValue(Action.ACTION_COMMAND_KEY, entry.url + ':' + entry.scrollPosition);
//}}}
}