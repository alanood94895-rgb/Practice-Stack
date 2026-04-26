import java.util.Stack;

public class TextEditorWithUndoRedo {

    // Stack for undo Actions
    static Stack<String> undoStack = new Stack<>();

    // Stack for redo Actions
    static Stack<String> redoStack = new Stack<>();

    // Current text
    static StringBuilder text = new StringBuilder();

    public static void main(String[] args) {

        // Simulated user actions
        type("Hello");
        type(" World");
        undo();
        type(" Java");
        undo();
        redo();
        type(" Programming");
        undo();
        redo();

        display();
    }

    // TYPE method (adds text)
    public static void type(String newText) {

        // Save current state for undo
        undoStack.push(text.toString());

        // Add new text
        text.append(newText);

        // Clear redo stack (new action invalidates redo history)
        redoStack.clear();

        System.out.println("Typed: " + newText);
        display();
    }

    // UNDO method
    public static void undo() {

        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }

        // Save current state to redo stack
        redoStack.push(text.toString());

        // Restore previous state
        text = new StringBuilder(undoStack.pop());

        System.out.println("Undo performed");
        display();
    }

    // REDO method
    public static void redo() {

        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo");
            return;
        }

        // Save current state to undo stack
        undoStack.push(text.toString());

        // Restore redo state
        text = new StringBuilder(redoStack.pop());

        System.out.println("Redo performed");
        display();
    }

    // DISPLAY method
    public static void display() {

        System.out.println("Current Text: " + text);
        System.out.println("Undo Stack: " + undoStack);
        System.out.println("Redo Stack: " + redoStack);
        System.out.println("---------------------------");
    }
}