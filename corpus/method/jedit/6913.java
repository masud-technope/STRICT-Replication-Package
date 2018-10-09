//}}}
//{{{ clone() method
@Override
public Object clone() {
    try {
        return super.clone();
    } catch (CloneNotSupportedException e) {
        throw new InternalError("I just drank a whole " + "bottle of cough syrup and I feel " + "funny!");
    }
}