    package renderEngine;


    import org.lwjgl.opengl.*;



    import static org.lwjgl.glfw.GLFW.*;
    import static org.lwjgl.opengl.GL11.*;

    import static org.lwjgl.system.MemoryUtil.*;



    public class DisplayManager {
        private static long window;

        public static void CreateDisplay(){
            // Initialize GLFW. Most GLFW functions will not work before doing this.
            glfwInit();

            // Configure GLFW
            glfwDefaultWindowHints(); // optional, the current window hints are already the default
            glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
            glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

            // Create the window
            window = glfwCreateWindow(300, 300, "Hello World!", NULL, NULL);
            if ( window == NULL )
                throw new RuntimeException("Failed to create the GLFW window");

            // Make the OpenGL context current
            glfwMakeContextCurrent(window);
            // Enable v-sync
            glfwSwapInterval(1);

            // Make the window visible
            glfwShowWindow(window);

        }

        public static void UpdateDisplay(){
            GL.createCapabilities();

            // Set the clear color
            glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

            glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

            glfwSwapBuffers(window); // swap the color buffers

            // Poll for window events. The key callback above will only be
            // invoked during this call.
            glfwPollEvents();
        }

        public static void CloseDisplay(){
            System.out.println("Closing Window");
            glfwTerminate();
        }
        public static boolean CloseRequested(){
            return glfwWindowShouldClose(window);
        }

    }