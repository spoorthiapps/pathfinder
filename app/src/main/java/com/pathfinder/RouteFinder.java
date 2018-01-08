package com.pathfinder;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spoorthi P on 12/21/17.
 */

public class RouteFinder {

    static final int MAX_ROUTE_COST_LIMIT = 50;
    private MatrixManager matrixManager;

    public RouteFinder(@NonNull MatrixManager matrixManager) {
        this.matrixManager = matrixManager;
    }

    public List<Route> findBestRoute() {
        List<Route> leastRoute = null;
        for (int i = 0; i < matrixManager.getMatrix().getTotalRows(); i++) {
            Coordinate coordinate = new Coordinate(1, i + 1);
            List<Route> currentRoute = findLeastRouteForCoordinate(coordinate, new ArrayList<Route>());
            if (shouldUpdateLeastRoute(leastRoute, currentRoute)) {
                leastRoute = currentRoute;
            }
        }
        return leastRoute;
    }

    private boolean shouldUpdateLeastRoute(List<Route> bestRoute, List<Route> currentRoute) {
        return bestRoute == null || costOfAllRoutes(currentRoute) < costOfAllRoutes(bestRoute);
    }

    private List<Route> findLeastRouteForCoordinate(Coordinate coordinate, List<Route> routesList) {
        if (coordinate != null) {
            List<Route> currentRoute = new ArrayList<>(routesList);
            int costOfCoordinate = matrixManager.getValueOfACoordinate(coordinate);
            int totalCosts = costOfCoordinate + costOfAllRoutes(currentRoute);

            if (!shouldReturnRoute(coordinate, totalCosts)) {
                Route newRoute = new Route(coordinate, costOfCoordinate);
                currentRoute.add(newRoute);

                Coordinate adjacentRowNextColumn = matrixManager.findSameRowNextColumn(coordinate);
                Coordinate rowAboveNextColumn = matrixManager.findRowAboveNextColumn(coordinate);
                Coordinate rowBelowNextColumn = matrixManager.findRowBelowNextColumn(coordinate);

                List<Route> possibleRoutesAdjacentRow = extractAllPossibleRoutesForCoordinate(adjacentRowNextColumn, currentRoute);
                List<Route> possibleRoutesAboveRow = extractAllPossibleRoutesForCoordinate(rowAboveNextColumn, currentRoute);
                List<Route> possibleRoutesBelowRow = extractAllPossibleRoutesForCoordinate(rowBelowNextColumn, currentRoute);

                return findLeastRouteInThreeRoutes(possibleRoutesAdjacentRow, possibleRoutesAboveRow, possibleRoutesBelowRow);
            }
            return currentRoute;
        }
        return routesList;
    }

    private List<Route> extractAllPossibleRoutesForCoordinate(Coordinate coordinate, List<Route> route) {
        return findLeastRouteForCoordinate(coordinate, route);
    }


    private boolean shouldReturnRoute(Coordinate coordinate, int totalCosts) {
        return totalCosts > MAX_ROUTE_COST_LIMIT ||
                coordinate.getXCoordinate() > matrixManager.getMatrix().getTotalColumns();
    }

    public List<Route> findLeastRoute(List<Route> firstRoute, List<Route> secondRoute) {
        if (firstRoute.size() != secondRoute.size()) {
            return firstRoute.size() > secondRoute.size() ? firstRoute : secondRoute;
        }

        return costOfAllRoutes(firstRoute) < costOfAllRoutes(secondRoute) ? firstRoute : secondRoute;
    }

    private List<Route> findLeastRouteInThreeRoutes(List<Route> firstRoute, List<Route> secondRoute, List<Route> thirdRoute) {
        List<Route> smallestRouteInFirstAndSecond = findLeastRoute(firstRoute, secondRoute);
        return findLeastRoute(smallestRouteInFirstAndSecond, thirdRoute);
    }

    private int costOfAllRoutes(List<Route> routeList) {
        int sumOfAllRoutes = 0;
        for (Route route : routeList) {
            sumOfAllRoutes += route.getValue();
        }
        return sumOfAllRoutes;
    }

}
