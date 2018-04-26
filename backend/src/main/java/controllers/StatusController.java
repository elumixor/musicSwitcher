package controllers;

import org.springframework.web.bind.annotation.*;

/**
 * Status controller
 */
@RestController
public class StatusController extends ControllerBase {

    /**
     * Get current status
     * @return Status as string
     */
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public @ResponseBody
    String status() {
        return this.statusProvider.getStatus();
    }

    /**
     * Set/update status
     * @param status New status
     * @return Updated status
     */
    @RequestMapping(value = "/status", method = RequestMethod.POST)
    public @ResponseBody
    String status(@RequestBody String status) {
        return this.statusProvider.getStatus();
    }
}