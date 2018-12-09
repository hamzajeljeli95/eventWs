package MainPackage.Controller;

import MainPackage.Beans.EventParticipants;
import MainPackage.Service.EventParticipantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/eventParticipants")
public class EventParticipantsController {

    @Autowired
    EventParticipantsService service;

    @RequestMapping(value = "/getParticipants", method = RequestMethod.POST)
    public List<EventParticipants> getParticipantsByEvent(@RequestBody Map<String,String> body){
        return service.getParticipantsByEvent(Integer.parseInt(body.get("eventId")));
    }

    @RequestMapping(value = "/getEventsByParticipant", method = RequestMethod.POST)
    public List<EventParticipants> getEventsByParticipant(@RequestBody Map<String,String> body) {
        return service.getEventsByParticipant(body.get("participantId"));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean participateToEvent(@RequestBody Map<String,String> body) {
        return service.participateToEvent(Integer.parseInt(body.get("eventId")),body.get("participantId"));
    }

}
