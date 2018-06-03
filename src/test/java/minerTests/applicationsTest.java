package minerTests;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;

import miner.applications;
import org.junit.After;
import org.junit.Test;

public class applicationsTest {
    Thread thread;
    @Test
    public void testA() throws InterruptedException {
        thread= new Thread(() -> {
            new JFXPanel();
            Platform.runLater(() -> {
                try {
                    new applications().start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
        thread.start();
        Thread.sleep(10000);
    }
    @After
    public void close(){

        try {
            thread.interrupt();
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread=null;
    }

}