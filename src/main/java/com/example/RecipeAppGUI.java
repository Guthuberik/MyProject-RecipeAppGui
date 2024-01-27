package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class RecipeAppGUI extends Application {

    private Stage primaryStage;
    private TextField portionsTextField;
    private Text resultText;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        primaryStage.setTitle("Recipe App");

        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        Button olivierButton = new Button("Оливье");
        olivierButton.setOnAction(e -> displayResult("Оливье"));

        Button greekSaladButton = new Button("Греческий салат");
        greekSaladButton.setOnAction(e -> displayResult("Греческий салат"));
        root.getChildren().addAll(greekSaladButton);

        Button BorchButton = new Button("Борщ");
        BorchButton.setOnAction(e -> displayResult("Борщ"));
        root.getChildren().addAll(BorchButton);

        Button KraboviyButton = new Button("Крабовый салат");
        KraboviyButton.setOnAction(e -> displayResult("Крабовый салат"));
        root.getChildren().addAll(KraboviyButton);

        Button SeledkaPodShuboiButton = new Button("Селедка под шубой");
        SeledkaPodShuboiButton.setOnAction(e -> displayResult("Селедка под шубой"));
        root.getChildren().addAll(SeledkaPodShuboiButton);

        Button BurgerButton = new Button("Бургер");
        BurgerButton.setOnAction(e -> displayResult("Бургер"));
        root.getChildren().addAll(BurgerButton);

        Button KartoshkaButton = new Button("Мятая картошка");
        KartoshkaButton.setOnAction(e -> displayResult("Мятая картошка"));
        root.getChildren().addAll(KartoshkaButton);

        Button BlinButton = new Button("Блин");
        BlinButton.setOnAction(e -> displayResult("Блин"));
        root.getChildren().addAll(BlinButton);

        Button TestoButton = new Button("Тесто");
        TestoButton.setOnAction(e -> displayResult("Тесто"));
        root.getChildren().addAll(TestoButton);

        portionsTextField = new TextField();
        portionsTextField.setPromptText("Введите количество порций");

        Button confirmButton = new Button("Подтвердить");
        confirmButton.setOnAction(e -> displayResult("Оливье"));

        resultText = new Text();

        root.getChildren().addAll(olivierButton, portionsTextField, confirmButton, resultText);

        Scene scene = new Scene(root, 600, 700);
        primaryStage.setScene(scene);
        primaryStage.show();

  }

    private void showPortionsInput(String recipe) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Выбор порций");
        alert.setHeaderText(null);
        alert.setContentText("Введите количество порций для " + recipe);

        TextField inputField = new TextField();
        inputField.setPromptText("Количество порций");

        alert.getDialogPane().setContent(inputField);

        alert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == javafx.scene.control.ButtonType.OK) {
                portionsTextField.setText(inputField.getText());
                displayResult(recipe);  // Автоматически выводим результат после ввода порций
            }
        });
    }

    private void displayResult(String recipe) {
        String portions = portionsTextField.getText();
        if (!portions.isEmpty()) {
            int portionsValue = Integer.parseInt(portions);
            StringBuilder result = new StringBuilder();
            result.append("Рецепт: ").append(recipe).append("\n");
            result.append("Количество порций: ").append(portionsValue).append("\n");
            result.append("Ингредиенты:\n");

            Map<String, Double> ingredients = getIngredientsForRecipe(recipe);

            for (Map.Entry<String, Double> entry : ingredients.entrySet()) {
                String ingredient = entry.getKey();
                double amount = entry.getValue() * portionsValue;
                result.append("- ").append(ingredient).append(": ").append(amount).append(" г\n");
            }

            resultText.setText(result.toString());
        } else {
            resultText.setText("Введите количество порций.");
        }
    }

    private Map<String, Double> getIngredientsForRecipe(String recipe) {
        // Пример: Ингредиенты для Оливье
        Map<String, Double> ingredients = new HashMap<>();
        if ("Оливье".equals(recipe)) {
            ingredients.put("Картошка", 200.0);
            ingredients.put("Морковь", 100.0);
            ingredients.put("Горошек", 150.0);
            ingredients.put("Майонез", 50.0);
            ingredients.put("Колбаса", 150.0);
            ingredients.put("Яйца", 3.0);
        } else if ("Греческий салат".equals(recipe)) {
            ingredients.put("Помидоры", 250.0);
            ingredients.put("Огурцы", 150.0);
            ingredients.put("Сыр", 100.0);
            ingredients.put("Маслины", 50.0);
            ingredients.put("Масло", 30.0);
            ingredients.put("Орегано", 5.0);
        } else if ("Борщ".equals(recipe)) {
            ingredients.put("Картошка", 250.0);
            ingredients.put("Вода", 150.0);
            ingredients.put("Мясо", 100.0);
            ingredients.put("Свекла", 250.0);
            ingredients.put("Капуста", 150.0);
            ingredients.put("Соль", 100.0);
        }else if ("Крабовый салат".equals(recipe)) {
            ingredients.put("Крабовые палочки", 250.0);
            ingredients.put("Майонез", 150.0);
            ingredients.put("соль", 100.0);
        }else if ("Селедка под шубой".equals(recipe)) {
            ingredients.put("Селедка", 250.0);
            ingredients.put("Майонез", 150.0);
            ingredients.put("соль", 100.0);
        }else if ("Мятая картошка".equals(recipe)) {
            ingredients.put("Картошка", 250.0);
            ingredients.put("перец", 150.0);
            ingredients.put("соль", 100.0);
        }else if ("Бургер".equals(recipe)) {
            ingredients.put("Кусок мяса", 100.0);
            ingredients.put("перец", 150.0);
            ingredients.put("соль", 100.0);
            ingredients.put("булочка", 250.0);
            ingredients.put("кетчуп", 100.0);
            ingredients.put("Помидор", 300.0);
            ingredients.put("Огурец", 50.0);
            ingredients.put("Горчица", 20.0);
            ingredients.put("Капуста", 100.0);
        } else if ("Блин".equals(recipe)) {
            ingredients.put("Тесто", 500.0);
            ingredients.put("Сахар", 100.0);
            ingredients.put("Масло", 25.0);
        }else if ("Тесто".equals(recipe)) {
            ingredients.put("Мука", 250.0);
            ingredients.put("Соль", 150.0);
            ingredients.put("Дрожжи", 100.0);
            ingredients.put("Масло", 50.0);
        }
        return ingredients;
    }
}
