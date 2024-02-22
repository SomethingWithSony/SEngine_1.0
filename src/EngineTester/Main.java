package EngineTester;

import renderEngine.DisplayManager;

public class Main {

    public static void main(String[] args){
        DisplayManager.CreateDisplay();

        while(!DisplayManager.CloseRequested()){
            // Game Logic
            // Render

            // Update Display
            DisplayManager.UpdateDisplay();
        }

        DisplayManager.CloseDisplay();


    }
}
