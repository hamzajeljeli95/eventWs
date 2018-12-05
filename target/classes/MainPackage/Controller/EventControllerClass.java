package MainPackage.Controller;

import MainPackage.Beans.Event;
import MainPackage.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/event")
public class EventControllerClass {

    @Autowired
    EventService service;

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public Event newEventMethod(@RequestBody Map<String,String> body)
    {
        return service.newEvent(body.get("organizerId"));
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public Event getEventMethod(@RequestBody Map<String,String> body)
    {
        return service.getEvent(Integer.parseInt(body.get("id")));
    }

    @RequestMapping(value = "/getListByUser", method = RequestMethod.POST)
    public List<Event> getEventsByUserMethod(@RequestBody Map<String,String> body)
    {
        return service.getEventsByUser(body.get("organizerId"));
    }
}
