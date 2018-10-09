void addOccurrence(int file, boolean title) {
    for (int i = 0; i < occurCount; i++) {
        if (occurrences[i].file == file) {
            occurrences[i].count += (title ? TITLE_OCCUR : 1);
            return;
        }
    }
    if (occurCount >= occurrences.length) {
        Occurrence[] newOccur = new Occurrence[occurrences.length * 2];
        System.arraycopy(occurrences, 0, newOccur, 0, occurCount);
        occurrences = newOccur;
    }
    occurrences[occurCount++] = new Occurrence(file, title);
}