package practicehtml;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;


@WebServlet(urlPatterns = "/exchange")
public class ExchangeServlet extends HttpServlet {

    private String respTemple;

    @Override
    public void init() throws ServletException{

        try{
            URI templURI = getClass().getResource("/exchanger.html").toURI();
            byte[] bytes = Files.readAllBytes(Paths.get(templURI));
            respTemple = new String(bytes, StandardCharsets.UTF_8);
        }catch (IOException | URISyntaxException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String remoteHost = req.getRemoteHost(); //get ip

        System.out.println("GET from " + remoteHost);

        String parameter = req.getParameter("u");

        String username = Optional
                .ofNullable(parameter)
                .orElse("Anonymous");

        String responseBody = respTemple
                .replace("{username}", username)
                .replace("{host}", remoteHost);

        resp.setContentType("text/html");
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().print(responseBody);
    }

}
