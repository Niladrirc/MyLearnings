package passingFunctionsAsParametersWithoutLambdas;

@FunctionalInterface
public interface IFilterHotel {
    boolean doFilter(Hotel hotel);
}
