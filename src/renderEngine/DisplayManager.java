package renderEngine;

import org.lwjgl.opengl.*;

import static org.lwjgl.glfw.GLFW.*;

import static org.lwjgl.system.MemoryUtil.*;


public class DisplayManager {
    private static long window;


    public static void CreateDisplay() {
        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if (!glfwInit()) {
            // Handle initialization failure
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        // Configure GLFW
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GL11.GL_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GL11.GL_FALSE);

        glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
        glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);

        glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
        glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GL11.GL_TRUE);

        // Create the window
        window = glfwCreateWindow(1280, 720, "LWJGL + OpenGL", NULL, NULL);


        if (window == NULL)
            throw new RuntimeException("Failed to create the GLFW window");

        // Make the OpenGL context current
        glfwMakeContextCurrent(window);

        // Enable v-sync
        glfwSwapInterval(1);

        // Make the window visible
        glfwShowWindow(window);

        GL.createCapabilities();

    }

    public static void UpdateDisplay() {
        glfwSwapBuffers(window); // swap the color buffers
        glfwPollEvents();
    }

    public static void CloseDisplay() {
        System.out.println("Closing Window");
        glfwTerminate();
    }

    public static boolean CloseRequested() {
        return glfwWindowShouldClose(window);
    }

}