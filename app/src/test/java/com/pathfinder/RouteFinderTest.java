package com.pathfinder;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by Spoorthi P on 12/22/17.
 */
public class RouteFinderTest {

    @Test
    public void subject_should_return_route_with_highest_size_as_the_best_route() throws Exception {
        MatrixManager mockMatrixManager = mock(MatrixManager.class);
        RouteFinder routeFinder = new RouteFinder(mockMatrixManager);


        List<Route> leastRoute = routeFinder.findLeastRoute(Arrays.asList(new Route(new Coordinate(1, 1), 5)),
                Arrays.asList(new Route(new Coordinate(1, 1), 5),
                        new Route(new Coordinate(2, 3), 8)));

        assertEquals(2, leastRoute.size());

    }

    @Test
    public void subject_should_return_route_with_lest_value_cost_as_the_best_route_when_sizes_are_equal() throws Exception {
        MatrixManager mockMatrixManager = mock(MatrixManager.class);
        RouteFinder routeFinder = new RouteFinder(mockMatrixManager);

        List<Route> leastRoute = routeFinder.findLeastRoute(Arrays.asList(new Route(new Coordinate(1, 1), 8),
                new Route(new Coordinate(1, 1), 8)),
                Arrays.asList(new Route(new Coordinate(1, 1), 2),
                        new Route(new Coordinate(2, 3), 8)));

        assertEquals(2, leastRoute.get(0).getValue());
        assertEquals(8, leastRoute.get(1).getValue());

    }
}