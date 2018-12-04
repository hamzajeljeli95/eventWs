package MainPackage.Controller;

import MainPackage.Beans.UserAdditionalInfos;
import MainPackage.Service.UserAdditionalInfosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/UAI")
public class UserAdditionalInfosController {

    @Autowired
    UserAdditionalInfosService infosService;

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public UserAdditionalInfos getAdditionalInfo(@RequestBody Map<String,String> body)
    {
        return infosService.getAdditionalInfo(Integer.parseInt(body.get("infoId")),body.get("userId"));
    }

    @RequestMapping(value = "/getAllByUser", method = RequestMethod.POST)
    public List<UserAdditionalInfos> getUserAdditionalInfos(@RequestBody Map<String,String> body)
    {
        return infosService.getUserAdditionalInfos(body.get("userId"));
    }

    @RequestMapping(value = "/set", method = RequestMethod.POST)
    public boolean setUserAdditionalInfo(@RequestBody Map<String,String> body)
    {
        return infosService.setUserAdditionalInfo(Integer.parseInt(body.get("infoId")),body.get("userId"),body.get("content"));
    }
}
