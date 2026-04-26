public class HtmlTagValidator {
    public static void main(String[] args) {

        // 8 test HTML/XML strings
        String[] tests = {
                "<html><body><p>Hello</p></body></html>",
                "<div><b>Bold</b></div>",
                "<div><b>Wrong</i></div>",
                "<html><head></head><body><h1>Title</h1></body></html>",
                "<p><i>Text</p></i>",
                "<br/>",
                "",
                "<div class='box'><p>Test</p></div>"
        };
        for (String html : tests) {
            System.out.println("HTML: " + html);

            boolean result = validateHtmlTags(html);

            System.out.println("Valid: " + result);
            System.out.println("------------------------------");
        }
    }

    // METHOD: Validate HTML tags using Stack
    public static boolean validateHtmlTags(String html) {

        Stack<String> stack = new Stack<>();

        if (html == null || html.trim().isEmpty()) {
            System.out.println("Empty HTML string");
            return true;
        }

        int i = 0;

        while (i < html.length()) {

            if (html.charAt(i) == '<') {

                int j = i + 1;

                // find closing '>'
                while (j < html.length() && html.charAt(j) != '>') {
                    j++;
                }

                if (j == html.length()) {
                    System.out.println("Error: Missing '>'");
                    return false;
                }

                String tag = html.substring(i + 1, j);

                System.out.println("Found tag: <" + tag + ">");

                // SELF-CLOSING TAG
                if (tag.endsWith("/")) {
                    System.out.println("Self-closing tag ignored");
                }

                // CLOSING TAG
                else if (tag.startsWith("/")) {

                    String tagName = tag.substring(1);

                    if (stack.isEmpty()) {
                        System.out.println("Error: No opening tag for </" + tagName + ">");
                        return false;
                    }

                    String top = stack.pop();

                    System.out.println("Popped: " + top);

                    if (!top.equals(tagName)) {
                        System.out.println("Error: Mismatch <" + top + "> and </" + tagName + ">");
                        return false;
                    }
                }

                // OPENING TAG (may contain attributes)
                else {
                    String tagName = tag.split(" ")[0]; // remove attributes
                    stack.push(tagName);
                    System.out.println("Pushed: " + tagName);
                }

                System.out.println("Stack: " + stack);

                i = j;
            }

            i++;
        }

        // Final check
        if (stack.isEmpty()) {
            System.out.println("All tags matched correctly");
            return true;
        } else {
            System.out.println("Error: Unclosed tags remain: " + stack);
            return false;
        }
    }
}
    }
