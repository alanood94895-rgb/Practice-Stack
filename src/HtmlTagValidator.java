import java.util.Stack;

public class HtmlTagValidator {

    public static void main(String[] args) {

        String[] tests = {
                "<html><body><p>Test</p></body></html>",
                "<div><b>Bold</b></div>",
                "<div><b>Wrong</i></div>",
                "<p><i>Text</p></i>",
                "<br/>",
                "",
                "<div class='box'><p>Hi</p></div>",
                "<div><p>",
        };

        for (String html : tests) {
            System.out.println("HTML: " + html);
            boolean result = validateHtmlTags(html);
            System.out.println("Valid: " + result);
        }
    }

    public static boolean validateHtmlTags(String html) {

        Stack<String> openingTagsStack = new Stack<>();

        if (html == null || html.isEmpty()) {
            System.out.println("Empty string Valid");
            return true;
        }

        int i = 0;

        while (i < html.length()) {

            if (html.charAt(i) == '<') {

                int closeIndex = html.indexOf('>', i);

                if (closeIndex == -1) {
                    System.out.println("Error: Tag not closed properly.");
                    return false;
                }

                String tag = html.substring(i + 1, closeIndex).trim();

                // SELF CLOSING
                if (tag.endsWith("/")) {
                    System.out.println("Self closing tag: <" + tag + ">");
                }

                // Closing tag
                else if (tag.startsWith("/")) {

                    String tagName = tag.substring(1).trim();

                    if (openingTagsStack.isEmpty()) {
                        System.out.println("Error: No opening tag for </" + tagName + ">");
                        return false;
                    }

                    String top = openingTagsStack.pop();

                    if (!top.equals(tagName)) {
                        System.out.println("Error: Expected </" + top + "> but found </" + tagName + ">");
                        return false;
                    }

                    System.out.println("Matched: </" + tagName + ">");
                }

                // Opening tag
                else {
                    String tagName = tag.split(" ")[0];
                    openingTagsStack.push(tagName);
                    System.out.println("Pushed: <" + tagName + ">");
                }

                System.out.println("Stack: " + openingTagsStack);

                i = closeIndex;
            }

            i++;
        }

        if (!openingTagsStack.isEmpty()) {
            System.out.println("Error: Unclosed tags → " + openingTagsStack);
            return false;
        }

        return true;
    }
}