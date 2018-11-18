import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;


@WebServlet("/brainfuck")
public class BFServlet extends HttpServlet {
    public BFRepository bfRepository;
    private ObjectMapper objectMapper;
    private BF bf;

    @Override
    public void init() {
        objectMapper = new ObjectMapper();
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String bfk = req.getParameter("input");
        String out;
        try {
            out = bfRepository.interpret(bfk);
        } catch (Exception e) {
            resp.sendError(
                    HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
                    e.getMessage()
            );
            return;
        }

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setContentType("application/json;charset=utf8");
        objectMapper.writeValue(resp.getOutputStream(), out);

    }
}
