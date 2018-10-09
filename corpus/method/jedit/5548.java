@Override
public int compare(ActionSet o1, ActionSet o2) {
    return StandardUtilities.compareStrings(o1.getLabel(), o2.getLabel(), false);
}