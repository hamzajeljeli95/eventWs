package MainPackage.Controller;

import MainPackage.Beans.EventInfo;
import MainPackage.Service.EventInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/eventInfos")
public class EventInfoController {

    @Autowired
    EventInfoService service;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public List<EventInfo> getAll() {
        return service.getAll();
    }
}
