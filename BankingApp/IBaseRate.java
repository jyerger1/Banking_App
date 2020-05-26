
public interface IBaseRate {
    // interface because info will be fetched from somewhere else

    // write a method that returns a base rate
    default double getBaseRate() {
        return 2.5;
    }

}