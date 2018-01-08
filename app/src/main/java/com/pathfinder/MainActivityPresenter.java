package com.pathfinder;


import android.support.annotation.NonNull;

import java.util.List;

/**
 * Created by Spoorthi P on 12/21/17.
 */

public class MainActivityPresenter {

    private ViewInterface view;

    public void setView(ViewInterface view) {
        this.view = view;
    }

    public void onFindButtonClicked(String input) {
        TextParser parser = new TextParser();
        List<List<Integer>> matrixList = parser.getListOfIntegers(input);
        Matrix matrix = new Matrix(matrixList);
        MatrixManager manager = new MatrixManager(matrix);
        RouteFinder finder = new RouteFinder(manager);
        List<Route> bestRoute = finder.findBestRoute();
        boolean isValidPath = bestRoute.size() > 0 && bestRoute.size() == matrix.getTotalColumns();
        view.setYesOrNo(isValidPath ? "YES" : "NO");

        if (isValidPath) {
            StringBuffer resultBuffer = extractRouteFromTheListOfRoutes(bestRoute);
            view.showResult(resultBuffer.toString());
            int totalCost = 0;
            for (Route route : bestRoute) {
                totalCost += route.getValue();
            }
            view.setPathCost(Integer.toString(totalCost));
        }
    }

    @NonNull
    private StringBuffer extractRouteFromTheListOfRoutes(List<Route> bestRoute) {
        StringBuffer resultBuffer = new StringBuffer();
        for (int i = 0; i < bestRoute.size(); i++) {
            resultBuffer.append(bestRoute.get(i).getCoordinates().getYCoordinate());
            if (i != bestRoute.size() - 1) {
                resultBuffer.append(",");
            }
        }
        return resultBuffer;
    }

    public interface ViewInterface {
        void showResult(String result);
        void setYesOrNo(String result);
        void setPathCost(String result);
    }

}
