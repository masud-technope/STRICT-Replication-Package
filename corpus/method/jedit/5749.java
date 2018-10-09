public int compare(Mirror m1, Mirror m2) {
    int result;
    if ((result = m1.continent.compareToIgnoreCase(m2.continent)) == 0)
        if ((result = m1.country.compareToIgnoreCase(m2.country)) == 0)
            if ((result = m1.location.compareToIgnoreCase(m2.location)) == 0)
                return m1.description.compareToIgnoreCase(m2.description);
    return result;
}