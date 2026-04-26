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

    }
