package MainPackage.Controller;

import MainPackage.Beans.EventAdditionalInfos;
import MainPackage.Service.EventAdditionalInfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/EAI")
public class EventAdditionalInfosController {

    @Autowired
    EventAdditionalInfosService service;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public List<EventAdditionalInfos> getEventAdditionalInfos(@RequestBody Map<String,String> body)
    {
        return service.getEventAdditionalInfos(Integer.parseInt(body.get("eventId")));
    }

    @RequestMapping(value = "/getSpecific", method = RequestMethod.POST)
    public EventAdditionalInfos getSpecificEventAdditionalInfo(@RequestBody Map<String,String> body)
    {
        return service.getSpecificEventAdditionalInfo(Integer.parseInt(body.get("infoId")),
                Integer.parseInt(body.get("eventId")));
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addEventAdditionalInfo(@RequestBody Map<String,String> body)
    {
        EventAdditionalInfos infos = new EventAdditionalInfos();
        infos.setEventId(Integer.parseInt(body.get("eventId")));
        infos.setInfoContent(body.get("infoContent"));
        infos.setInfoId(Integer.parseInt(body.get("infoId")));
        return service.addEventAdditionalInfo(infos);
    }
}
