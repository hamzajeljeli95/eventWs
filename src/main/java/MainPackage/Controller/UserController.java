package MainPackage.Controller;

import MainPackage.Beans.AppUser;
import MainPackage.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping(value = "/Users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/connect", method = RequestMethod.POST)
    public boolean login(@RequestBody Map<String,String> body) throws IOException
    {
        return userService.login(body.get("username"),body.get("passwordHash"));
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public AppUser getUserInfos(@RequestBody Map<String,String> body) throws IOException {
        return userService.getUserInfos(body.get("username"));
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public boolean signup(@RequestBody Map<String,String> body) {
        AppUser newUser= new AppUser();
        newUser.setUsername(body.get("username"));
        newUser.setPasswordHash(body.get("passwordHash"));
        newUser.setProfile(Integer.parseInt(body.get("profile")));
        newUser.setIsConfirmed(Integer.parseInt(body.get("isConfirmed")));
        return userService.signup(newUser);
    }
}
