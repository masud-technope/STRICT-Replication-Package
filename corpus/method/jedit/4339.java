//}}}
//{{{ updateTitle() method
public void updateTitle(String url, String title) {
    for (HistoryEntry aHistory : history) {
        if ((aHistory != null) && aHistory.url.equals(url))
            aHistory.title = title;
    }
    fireUpdate();
}