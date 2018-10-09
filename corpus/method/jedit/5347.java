//}}}
public List<String> getDockableSets() {
    List<String> sets = new ArrayList<String>();
    for (String set : dockableSets.keySet()) sets.add(set);
    sets.remove(ALL_DOCKABLE_SET);
    sets.remove(CORE_DOCKABLE_SET);
    Collections.sort(sets);
    sets.add(0, CORE_DOCKABLE_SET);
    sets.add(0, ALL_DOCKABLE_SET);
    return sets;
}