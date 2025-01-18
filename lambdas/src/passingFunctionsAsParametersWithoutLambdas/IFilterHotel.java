package passingFunctionsAsParametersWithoutLambdas;

@FunctionalInterface
public interface IFilterHotel {
    boolean doFilter(Hotel hotel);

    /**
     * this interface can in no way under any given circumstance have more than 1 method.
     *
     * If there is then:
     *      will fail for lambdas
     *      can be made to work with other cases like concrete implementing class and anonymous inner classes
     * Having the @FunctionalInterface is always advisable
     */
}
