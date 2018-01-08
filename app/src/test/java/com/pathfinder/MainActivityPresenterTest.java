package com.pathfinder;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Spoorthi P on 12/21/17.
 */
public class MainActivityPresenterTest {

    @Test
    public void subject_should_return_least_path_example_1() throws Exception {
        MainActivityPresenter.ViewInterface mockInterface = mock(MainActivityPresenter.ViewInterface.class);
        MainActivityPresenter subject = new MainActivityPresenter();

        subject.setView(mockInterface);
        subject.onFindButtonClicked("1,2,3,4"+
                "\n5,6,7,8");
        verify(mockInterface).showResult("1,1,1,1");
    }

    @Test
    public void subject_should_return_least_path_example_2() {
        MainActivityPresenter.ViewInterface mockInterface = mock(MainActivityPresenter.ViewInterface.class);
        MainActivityPresenter subject = new MainActivityPresenter();

        subject.setView(mockInterface);
        subject.onFindButtonClicked("1,2," +
                "\n3,4");
        verify(mockInterface).showResult("1,1");
    }

    @Test
    public void subject_should_return_least_path_exmaple_3() {
        MainActivityPresenter.ViewInterface mockInterface = mock(MainActivityPresenter.ViewInterface.class);
        MainActivityPresenter subject = new MainActivityPresenter();

        subject.setView(mockInterface);
        subject.onFindButtonClicked("1,8," +
                "\n3,4");
        verify(mockInterface).showResult("1,2");
    }

    @Test
    public void subject_should_return_least_path_example_4() {
        MainActivityPresenter.ViewInterface mockInterface = mock(MainActivityPresenter.ViewInterface.class);
        MainActivityPresenter subject = new MainActivityPresenter();

        subject.setView(mockInterface);
        subject.onFindButtonClicked("3,4,1,2,8,6" +
                "\n6,1,8,2,7,4"+
                "\n5,9,3,9,9,5"+
                "\n8,4,1,3,2,6"+
                "\n3,7,2,8,6,4");

        verify(mockInterface).showResult("1,2,3,4,4,5");
    }
}