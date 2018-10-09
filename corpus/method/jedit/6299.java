//}}}
//{{{ timerIncrementalSearch() method
private void timerIncrementalSearch(int start, boolean reverse) {
    searchStart = start;
    searchReverse = reverse;
    timer.stop();
    timer.setRepeats(false);
    timer.setInitialDelay(150);
    timer.start();
}