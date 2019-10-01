/*******************************************************************************
 * Copyright 2016 Jalian Systems Pvt. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package ehu.isad;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.Chart;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public abstract class JavaFXElement {

  public static class ApplicationHelper extends Application {

    public static void startApplication() {
      new Thread(new Runnable() {
        @Override
        public void run() {
          Application.launch(ApplicationHelper.class);
        }
      }).start();
    }

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
      this.primaryStage = primaryStage;
      JavaFXElement.applicationHelper = this;
    }

    public void startGUI(Chart node) {
      Platform.runLater(new Runnable() {
        @Override
        public void run() {
          // primaryStage.hide();
          primaryStage.setScene(new Scene(node));
          // primaryStage.sizeToScene();
          primaryStage.setWidth(400);
          primaryStage.setHeight(400);
          primaryStage.show();
        }
      });

    }

    public Stage getPrimaryStage() {
      return primaryStage;
    }
  }

  private static ApplicationHelper applicationHelper;

  public JavaFXElement() {
  }

  public void startGUI() throws Throwable {
    if (applicationHelper == null) {
      ApplicationHelper.startApplication();
    }

    applicationHelper.startGUI(getMainChart());

  }

  protected abstract Chart getMainChart();

  public Stage getPrimaryStage() {
    return applicationHelper.getPrimaryStage();
  }

}