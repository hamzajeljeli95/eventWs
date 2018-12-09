package MainPackage.Controller;

import MainPackage.Beans.EventComments;
import MainPackage.Service.EventCommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/comments")
public class EventCommentsController {

    @Autowired
    EventCommentsService service;

    @RequestMapping(value = "/getComments", method = RequestMethod.POST)
    public List<EventComments> getCommentsByEventId(@RequestBody Map<String,String> body)
    {
        return service.getCommentsByEventId(Integer.parseInt(body.get("idEvent")));
    }

    @RequestMapping(value = "/getUserComments", method = RequestMethod.POST)
    public EventComments getUserCommentByEventId(@RequestBody Map<String,String> body)
    {
        return service.getUserCommentByEventId(Integer.parseInt(body.get("idEvent")), body.get("idUser"));
    }
    public boolean newComment(@RequestBody Map<String,String> body)
    {
        return service.newComment(Integer.parseInt(body.get("idEvent")), body.get("idUser"),body.get("commentContent"));
    }
}
