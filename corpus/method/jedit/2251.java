/**
		Promote the pair of primitives to the maximum type of the two.
		e.g. [int,long]->[long,long]
	*/
static Object[] promotePrimitives(Object lhs, Object rhs) {
    lhs = promoteToInteger(lhs);
    rhs = promoteToInteger(rhs);
    if ((lhs instanceof Number) && (rhs instanceof Number)) {
        Number lnum = (Number) lhs;
        Number rnum = (Number) rhs;
        boolean b;
        if ((b = (lnum instanceof Double)) || (rnum instanceof Double)) {
            if (b)
                rhs = Double.valueOf(rnum.doubleValue());
            else
                lhs = Double.valueOf(lnum.doubleValue());
        } else if ((b = (lnum instanceof Float)) || (rnum instanceof Float)) {
            if (b)
                rhs = Float.valueOf(rnum.floatValue());
            else
                lhs = Float.valueOf(lnum.floatValue());
        } else if ((b = (lnum instanceof Long)) || (rnum instanceof Long)) {
            if (b)
                rhs = Long.valueOf(rnum.longValue());
            else
                lhs = Long.valueOf(lnum.longValue());
        }
    }
    return new Object[] { lhs, rhs };
}