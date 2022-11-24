package golf.servletquest.controller;

import golf.servletquest.entity.Step;
import golf.servletquest.repository.InMemoryStepRepository;
import golf.servletquest.repository.StepRepository;
import golf.servletquest.service.JsonParserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "gameServlet", value = "/gameServlet")
public class GameServlet extends HttpServlet {
    private StepRepository repository;

    @Override
    public void init() throws ServletException {
        repository = new InMemoryStepRepository(new JsonParserService().parseSteps("questStepsRU.json"));
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final HttpSession session = request.getSession();
        String name = request.getParameter("name");
        if (name != null) {
            session.setAttribute("name", name);
        }
        sendAttribute(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String nextParam = req.getParameter("next");
        String winParam = req.getParameter("win");
        if (nextParam != null) {
            int nextNumber = Integer.parseInt(nextParam);
            req.setAttribute("steps", repository.getByNextId(nextNumber));
            Step step = repository.getQuestionById(nextNumber);
            req.setAttribute("step", step);
            req.getRequestDispatcher("game-start.jsp").forward(req, resp);
        } else if (winParam != null) {
            if ("Победа!!!".equals(winParam)) {
                resp.sendRedirect("index.jsp");
            } else {
                sendAttribute(req, resp);
            }
        }
    }

    private void sendAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("step", repository.getFirstQuestion());
        request.setAttribute("steps", repository.getFirstAnswers());
        request.getRequestDispatcher("game-start.jsp").forward(request, response);
    }
}
